import java.io.*
import java.net.ServerSocket
import java.net.Socket

object JavaHTTPServer {
    @JvmStatic
    fun main(args: Array<String>) {
        var count = 0 // count used to introduce delays
        // bind listener
        try {
            ServerSocket(8080, 100).use { serverSocket ->
                println("Server is listening on port 8080")
                while (true) {
                    count++
                    // listen to all incoming requests and spawn each connection in a new thread
                    ServerThread(serverSocket.accept(), count).start()
                }
            }
        } catch (ex: IOException) {
            println("Server exception: " + ex.message)
        }
    }
}

internal class ServerThread(private val socket: Socket, private val count: Int) : Thread() {
    private val file = File("hello.html")
    override fun run() {
        try {
            BufferedReader(InputStreamReader(socket.getInputStream())).use { inp ->
                // add 2 second delay to every 10th request
                if (count % 10 == 0) {
                    println("Adding delay. Count: $count")
                    sleep(2000)
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