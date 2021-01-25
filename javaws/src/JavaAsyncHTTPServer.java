import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class JavaAsyncHTTPServer {

    public static void main(String[] args) throws Exception {
        new JavaAsyncHTTPServer().start();
        Thread.currentThread().join(); // Wait forever
    }

    private void start() throws IOException {
        // we shouldn't use try with resource here as it will kill the stream
        var server = AsynchronousServerSocketChannel.open();
        var hostAddress = new InetSocketAddress("127.0.0.1", 8080);
        server.bind(hostAddress, 100);   // bind listener
        server.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        System.out.println("Server is listening on port 8080");

        final int[] count = {0}; // count used to introduce delays

        // listen to all incoming requests
        server.accept(null, new CompletionHandler<>() {
            @Override
            public void completed(final AsynchronousSocketChannel result, final Object attachment) {
                if (server.isOpen()) {
                    server.accept(null, this);
                }
                count[0]++;
                handleAcceptConnection(result, count[0]);
            }

            @Override
            public void failed(final Throwable exc, final Object attachment) {
                if (server.isOpen()) {
                    server.accept(null, this);
                    System.out.println("Connection handler error: " + exc);
                }
            }
        });
    }

    private void handleAcceptConnection(final AsynchronousSocketChannel ch, final int count) {
        var file = new File("hello.html");
        try (var fileIn = new FileInputStream(file)) {
            // add 2 second delay to every 10th request
            if (count % 10 == 0) {
                System.out.println("Adding delay. Count: " + count);
                Thread.sleep(2000);
            }
            if (ch != null && ch.isOpen()) {
                // Read the first 1024 bytes of data from the stream
                final ByteBuffer buffer = ByteBuffer.allocate(1024);
                // read the request fully to avoid connection reset errors
                ch.read(buffer).get();

                // read the HTML file
                var fileLength = (int) file.length();
                var fileData = new byte[fileLength];
                fileIn.read(fileData);

                // send HTTP Headers
                var message = ("HTTP/1.1 200 OK\n" +
                        "Connection: keep-alive\n" +
                        "Content-length: " + fileLength + "\n" +
                        "Content-Type: text/html; charset=utf-8\r\n\r\n" +
                        new String(fileData, StandardCharsets.UTF_8)
                ).getBytes();

                // write the to output stream
                ch.write(ByteBuffer.wrap(message)).get();

                buffer.clear();
                ch.close();
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            System.out.println("Connection handler error: " + e);
        }
    }
}