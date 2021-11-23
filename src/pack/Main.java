package pack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");

        try {
            Path path = Paths.get("file.txt");
            Files.write(path, "Привет NIO".getBytes("cp1251"));
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(new String(bytes, "cp1251"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
