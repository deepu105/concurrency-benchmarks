use std::fs;
use std::io::prelude::*;
use std::net::TcpListener;
use std::net::TcpStream;
use std::thread;
use std::time::Duration;
extern crate futures;
use futures::executor::ThreadPool;

fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").unwrap();

    let pool = ThreadPool::new().expect("couldn't create threadpool");
    let mut count = 0;

    for stream in listener.incoming() {
        let stream = stream.unwrap();
        count = count + 1;
        let count_n = Box::new(count);

        pool.spawn_ok(async {
            handle_connection(stream, count_n).await;
        });
    }
}

async fn handle_connection(mut stream: TcpStream, count: Box<i64>) {
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();

    if (*count % 10) == 0 {
        println!("Adding delay. Count: {}", count);
        thread::sleep(Duration::from_secs(2));
    }

    let (status_line, filename) = ("HTTP/1.1 200 OK\r\n\r\n", "hello.html");
    let contents = fs::read_to_string(filename).unwrap();

    let response = format!("{}{}", status_line, contents);

    stream.write(response.as_bytes()).unwrap();
    stream.flush().unwrap();
}
