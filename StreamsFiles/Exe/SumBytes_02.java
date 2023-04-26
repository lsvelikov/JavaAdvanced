package JavaAdvanced.StreamsFiles.Exe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes_02 {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\LyuboTim\\First-Steps-In-Coding-Lab\\src\\JavaAdvanced\\StreamsFiles\\Exe\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        byte[] allBytes = Files.readAllBytes(Path.of(path));

        long sum = 0;
        for (byte symbol : allBytes) {
            if (symbol != 10 && symbol != 13) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
