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
reader.close();


        for (List<String> group : anagrams.values()) {
            if (group.size() > 1) {
                System.out.println(group);
            }
        }
         BufferedWriter writer = new BufferedWriter(new FileWriter("theAnagrams.tex"));

        char currentLetter = 0;

        for (List<String> group : anagrams.values()) {

            if (group.size() > 1) {

                Collections.sort(group);

                char firstLetter = group.get(0).charAt(0);

                if (firstLetter != currentLetter) {
                    currentLetter = firstLetter;

                    writer.write("\n\\vspace{14pt}\n");
                    writer.write("\\noindent\\textbf{\\Large " +
                            Character.toUpperCase(firstLetter) +
                            "}\\\\*[+12pt]\n");
                }

                writer.write(String.join(" ", group) + "\\\\\n");
            }
        }

        writer.close();

        System.out.println("theAnagrams.tex file created.");
    }
}

    }
}
