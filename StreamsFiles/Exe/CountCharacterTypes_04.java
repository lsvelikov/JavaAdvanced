package JavaAdvanced.StreamsFiles.Exe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCharacterTypes_04 {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\LyuboTim\\First-Steps-In-Coding-Lab\\src\\JavaAdvanced\\StreamsFiles\\Exe\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        int othersCount = 0;
        int vowelsCount = 0;
        int marksCount = 0;

        Set<Character> vowels = getVowels();
        Set<Character> punctuationMarks = getPunctuationMarks();

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                if (symbol == ' '){
                    continue;
                }
                if (vowels.contains(symbol)){
                    vowelsCount++;
                }else if (punctuationMarks.contains(symbol)){
                    marksCount++;
                }else{
                    othersCount++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_4.txt"));
        writer.write("Vowels: " + vowelsCount);
        writer.newLine();
        writer.write("Other symbols: " + othersCount);
        writer.newLine();
        writer.write("Punctuation: " + marksCount);
        writer.close();
    }
    public static Set<Character> getPunctuationMarks(){
        Set<Character> marks = new HashSet<>();
        marks.add('!');
        marks.add('?');
        marks.add('.');
        marks.add(',');
        return marks;
    }
    public static Set<Character> getVowels(){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
