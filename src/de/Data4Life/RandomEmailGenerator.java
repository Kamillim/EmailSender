package de.Data4Life;

import java.util.Random;

public class RandomEmailGenerator {


    public static String listOfRandomEmails(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<n;i++){
            sb.append(generateEmail());
        }
        return sb.toString();
    }

    private static StringBuilder generateEmail() {
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomString = new StringBuilder();
        Random rnd = new Random();
        while (randomString.length() < 10) {
            int index = (int) (rnd.nextFloat() * validCharacters.length());
            randomString.append(validCharacters.charAt(index));
        }
        randomString.append("@gmail.com\n");
        return randomString;
    }
}
