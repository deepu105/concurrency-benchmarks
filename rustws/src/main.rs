use rustws::ThreadPool;
use std::fs;
use std::io::prelude::*;
use std::net::TcpListener;
use std::net::TcpStream;
use std::thread;
use std::time::Duration;

fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").unwrap();
    let pool = ThreadPool::new(100);

    let mut count = 0;

    for stream in listener.incoming() {
        let stream = stream.unwrap();
        count = count + 1;
        pool.execute(move || {
            handle_connection(stream, count);
        });
    }
}

fn handle_connection(mut stream: TcpStream, count: i64) {
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();

    if (count % 10) == 0 {
        println!("Adding delay. Count: {}", count);
        thread::sleep(Duration::from_secs(2));
    }

    let (status_line, filename) = ("HTTP/1.1 200 OK\r\n\r\n", "hello.html");
    let contents = fs::read_to_string(filename).unwrap();

    let response = format!("{}{}", status_line, contents);

    stream.write(response.as_bytes()).unwrap();
    stream.flush().unwrap();
}
