import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val server = ServerSocket(8080)
    println("Server is running on port ${server.localPort}")
    var count = 0

    while (true) {
        count++
        // Run client in it's own thread.
        thread {
            ClientHandler(server.accept(), count).run()
        }
    }
}

class ClientHandler(private val socket: Socket, private val cnt: Int) {
    private val out: PrintWriter = PrintWriter(socket.getOutputStream())
    private val dataOut: BufferedOutputStream = BufferedOutputStream(socket.getOutputStream())
    private val file = File("hello.html")
    private val fileIn: FileInputStream = FileInputStream(file)

    fun run() {
        try {
            // add 2 second delay to every 10th request
            if (cnt % 10 == 0) {
                println("Adding delay. Count: $cnt")
                // Thread.sleep(2000);
            }
            val fileLength = file.length().toInt()
            val fileData = ByteArray(fileLength)
            fileIn.read(fileData)
            val contentMimeType = "text/html"
            // send HTTP Headers
            out.println("HTTP/1.1 200 OK")
            out.println("Connection: keep-alive")
            out.println("Content-type: $contentMimeType")
            out.println("Content-length: $fileLength")
            out.println() // blank line between headers and content, very important !
            out.flush() // flush character output stream buffer
            dataOut.write(fileData, 0, fileLength)
            dataOut.flush()
        } catch (ex: Exception) {
            System.err.println("Error with exception : $ex")
        } finally {
            try {
                socket.close() // we close socket connection
            } catch (e: Exception) {
                System.err.println("Error closing stream : " + e.message)
            }
        }
    }
}
