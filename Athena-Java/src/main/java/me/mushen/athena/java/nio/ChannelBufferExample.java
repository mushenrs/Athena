package me.mushen.athena.java.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-29
 */
public class ChannelBufferExample {

    public static void main(String[] args){
        ChannelBufferExample example = new ChannelBufferExample();
        example.readFileToBuffer("/tmp/aliyun.txt");

        IntBuffer buffer = IntBuffer.allocate(64);
        buffer.put(1024);
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
    }

    /**
     * 使用FileChannel从文件读取数据到Buffer中
     * @param filePath 文件路径
     */
    private void readFileToBuffer(String filePath) {
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();

        try(RandomAccessFile rwFile = new RandomAccessFile(filePath, "rw");
            // Channel, close after use
            FileChannel channel = rwFile.getChannel()){

            // Create Buffer with capacity of 1024 bytes
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer = CharBuffer.allocate(1024);

            int byteReads;
            // read into Buffer.
            while((byteReads = channel.read(byteBuffer)) != -1){
                System.out.println("Read: " + byteReads);
                // Make ByteBuffer ready for read
                byteBuffer.flip();
                // Use 'UTF-8' decode bytes
                decoder.decode(byteBuffer, charBuffer, false);
                // Make CharBuffer ready for read
                charBuffer.flip();

                System.out.println(charBuffer);

                // Make Buffer ready for writing
                byteBuffer.clear();
                charBuffer.clear();
            }
        }catch(Exception e){
            e.printStackTrace(System.err);
        }

    }
}
