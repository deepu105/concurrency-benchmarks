import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaHTTPServer {
    public static void main(String[] args) {
        var count = 0;
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                count++;
                new ServerThread(serverSocket.accept(), count).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }
}

class ServerThread extends Thread {

    private final Socket socket;
    private final int count;

    public ServerThread(Socket socket, int count) {
        this.socket = socket;
        this.count = count;
    }

    public void run() {
        var file = new File("hello.html");
        try (
                // we get character output stream to client (for headers)
                var out = new PrintWriter(socket.getOutputStream());
                // get binary output stream to client (for requested data)
                var dataOut = new BufferedOutputStream(socket.getOutputStream());
                var fileIn = new FileInputStream(file)) {
            // add 2 second delay to every 10th request
            if (count % 10 == 0) {
                System.out.println("Adding delay. Count: " + count);
                // Thread.sleep(2000);
            }
            var fileLength = (int) file.length();
            var fileData = new byte[fileLength];
            fileIn.read(fileData);

            String contentMimeType = "text/html";
            // send HTTP Headers
            out.println("HTTP/1.1 200 OK");
            out.println("Connection: keep-alive");
            out.println("Content-type: " + contentMimeType);
            out.println("Content-length: " + fileLength);
            out.println(); // blank line between headers and content, very important !
            out.flush(); // flush character output stream buffer

            dataOut.write(fileData, 0, fileLength);
            dataOut.flush();
        } catch (Exception ex) {
            System.err.println("Error with exception : " + ex);
        } finally {
            try {
                socket.close(); // we close socket connection
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }
        }
    }
}
