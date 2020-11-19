package de.Data4Life.fileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtFileReaderService implements FileReaderService {
    public List<String> read(String path){
        List<String> emailList= new ArrayList<>();
        String line;
        int i=0;

        try(BufferedReader bufReader = new BufferedReader(new FileReader("test.txt"));) {
            while ((line = bufReader.readLine()) != null)   {
                i++;
                String finalLine = line;
                emailList.add(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return emailList;
    }
}
