package a3algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static a3algorithms.Normaliser.normalise;
public class AdvancedTextFileReader {

    public static final String START_MARKER = "**START";
    public static final String STOP_MARKER  = "**STOP";

    AdvancedTextFileReader() {}

    /**
     *  Done: advancedReadFile: read all the words of a file between two specific lines.
     *  Process lines in order.
     *  Skip all lines up to and including the start marker.
     *  Process every line (in order) up to but excluding the stop marker.
     *  Process these lines the same as BasicTextFileReader.readFile().
     *  Sample file: input/advanced-01-portion.txt
     *
     * @param filename
     * @return
     */

    public static List<String> advancedReadFile(String filename) {
        final String charsToDelete = "[^A-Za-z0-9'\\s]+";
        List<String> uniqueWords = new ArrayList<>();
        boolean started = false;

        try (final Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                // Skip lines until the start marker
                if (started == false) {
                    if (line.contains(START_MARKER)) {
                        started = true;
                    }
                } else {
                    if (line.contains(STOP_MARKER)) {
                        break;
                    }

                    // Process the line
                    line = normalise(line.replaceAll(charsToDelete, "").toLowerCase());
                    String[] wordsInLine = line.split("\\s+");

                    // Add the unique words to the list
                    for (String word : wordsInLine) {
                        if (!word.isEmpty() && !uniqueWords.contains(word)) {
                            uniqueWords.add((word));
                        }
                    }
                }
            }
        } catch ( FileNotFoundException e ) {
            throw new RuntimeException(e);
        }

        return uniqueWords;
    }
}
