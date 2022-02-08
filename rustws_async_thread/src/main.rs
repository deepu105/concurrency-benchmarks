use std::fs;
use std::io::prelude::*;
use std::net::TcpListener;
use std::net::TcpStream;
extern crate futures;
use futures::executor::ThreadPoolBuilder;

fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").unwrap(); // bind listener

    let mut pool_builder = ThreadPoolBuilder::new();
    pool_builder.pool_size(100);
    let pool = pool_builder.create().expect("couldn't create threadpool");

    // Listen for an incoming connection.
    for stream in listener.incoming() {
        let stream = stream.unwrap();

        // spawning each connection in a new thread asynchronously
        pool.spawn_ok(async {
            handle_connection(stream).await;
        });
    }
}

async fn handle_connection(mut stream: TcpStream) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();

    let header = "
    Connection: keep-alive
    Content-Length: 5
    Content-Type: text/html; charset=utf-8
        ";

    let response = format!("HTTP/1.1 200 OK\r\n{}\r\n\r\n{}", header, "Hello");

    stream.write(response.as_bytes()).unwrap(); // write response
    stream.flush().unwrap();
}
