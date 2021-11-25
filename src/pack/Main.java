package pack;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            Path path = Paths.get("file.txt");
            String text = "Привет NIO";
            /*
            Files.write(path, "Привет NIO".getBytes("cp1251"));
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(new String(bytes, "cp1251"));
            */
            /*
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Files.newInputStream(path), "cp1251"));
            String s;
            while ((s = reader.readLine()) !=null)
                System.out.println(s);
            */
            /*
            BufferedReader reader = Files.newBufferedReader(
                    path, Charset.forName("cp1251"));
            String s;
            while ((s = reader.readLine()) !=null)
                System.out.println(s);
            */
            /*
            Files.lines(path, Charset.forName("cp1251")).forEach(
                    System.out::println);
            */
            /*
            List<String> lines = Files.readAllLines(path, Charset.forName("cp1251"));
            System.out.println(lines);
            */
            Files.write(
                    path.toAbsolutePath().getParent().resolve("file2.txt"),
                    Collections.singleton(text),
                    Charset.forName("cp1251"),
                    StandardOpenOption.CREATE_NEW,
                    //StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND
                    );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
