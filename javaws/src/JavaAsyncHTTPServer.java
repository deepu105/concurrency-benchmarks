import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class JavaAsyncHTTPServer {

    public static void main(String[] args) throws Exception {
        new JavaAsyncHTTPServer().go();
        Thread.currentThread().join();//Wait forever
    }

    private void go() throws IOException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8080);
        server.bind(hostAddress);
        server.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        System.out.println("Server channel bound to port: " + hostAddress.getPort());

        if (server.isOpen()) {
            server.accept(null, new CompletionHandler<>() {
                @Override
                public void completed(final AsynchronousSocketChannel result, final Object attachment) {
                    if (server.isOpen()) {
                        server.accept(null, this);
                    }
                    handleAcceptConnection(result);
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
    }

    private void handleAcceptConnection(final AsynchronousSocketChannel ch) {
        var message = ("HTTP/1.0 200 OK\n" +
                "Connection: keep-alive\n" +
                "Content-Type: text/html; charset=utf-8\r\n\r\n" +
                "Hello Hellow").getBytes();
        var buffer = ByteBuffer.wrap(message);
        ch.write(buffer);
        try {
            ch.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}