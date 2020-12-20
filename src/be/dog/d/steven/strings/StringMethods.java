package be.dog.d.steven.strings;

import java.util.*;

public class StringMethods {

    /**
     * REVERSE STRING
     * @param str String to be reversed
     * @return The reverse of str
     */
    public static String reverseString(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    /**
     * RETURN NUMBER OF UNIQUE CHARACTERS IN ALPHABET
     * @param str String to be checked for unique characters
     * @return Number of unique characters in the string.
     */
    public static int numberOfLettersUsed(String str) {
        HashSet<Character> chars = new HashSet<>();
        str = str.toLowerCase().replaceAll("[^a-z]","");
        for (int i = 0; i < str.length()-1; i++) {
            chars.add(str.charAt(i));
        }
        return chars.size();
    }

    /**
     * FILTER CHARACTERS OUT OF FIRST STRING THAT ARE CONTAINED IN SECOND STRING
     * @param toFilter String that needs to be filtered
     * @param filter String containing characters to filter
     * @return Filtered string
     */
    public static String removeCharsContainedInSecondString(String toFilter, String filter) {
        HashSet<Character> filterSet = new HashSet<>();
        for (int i = 0; i < filter.length(); i++) {
            filterSet.add(filter.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < toFilter.length(); i++) {
            if(!filterSet.contains(toFilter.toLowerCase().charAt(i))){
                builder.append(toFilter.charAt(i));
            }
        }
        return builder.toString();
    }

    /**
     * GET THE HIGHEST FREQUENCY CHARACTER AND FREQUENCY
     * @param str String to check for highest frequency character
     * @return A map entry with a highest frequency character and its frequency
     */
    public static Map.Entry<Character, Integer> highestFrequencyCharacter(String str) {
        HashMap<Character,Integer> frequencies = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(frequencies.containsKey(str.charAt(i))){
                frequencies.put(str.charAt(i),frequencies.get(str.charAt(i))+1);
            }else{
                frequencies.put(str.charAt(i),1);
            }
        }
        Optional<Map.Entry<Character, Integer>> highest = frequencies.entrySet().stream().max(Map.Entry.comparingByValue());
        return highest.get();
    }

    /**
     * CHECK IF TWO STRINGS ARE ROTATIONS OF EACH OTHER
     * @param original String to compare possible rotation to
     * @param rotation  String that will be checked for being a rotation of original
     * @return True or False
     */
    public static boolean isRotation(String original, String rotation) {
        if (original.length() != rotation.length()){
            return false;
        }else {
            String twiceOriginal = original + original;
            return twiceOriginal.contains(rotation); // or .indexOf(rotation) != -1
        }
    }
}
