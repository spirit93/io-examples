package edu.netcracker.lectures.examples.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadSample {

    private static final String INPUT_FILE_PATH = "reader.txt";
    private static final int BYTE_BUFFER_LENGTH = 1024;

    public static void main(final String[] args) {
        System.out.println(new FileChannelReadSample().readFile());
    }

    private String readFile() {
        final StringBuilder contents = new StringBuilder();
        try (final FileChannel fileChannel = new FileInputStream(new File(INPUT_FILE_PATH)).getChannel()) {
            final ByteBuffer buffer = createBuffer();
            while (fileChannel.read(buffer) != -1) {
                contents.append(new String(buffer.array()));
                buffer.clear();
            }
        } catch (IOException e) {
            //do something
        }

        return contents.toString();
    }

    private ByteBuffer createBuffer() {
        return ByteBuffer.allocate(BYTE_BUFFER_LENGTH);
    }
}
