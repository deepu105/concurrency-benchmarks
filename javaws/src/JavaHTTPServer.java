import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaHTTPServer implements Runnable {

    private final Socket connect;
    private final int count;

    private JavaHTTPServer(Socket c, int cnt) {
        count = cnt;
        connect = c;
    }

    public static void main(String[] args) {
        var count = 0;
        var PORT = 8080;
        try {
            var serverConnect = new ServerSocket(PORT);
            System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
            // we listen until user halts server execution
            while (true) {
                count++;
                var myServer = new JavaHTTPServer(serverConnect.accept(), count);
                // create dedicated thread to manage the client connection
                new Thread(myServer).start();
            }
        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }

    @Override
    public void run() {
        var file = new File("hello.html");
        try (
                // we get character output stream to client (for headers)
                var out = new PrintWriter(connect.getOutputStream());
                // get binary output stream to client (for requested data)
                var dataOut = new BufferedOutputStream(connect.getOutputStream());
                var fileIn = new FileInputStream(file)
        ) {
            // add 2 second delay to every 10th request
            if (count % 10 == 0) {
                System.out.println("Adding delay. Count: " + count);
//                Thread.sleep(2000);
            }
            var fileLength = (int) file.length();
            var fileData = new byte[fileLength];
            fileIn.read(fileData);

            // send HTTP Headers
            out.println("HTTP/1.1 200 OK");
            out.println("Connection: keep-alive");
            out.println(); // blank line between headers and content, very important !
            out.flush(); // flush character output stream buffer

            dataOut.write(fileData, 0, fileLength);
            dataOut.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error with exception : " + ex);
        } finally {
            try {
                connect.close(); // we close socket connection
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }
        }
    }
}