package JavaAdvanced.StreamsFiles.Exe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers_05 {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\LyuboTim\\First-Steps-In-Coding-Lab\\src\\JavaAdvanced\\StreamsFiles\\Exe\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_5.txt"));

        int count = 1;
        for (String line : allLines) {
            writer.write(count + ". " + line);
            writer.newLine();
            count++;
        }
        writer.close();
    }
}
