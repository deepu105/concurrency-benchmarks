package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net"
	"time"
)

func main() {
	var count = 0

	l, err := net.Listen("tcp", "127.0.0.1:8080") // set listen port
	if err != nil {
		log.Fatal("Error listening: ", err)
	}
	defer l.Close() // close connection when done

	for {
		count++
		// Listen for an incoming connection.
		if conn, err := l.Accept(); err != nil {
			log.Fatal("Error accepting: ", err)
		} else {
			// Handle connections in a new goroutine.
			go handleConnection(conn, count)
		}
	}
}

func handleConnection(conn net.Conn, count int) {
	// Close the connection when you're done with it.
	defer conn.Close()
	// Read the incoming connection into a buffer.
	buf := make([]byte, 1024)
	if _, err := conn.Read(buf); err != nil {
		log.Fatal("Error reading:", err)
	}

	// add 2 second delay to every 10th request
	if (count % 10) == 0 {
		println("Adding delay. Count: ", count)
		time.Sleep(2 * time.Second)
	}
	html, _ := ioutil.ReadFile("hello.html") // read html file
	// Send a response back
	res := fmt.Sprintf("%s\r\n%s\r\n\r\n%s", "HTTP/1.1 200 OK", "Connection: keep-alive", string(html))
	conn.Write([]byte(res))
}
