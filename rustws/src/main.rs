use rustws::ThreadPool;
use std::fs;
use std::io::prelude::*;
use std::net::TcpListener;
use std::net::TcpStream;
use std::thread;
use std::time::Duration;

fn main() {
    let listener = TcpListener::bind("127.0.0.1:8080").unwrap();
    let pool = ThreadPool::new(8);

    let mut count = 0;

    for stream in listener.incoming() {
        let stream = stream.unwrap();
        count = count + 1;
        let count_n = Box::new(count);
        // println!("New request {}", count_n);
        pool.execute(|| {
            handle_connection(stream, count_n);
        });
    }
}

fn handle_connection(mut stream: TcpStream, count: Box<i64>) {
    let mut buffer = [0; 1024];
    // let mut reader = BufReader::new(&stream);
    // let mut msg = String::new();
    // reader.read_line(&mut msg).expect("RECEIVE FAILURE!!!");
    // println!("{}", msg);
    stream.read(&mut buffer).unwrap();

    // let get = b"GET / HTTP/1.0\r\n";
    // let sleep = b"GET /sleep HTTP/1.1\r\n";

    // let (status_line, filename) = if buffer.starts_with(get) {
    if (*count % 10) == 0 {
        println!("Adding delay. Count: {}", count);
        thread::sleep(Duration::from_secs(2));
    }
    // ("HTTP/1.0 200 OK\r\n\r\n", "hello.html")
    // } else if buffer.starts_with(sleep) {
    //     println!("Adding delay. Count: {}", count);
    //     thread::sleep(Duration::from_secs(10));
    //     ("HTTP/1.1 200 OK\r\n\r\n", body)
    // } else {
    //     // println!("Fail. Count: {}", count);
    //     ("HTTP/1.0 404 NOT FOUND\r\n\r\n", "404.html")
    // };

    // if (*count % 10) == 0 {
    //     println!("Adding delay. Count: {}", count);
    //     thread::sleep(Duration::from_secs(1));
    // }

    let (status_line, filename) = ("HTTP/1.1 200 OK\r\n\r\n", "hello.html");
    let contents = fs::read_to_string(filename).unwrap();

    let response = format!("{}{}", status_line, contents);

    stream.write(response.as_bytes()).unwrap();
    stream.flush().unwrap();
}
