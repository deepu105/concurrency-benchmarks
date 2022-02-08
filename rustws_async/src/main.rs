use async_std::net::TcpListener;
use async_std::net::TcpStream;
use async_std::prelude::*;
use async_std::task;
use async_std::fs;

#[async_std::main]
async fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").await.unwrap(); // bind listener

    loop {
        // Listen for an incoming connection.
        let (stream, _) = listener.accept().await.unwrap();
        // spawn a new task to handle the connection
        task::spawn(handle_connection(stream));
    }
}

async fn handle_connection(mut stream: TcpStream) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).await.unwrap();

    let header = "
Connection: keep-alive
Content-Length: 5
Content-Type: text/html; charset=utf-8
    ";
    let response = format!("HTTP/1.1 200 OK\r\n{}\r\n\r\n{}", header, "Hello");

    stream.write(response.as_bytes()).await.unwrap(); // write response
    stream.flush().await.unwrap();
}
