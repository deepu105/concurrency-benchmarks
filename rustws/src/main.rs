use rustws::ThreadPool;
use std::fs;
use std::io::prelude::*;
use std::net::TcpListener;
use std::net::TcpStream;

fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").unwrap(); // bind listener
    let pool = ThreadPool::new(100); // same number as max concurrent requests

    // listen to all incoming request streams
    for stream in listener.incoming() {
        let stream = stream.unwrap();
        pool.execute(move || {
            handle_connection(stream); // spawning each connection in a new thread
        });
    }
}

fn handle_connection(mut stream: TcpStream) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();

    let header = "
Connection: keep-alive
Content-Length: 5
Content-Type: text/html; charset=utf-8
Transfer-Encoding: chunked
    ";

    let response = format!("HTTP/1.1 200 OK\r\n{}\r\n\r\n{}", header, "Hello");

    stream.write(response.as_bytes()).unwrap(); // write response
    stream.flush().unwrap();
}
