#![deny(warnings)]

use std::convert::Infallible;
use std::fs;
use std::thread;
use std::time::Duration;

use hyper::service::{make_service_fn, service_fn};
use hyper::{Body, Request, Response, Server};

async fn hello(_: Request<Body>) -> Result<Response<Body>, Infallible> {
    let contents = fs::read_to_string("hello.html").unwrap(); // read html file

    Ok(Response::new(Body::from(contents)))
}

#[tokio::main]
pub async fn main() -> Result<(), Box<dyn std::error::Error + Send + Sync>> {
    // For every connection, we must make a `Service` to handle all
    // incoming HTTP requests on said connection.
    // let mut count = 0;
    let make_svc = make_service_fn(|_conn| {
        // This is the `Service` that will handle the connection.
        // `service_fn` is a helper to convert a function that
        // returns a Response into a `Service`.
        async {
            // count = count + 1;
            // if (count % 10) == 0 {
            //     println!("Adding delay. Count: {}", count);
            thread::sleep(Duration::from_secs(2));
            // }
            Ok::<_, Infallible>(service_fn(hello))
        }
    });

    let addr = ([127, 0, 0, 1], 8080).into();

    let server = Server::bind(&addr).serve(make_svc);

    println!("Listening on http://{}", addr);

    server.await?;

    Ok(())
}
