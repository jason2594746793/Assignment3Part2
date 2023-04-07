package a3algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static a3algorithms.Normaliser.normalise;
public class BasicTextFileReader {

    BasicTextFileReader() {}

    /**
     *  Done: readFile: read all the words of a file.
     *  Process lines in order.
     *  Remove charsToDelete.
     *  Split each line into its words.
     *  Add a normalised version of each word but only if it is not already present.
     *  Do not add "words" that are blank.
     *  Sample input: input/*.txt
     *
     * @param filename
     * @return
     */
    public static List<String> readFile(String filename) {
        final String charsToDelete = "[^A-Za-z0-9'\\s]+";
        List<String> uniqueWords = new ArrayList<>();

        try ( final Scanner sc = new Scanner(new File(filename)) ) {
            while ( sc.hasNextLine() ) {
                String line = sc.nextLine();

                // Process the line
                line = normalise(line.replaceAll(charsToDelete, ""));
                String[] words = line.split("\\s+");

                // Add the unique words to the list
                for (String word : words){
                    if (!uniqueWords.contains(word) && !word.equals("")){
                        uniqueWords.add(word);
                    }
                }
            }

        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        }

        return uniqueWords;
    }

}
