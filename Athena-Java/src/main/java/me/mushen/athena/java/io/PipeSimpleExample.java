package me.mushen.athena.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-31
 */
public class PipeSimpleExample {

    public static void main(String[] args) throws IOException {
        PipeSimpleExample example = new PipeSimpleExample();
        example.simplePipe();
    }

    private void simplePipe() throws IOException {
        // Creates a piped output stream that is not yet connected to a piped input stream.
        // It must be connected to a piped input stream,
        // either by the receiver or the sender, before being used.
        final PipedOutputStream pos = new PipedOutputStream();
        // Creates a piped input stream so that it is connected to the piped output stream.
        final PipedInputStream pis = new PipedInputStream(pos);
        // connect piped output stream and piped input stream
//        pos.connect(pis);

        Thread outputThread = new Thread(() -> {
            try{
                for(int i = 0; i< 10; i++){
                    pos.write(("Hello world. Pipe Times: " + i + "!").getBytes("UTF-8"));
                    TimeUnit.SECONDS.sleep(1);
                }
                pos.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace(System.err);
            }
        });
        Thread inputThread = new Thread(() -> {
            try {
                int data;
                while((data = pis.read()) != -1){
                    char ch = (char)data;
                    System.out.print(ch);
                    if(ch == '!'){
                        System.out.println();
                    }
                }
                pis.close();
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        });

        outputThread.start();
        inputThread.start();
    }
}
