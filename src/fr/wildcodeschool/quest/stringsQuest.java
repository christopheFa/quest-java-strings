package fr.wildcodeschool.quest;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class stringsQuest {

    public static void printBytes(byte[] array, String name) throws UnsupportedEncodingException {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x" +
                    UnicodeFormatter.byteToHex(array[k]) + " " + new String(array, "UTF8"));
        }
    }

    public static void main(String[] args) {

        System.out.println(System.getProperty("file.encoding"));
        String original = new String("A" + "\u00ea" + "\u00f1"
                + "\u00fc" + "C " + "\u00f8" + "\u00e8" + "\u00e9" + "\u00e1" + "\u0394");

        System.out.println("original = " + original + " length = " + original.length());
        System.out.println("original uppercase = " + original.toUpperCase(Locale.ROOT));
        System.out.println("original lowercase = " + original.toLowerCase(Locale.ROOT));
        System.out.println();
        System.out.println("reverseSentenceWords : " + reverseSentenceWords(original));
        System.out.println();
        System.out.println("reverseCharacterOfSentenceWords : " + reverseCharacterOfSentenceWords(original));
        System.out.println();


        try {
            byte[] utf8Bytes = original.getBytes("UTF8");
            byte[] defaultBytes = original.getBytes();

            String roundTrip = new String(utf8Bytes, "UTF8");
            System.out.println("roundTrip = " + roundTrip + " length = " + roundTrip.length());

            System.out.println();
            printBytes(utf8Bytes, "utf8Bytes");
            System.out.println();
            printBytes(defaultBytes, "defaultBytes");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }




    static String reverseCharacter(String original) {
        String reversed = "";
        for (int i = original.length() - 1;  0 <= i; i--) {
            reversed += original.charAt(i);
        }

        return reversed;
    }

    static String reverseSentenceWords(String original) {
        String reversed = "";
        String[] result = original.split(" ");
        for (int i = result.length-1; 0 <= i; i--) {
            reversed += result[i]+" ";
        }
       return reversed.trim();
    }

    static String reverseCharacterOfSentenceWords(String original) {
        String reversed = "";
        String[] result = original.split(" ");
        for (int i = 0;  i < result.length; i++) {
            reversed += reverseCharacter(result[i])+" ";
        }
        return reversed.trim();
    }
}
