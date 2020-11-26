use std::fs;
use std::net::TcpListener;
use std::net::TcpStream;
use std::thread;
use std::time::Duration;

extern crate smol;
use smol::{io, prelude::*, Async};

fn main() -> io::Result<()> {
    let mut count = 0;

    smol::block_on(async {
        let listener = Async::<TcpListener>::bind(([127, 0, 0, 1], 8080))?;

        loop {
            count = count + 1;
            let count_n = Box::new(count);
            let (stream, _) = listener.accept().await?;
            smol::spawn(async { handle_connection(stream, count_n).await }).detach();
        }
    })
}

async fn handle_connection(mut stream: Async<TcpStream>, count: Box<i64>) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).await.unwrap();

    let get = b"GET / HTTP/1.0\r\n";

    // Respond with greetings or a 404,
    // depending on the data in the request
    let (status_line, filename) = if buffer.starts_with(get) {
        if (*count % 10) == 0 {
            println!("Adding delay. Count: {}", count);
            thread::sleep(Duration::from_secs(2));
        }
        ("HTTP/1.0 200 OK\r\n\r\n", "hello.html")
    } else {
        ("HTTP/1.0 404 NOT FOUND\r\n\r\n", "404.html")
    };
    let contents = fs::read_to_string(filename).unwrap();

    // Write response back to the stream,
    // and flush the stream to ensure the response is sent back to the client
    let response = format!("{}{}", status_line, contents);
    stream.write(response.as_bytes()).await.unwrap();
    stream.flush().await.unwrap();
}
