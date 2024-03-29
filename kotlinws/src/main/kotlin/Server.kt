import java.io.*
import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread


fun main(args: Array<String>) {
    // count used to introduce delays
    var count = 0
    // bind listener
    ServerSocket(8080, 100).use { server ->
        println("Server is running on port ${server.localPort}")
        while (true) {
            count++
            // Run client in it's own thread.
            thread {
                ClientHandler(server.accept(), count).run()
            }
        }
    }
}

class ClientHandler(private val socket: Socket, private val count: Int) {

    private val file = File("hello.html")

    fun run() {
        try {
            BufferedReader(InputStreamReader(socket.getInputStream())).use { inp ->
                // add 2 second delay to every 10th request
                if (count % 10 == 0) {
                    println("Adding delay. Count: $count")
                    Thread.sleep(2000)
                }

                // read the request first to avoid connection reset errors
                while (true) {
                    val requestLine = inp.readLine()
                    if (requestLine == null || requestLine.length == 0) {
                        break
                    }
                }

                // read the HTML file
                val fileLength = file.length().toInt()
                val fileData = ByteArray(fileLength)
                FileInputStream(file).use { fileIn ->
                    fileIn.read(fileData)
                }

                val contentMimeType = "text/html"
                // get character output stream to client (to send HTTP Headers)
                PrintWriter(socket.getOutputStream()).use { out ->
                    // send HTTP Headers
                    out.println("HTTP/1.1 200 OK")
                    out.println("Content-type: $contentMimeType")
                    out.println("Content-length: $fileLength")
                    out.println("Connection: keep-alive")
                    out.println() // blank line between headers and content, very important!
                    out.flush() // flush character output stream buffer
                    // get binary output stream to client (to send HTTP body)
                    BufferedOutputStream(
                        socket.getOutputStream()
                    ).use { dataOut ->
                        dataOut.write(fileData, 0, fileLength) // write the file data to output stream
                        dataOut.flush()
                    }
                }
            }
        } catch (ex: Exception) {
            System.err.println("Error with exception : $ex")
        }
    }
}
