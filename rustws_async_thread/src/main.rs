use std::time::Duration;
use tokio::{
    fs::read_to_string,
    io::{AsyncReadExt, AsyncWriteExt},
    net::{TcpListener, TcpStream},
    time::sleep,
};

#[tokio::main()] // Tokio uses a threadpool sized for #cpus by default
async fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").await.unwrap();
    let mut count = 0; // count used to introduce delays

    loop {
        count = count + 1;
        let (socket, _) = listener.accept().await.unwrap();
        // Spawn a task in the tokio threadpool
        tokio::spawn(async move { handle_connection(socket, Box::new(count)).await });
    }
}

async fn handle_connection(mut stream: TcpStream, count: Box<i64>) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).await.unwrap();

    // add 2 second delay to every 10th request
    if (*count % 10) == 0 {
        println!("Adding delay. Count: {}", count);
        sleep(Duration::from_secs(2)).await;
    }

    let header = "
    HTTP/1.0 200 OK
    Connection: keep-alive
    Content-Length: 174
    Content-Type: text/html; charset=utf-8
        ";

    let contents = read_to_string("hello.html").await.unwrap();

    let response = format!("{}\r\n\r\n{}", header, contents);

    stream.write_all(response.as_bytes()).await.unwrap(); // write response
}
