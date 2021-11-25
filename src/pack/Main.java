package pack;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            Path path = Paths.get("file2.txt");
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
            /*
            System.out.println(Files.exists(path));
            List<OpenOption> options = new ArrayList<>();
            options.add(StandardOpenOption.CREATE);
            options.add(StandardOpenOption.APPEND);
            options.add(StandardOpenOption.DELETE_ON_CLOSE);
            //options.add(StandardOpenOption.TRUNCATE_EXISTING);
            //
            Files.write(
                    path.toAbsolutePath().getParent().resolve("file2.txt"),
                    Collections.singleton(text),
                    Charset.forName("cp1251"),
                    options.toArray(new OpenOption[0])
            );
            */
            Path path2 = path.toAbsolutePath().getParent().resolve("file2.txt");
            if (Files.exists(path2)) {
                //path2.toFile().setWritable(true);
                Files.setAttribute(path2,
                        "dos:readonly",
                        false
                );
            }
            System.out.println(Files.isWritable(path2));
            /*
            Files.copy(
                    path,
                    path2,
                    COPY_ATTRIBUTES,
                    REPLACE_EXISTING
            );
            */
            System.out.println(
                    Files.createFile(
                            path.toAbsolutePath().getParent().getParent().resolve("file2.txt"))
            );
            Files.move(
                    path,
                    path.toAbsolutePath().getParent().getParent().resolve("file2.txt"),
                    ATOMIC_MOVE
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
