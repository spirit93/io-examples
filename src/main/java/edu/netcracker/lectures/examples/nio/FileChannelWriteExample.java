package edu.netcracker.lectures.examples.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWriteExample {
    private static final String OUTPUT_FILE_PATH = "file_channel.txt";
    private static final String CONTENTS = "Hello World!";

    public static void main(final String[] args) {
        new FileChannelWriteExample().writeFile();
    }

    public void writeFile() {
        try (final FileChannel fileChannel = new FileOutputStream(OUTPUT_FILE_PATH).getChannel()) {
            final ByteBuffer buffer = createBuffer(CONTENTS.getBytes().length);
            buffer.put(CONTENTS.getBytes());
            buffer.flip();

            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to file", e);
        }
    }

    private ByteBuffer createBuffer(final int length) {
        return ByteBuffer.allocate(length);
    }
}
