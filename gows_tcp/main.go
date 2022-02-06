package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net"
)

func main() {
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
			go handleConnection(conn)
		}
	}
}

func handleConnection(conn net.Conn) {
	// Close the connection when you're done with it.
	defer conn.Close()
	// Read the incoming connection into a buffer.
	buf := make([]byte, 1024)
	if _, err := conn.Read(buf); err != nil {
		log.Print("Error reading:", err)
	}

	html, _ := ioutil.ReadFile("hello.html") // read html file
	// Send a response back
	header := `
Connection: keep-alive
Content-Length: 174
Content-Type: text/html; charset=utf-8
	`
	res := fmt.Sprintf("HTTP/1.1 200 OK\r\n%s\r\n\r\n%s", header, string(html))
	conn.Write([]byte(res))
}
