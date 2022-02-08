import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaHTTPServer {
    public static void main(String[] args) {
        // bind listener
        try (var serverSocket = new ServerSocket(8080, 100)) {
            System.out.println("Server is listening on port 8080");
            while (true) {
                // listen to all incoming requests and spawn each connection in a new thread
                new ServerThread(serverSocket.accept()).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }
}

class ServerThread extends Thread {

    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                // get the input stream
                var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // get character output stream to client (for headers)
                var out = new PrintWriter(socket.getOutputStream());
        ) {
            // read the request first to avoid connection reset errors
            while (true) {
                String requestLine = in.readLine();
                if (requestLine == null || requestLine.length() == 0) {
                    break;
                }
            }

            var data = "Hello";

            var contentMimeType = "text/html";
            // send HTTP Headers
            out.println("HTTP/1.1 200 OK");
            out.println("Content-type: " + contentMimeType);
            out.println("Content-length: " + data.length());
            out.println("Connection: keep-alive");

            out.println(); // blank line between headers and content, very important!
            out.println(data);
            out.flush(); // flush character output stream buffer

        } catch (Exception ex) {
            System.err.println("Error with exception : " + ex);
        }
    }
}
