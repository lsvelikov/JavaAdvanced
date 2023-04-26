package JavaAdvanced.StreamsFiles.Exe;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles_07 {

    public static void main(String[] args) throws IOException {

        String pathOne = "C:\\Users\\User\\LyuboTim\\First-Steps-In-Coding-Lab\\src\\JavaAdvanced\\StreamsFiles\\Exe\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathTwo = "C:\\Users\\User\\LyuboTim\\First-Steps-In-Coding-Lab\\src\\JavaAdvanced\\StreamsFiles\\Exe\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        PrintWriter writer = new PrintWriter("pathThree");

        List<String> allLinesPathOne = Files.readAllLines(Path.of(pathOne));
        allLinesPathOne.forEach(line -> writer.println(line));
        List<String> allLinesPathTwo = Files.readAllLines(Path.of(pathTwo));
        allLinesPathTwo.forEach(line -> writer.println(line));
        writer.close();
    }
}
