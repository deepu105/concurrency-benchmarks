use tokio::{
    fs::read_to_string,
    io::{AsyncReadExt, AsyncWriteExt},
    net::{TcpListener, TcpStream},
};

#[tokio::main()] // Tokio uses a threadpool sized for #cpus by default
async fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").await.unwrap();

    loop {
        let (socket, _) = listener.accept().await.unwrap();
        // Spawn a task in the tokio threadpool
        tokio::spawn(async move { handle_connection(socket).await });
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

    stream.write_all(response.as_bytes()).await.unwrap(); // write response
}
