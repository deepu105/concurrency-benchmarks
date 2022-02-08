# Concurrency in modern programming languages

This is the code samples used for my blog series https://deepu.tech/concurrency-in-modern-languages/

The benchmarks are run using [wrk](https://github.com/wg/wrk) and [drill](https://github.com/fcsonline/drill).

Scripts and benchmark results can be found in the results/nosleep folder

Previously the benchmarks were run using ApacheBench

## Java

```shell
# multi-thread version
cd javaws && java src/JavaHTTPServer.java

# Java Async version
cd javaws && java src/JavaAsyncHTTPServer.java

# Java Undertow version
cd java_undertow && mvn clean install && java -jar target/hello-java-1.0.0-SNAPSHOT.jar
```

## Go

```shell
# HTTP server
cd gows && go run main.go

# TCP version
cd gows_tcp && go run main.go
```

## Rust

```shell
# multi-thread version
cd rustws && cargo run --release

# async version
cd rustws_async && cargo run --release

# async thread version
cd rustws_async_thread && cargo run --release

# async tokio version
cd rustws_async_tokio && cargo run --release

# async actix-web version
cd rust_actixweb && cargo run --release
```

## JS

```shell
# async version
cd jsws && node main.js

# multi-thread version
cd jsws_thread && node main.js

```

## TS

```shell
# async version
cd tsws && deno run --allow-all main.ts
```

## .NET

```shell
# async version
cd dotnetws && dotnet run
```
