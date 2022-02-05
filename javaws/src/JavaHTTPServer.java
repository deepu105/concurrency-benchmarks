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
        var file = new File("hello.html");
        try (
                // get the input stream
                var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // get character output stream to client (for headers)
                var out = new PrintWriter(socket.getOutputStream());
                // get binary output stream to client (for requested data)
                var dataOut = new BufferedOutputStream(socket.getOutputStream());
                var fileIn = new FileInputStream(file)
        ) {
            // read the request first to avoid connection reset errors
            while (true) {
                String requestLine = in.readLine();
                if (requestLine == null || requestLine.length() == 0) {
                    break;
                }
            }

            // read the HTML file
            var fileLength = (int) file.length();
            var fileData = new byte[fileLength];
            fileIn.read(fileData);

            var contentMimeType = "text/html";
            // send HTTP Headers
            out.println("HTTP/1.1 200 OK");
            out.println("Content-type: " + contentMimeType);
            out.println("Content-length: " + fileLength);
            out.println("Connection: keep-alive");

            out.println(); // blank line between headers and content, very important!
            out.flush(); // flush character output stream buffer

            dataOut.write(fileData, 0, fileLength); // write the file data to output stream
            dataOut.flush();
        } catch (Exception ex) {
            System.err.println("Error with exception : " + ex);
        }
    }
}
