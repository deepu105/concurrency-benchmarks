# Concurrency in modern programming languages

This is the code samples used for my blog series https://deepu.tech/concurrency-in-modern-languages/

The benchmarks were run using ApacheBench

## Java

```shell
cd javaws && java src/JavaHTTPServer.java

# in a new terminal
ab -c 100 -n 10000 http://localhost:8080/
```

## Go

```shell
cd gows && go run main.go

# in a new terminal
ab -c 100 -n 10000 http://localhost:8080/
```

## Rust

```shell
cd rustws_async && cargo run --release

# in a new terminal
ab -c 100 -n 10000 http://localhost:8080/
```

## JS

```shell
cd jsws && node main.js

# in a new terminal
ab -c 100 -n 10000 http://localhost:8080/
```

## TS

```shell
cd tsws && deno run --allow-all main.ts

# in a new terminal
ab -c 100 -n 10000 http://localhost:8080/
```
