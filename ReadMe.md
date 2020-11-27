# Concurrency in modern programming languages

This is the code samples used for my blog series https://deepu.tech/concurrency-in-modern-languages/

The benchmarks were run using ApacheBench

For example

```shell
cd gows && go run main.go

# in a new terminal
ab -c 100 -n 10000 http://localhost:8080/
```

or

```shell
cd rustws_async && cargo run --release

# in a new terminal
ab -c 100 -n 10000 http://localhost:8080/
```
