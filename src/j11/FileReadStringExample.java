package j11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadStringExample {

    public static void main(String[] args) throws IOException {
        Path path = Files.writeString(
                Files.createTempFile(
                        "myfile", ".txt"),
                "This was posted on JD");
        String s = Files.readString(path);
        System.out.println(s);
    }
}
