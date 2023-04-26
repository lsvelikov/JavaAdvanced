package JavaAdvanced.StreamsFiles.Exe;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount_06 {

    public static void main(String[] args) throws IOException {

        String wordsPath = "C:\\Users\\User\\LyuboTim\\First-Steps-In-Coding-Lab\\src\\JavaAdvanced\\StreamsFiles\\Exe\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        List<String> wordsLine = Files.readAllLines(Path.of(wordsPath));

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String line : wordsLine) {
            String[] words = line.split("\\s+");
            Arrays.stream(words).forEach(word -> wordsMap.put(word, 0));
        }

        String textPath = "C:\\Users\\User\\LyuboTim\\First-Steps-In-Coding-Lab\\src\\JavaAdvanced\\StreamsFiles\\Exe\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLines = Files.readAllLines(Path.of(textPath));

        for (String line : allLines) {
            line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (wordsMap.containsKey(word)){
                    wordsMap.put(word, wordsMap.get(word) + 1);
                }
            }
        }
        PrintWriter writer = new PrintWriter("result.txt");
        wordsMap.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
