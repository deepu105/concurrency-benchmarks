package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net"
	"sync/atomic"
	"time"
)

func main() {
	var count int32 = 0

	l, err := net.Listen("tcp", "127.0.0.1:8080") // set listen port
	if err != nil {
		log.Fatal("Error listening: ", err)
	}
	defer l.Close() // close connection when done

	for {
		// Listen for an incoming connection.
		if conn, err := l.Accept(); err != nil {
			log.Fatal("Error accepting: ", err)
		} else {
			// Handle connections in a new goroutine.
			go handleConnection(conn, atomic.AddInt32(&count, 1))
		}
	}
}

func handleConnection(conn net.Conn, count int32) {
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
	header := `
HTTP/1.0 200 OK
Connection: keep-alive
Content-Length: 174
Content-Type: text/html; charset=utf-8
	`
	res := fmt.Sprintf("%s\r\n\r\n%s", header, string(html))
	conn.Write([]byte(res))
}
