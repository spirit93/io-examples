package edu.netcracker.lectures.examples.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PathFileExamples {
    public static void main(String[] args) {
        Path path = Paths.get("src");
        System.out.println(path.isAbsolute());
        System.out.println(path.toAbsolutePath().isAbsolute());
        System.out.println("File name: " + path.getFileName());
        System.out.println("Parent name: " + path.getParent());

        path = Paths.get("C:/Users/User");
        System.out.println(path.isAbsolute());
        Path startWith = Paths.get("c:/");
        System.out.println("Parent name: " + path.getParent());
        System.out.println("Start with c: " + path.startsWith(startWith));
        System.out.println("Subpath: " + path.subpath(0, 2));

        Path nonNormalizePath = Paths.get("C:/Users/../Users/User/");
        System.out.println("Path " + nonNormalizePath.toString());
        System.out.println("Normalize path: " + nonNormalizePath.normalize());

        File file = Paths.get("reader.txt").toFile();
        System.out.println("Is file: " + file.isFile());

        try {
            if (!Files.exists(Paths.get("for_demo"))) {
                Files.createDirectory(Paths.get("for_demo"));
                Files.createDirectory(Paths.get("for_demo/move"));
            } else if (!Files.exists(Paths.get("for_demo/move"))) {
                Files.createDirectory(Paths.get("for_demo/move"));
            }

            Files.write(Paths.get("for_demo/files.txt"), new byte[0],
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            Files.copy(Paths.get("for_demo/files.txt"), Paths.get("for_demo/files_copy.txt"));
            Files.move(Paths.get("for_demo/files.txt"), Paths.get("for_demo/move/files_copy.txt"));

            System.out.println("Is same: " + Files.isSameFile(Paths.get("for_demo/move/files_copy.txt"),
                    Paths.get("for_demo/files_copy.txt")));
        } catch (IOException e) {
            //do something
        }
    }
}
