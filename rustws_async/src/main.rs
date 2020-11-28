use async_std::net::TcpListener;
use async_std::net::TcpStream;
use async_std::prelude::*;
use async_std::task;
use std::fs;
use std::time::Duration;

#[async_std::main]
async fn main() {
    let mut count = 0;

    let listener = TcpListener::bind("127.0.0.1:8080").await.unwrap(); // set listen port

    loop {
        count = count + 1;
        // Listen for an incoming connection.
        let (stream, _) = listener.accept().await.unwrap();
        // spawn a new task to handle the connection
        task::spawn(handle_connection(stream, count));
    }
}

async fn handle_connection(mut stream: TcpStream, count: i64) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).await.unwrap();

    // add 2 second delay to every 10th request
    if (count % 10) == 0 {
        println!("Adding delay. Count: {}", count);
        task::sleep(Duration::from_secs(2)).await;
    }

    let contents = fs::read_to_string("hello.html").unwrap(); // read html file

    let response = format!("{}{}", "HTTP/1.1 200 OK\r\n\r\n", contents);
    stream.write(response.as_bytes()).await.unwrap(); // write response
    stream.flush().await.unwrap();
}
