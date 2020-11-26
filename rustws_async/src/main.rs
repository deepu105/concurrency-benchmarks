use async_std::net::TcpListener;
use async_std::net::TcpStream;
use async_std::prelude::*;
use async_std::task;
use async_std::task::spawn;
use std::fs;
use std::time::Duration;

#[async_std::main]
async fn main() {
    let mut count = 0;

    task::block_on(async {
        let listener = TcpListener::bind("127.0.0.1:8080").await.unwrap();

        loop {
            count = count + 1;
            let count_n = Box::new(count);
            let (stream, _) = listener.accept().await.unwrap();
            spawn(handle_connection(stream, count_n));
        }
    })
}

async fn handle_connection(mut stream: TcpStream, count: Box<i64>) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).await.unwrap();

    if (*count % 10) == 0 {
        println!("Adding delay. Count: {}", count);
        task::sleep(Duration::from_secs(2)).await;
    }

    let (status_line, filename) = ("HTTP/1.1 200 OK\r\n\r\n", "hello.html");
    let contents = fs::read_to_string(filename).unwrap();

    let response = format!("{}{}", status_line, contents);
    stream.write(response.as_bytes()).await.unwrap();
    stream.flush().await.unwrap();
}
