package de.Data4Life;

import de.Data4Life.RandomEmailGenerator;
import de.Data4Life.emailService.D4LEmailService;
import de.Data4Life.emailService.EmailService;
import de.Data4Life.fileReaderService.FileReaderService;
import de.Data4Life.fileReaderService.TxtFileReaderService;

import java.io.*;
import java.util.concurrent.*;

public class Data4Life {

    public static void main(String[] args) {
        String emails = RandomEmailGenerator.listOfRandomEmails(1000_000);

        EmailService emailService = new D4LEmailService();
        FileReaderService fileReaderService = new TxtFileReaderService();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //non-blocking operation
        CompletableFuture.runAsync(()->writeToFile(emails),executorService)
                .supplyAsync(()->fileReaderService.read("test.txt"), executorService)
                .thenAccept(emailList->emailService.sendEmail(emailList));

        executorService.shutdown();
    }


    static void writeToFile(String emails) {
        try (FileWriter bf = new FileWriter("test.txt");){
            bf.write(emails);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
