use std::fs;
use std::io::prelude::*;
use std::net::TcpListener;
use std::net::TcpStream;
use std::thread;
use std::time::Duration;
extern crate futures;
use futures::executor::ThreadPoolBuilder;

fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").unwrap(); // bind listener

    let mut pool_builder = ThreadPoolBuilder::new();
    pool_builder.pool_size(100);
    let pool = pool_builder.create().expect("couldn't create threadpool");
    let mut count = 0; // count used to introduce delays

    // Listen for an incoming connection.
    for stream in listener.incoming() {
        let stream = stream.unwrap();
        count = count + 1;
        let count_n = Box::new(count);

        // spawning each connection in a new thread asynchronously
        pool.spawn_ok(async {
            handle_connection(stream, count_n).await;
        });
    }
}

async fn handle_connection(mut stream: TcpStream, count: Box<i64>) {
    // Read the first 1024 bytes of data from the stream
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();

    // add 2 second delay to every 10th request
    if (*count % 10) == 0 {
        println!("Adding delay. Count: {}", count);
        thread::sleep(Duration::from_secs(2));
    }

    let header = "
    HTTP/1.0 200 OK
    Connection: keep-alive
    Content-Length: 174
    Content-Type: text/html; charset=utf-8
        ";

    let contents = fs::read_to_string("hello.html").unwrap();

    let response = format!("{}\r\n\r\n{}", header, contents);

    stream.write(response.as_bytes()).unwrap(); // write response
    stream.flush().unwrap();
}
