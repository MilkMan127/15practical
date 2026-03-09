import java.io.*;
import java.util.*;

public class Anagrams {

    
    public static String signature(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
     public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new FileReader("ulysses.txt"));;

        HashMap<String, List<String>> anagrams = new HashMap<>();

        String line;

        while ((line = reader.readLine()) != null) {

            String[] words = line.split("\\s+");

            for (String word : words) {


                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                if (word.length() == 0)
                    continue;

                String sig = signature(word);

                anagrams.putIfAbsent(sig, new ArrayList<>());
                anagrams.get(sig).add(word);
            }
        }

