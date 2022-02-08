## rustws

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   31ms
Fetch base                Average time per request  32ms
Fetch base                Sample standard deviation 18ms

Time taken for tests      53.7 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       18619.27 [#/sec]
Median time per request   31ms
Average time per request  32ms
Sample standard deviation 18ms
```

6.88user 80.98system 0:49.05elapsed 179%CPU (0avgtext+0avgdata 18796maxresident)k
0inputs+0outputs (0major+4952minor)pagefaults 0swaps

## rustws-async

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       999983
Fetch base                Failed requests           17
Fetch base                Median time per request   32ms
Fetch base                Average time per request  33ms
Fetch base                Sample standard deviation 20ms

Time taken for tests      54.8 seconds
Total requests            1000000
Successful requests       999983
Failed requests           17
Requests per second       18232.35 [#/sec]
Median time per request   32ms
Average time per request  33ms
Sample standard deviation 20ms
```

29.18user 91.32system 1:04.23elapsed 187%CPU (0avgtext+0avgdata 202240maxresident)k
0inputs+9960outputs (0major+61185minor)pagefaults 0swaps

## rustws-async-thread

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   31ms
Fetch base                Average time per request  31ms
Fetch base                Sample standard deviation 20ms

Time taken for tests      52.3 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       19119.21 [#/sec]
Median time per request   31ms
Average time per request  31ms
Sample standard deviation 20ms
```

1.65user 15.95system 1:08.76elapsed 25%CPU (0avgtext+0avgdata 18728maxresident)k
0inputs+0outputs (0major+5187minor)pagefaults 0swaps

## rustws-async-tokio

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   32ms
Fetch base                Average time per request  33ms
Fetch base                Sample standard deviation 4ms

Time taken for tests      55.2 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       18120.26 [#/sec]
Median time per request   32ms
Average time per request  33ms
Sample standard deviation 4ms
```

8.72user 32.45system 1:19.57elapsed 51%CPU (0avgtext+0avgdata 18688maxresident)k
0inputs+0outputs (0major+17863minor)pagefaults 0swaps

## javaws

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   35ms
Fetch base                Average time per request  37ms
Fetch base                Sample standard deviation 40ms

Time taken for tests      60.9 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       16422.09 [#/sec]
Median time per request   35ms
Average time per request  37ms
Sample standard deviation 40ms
```

45.93user 81.05system 1:09.50elapsed 182%CPU (0avgtext+0avgdata 759756maxresident)k
0inputs+0outputs (0major+2232026minor)pagefaults 0swaps

## javaws-async

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       999946
Fetch base                Failed requests           54
Fetch base                Median time per request   32ms
Fetch base                Average time per request  32ms
Fetch base                Sample standard deviation 34ms

Time taken for tests      54.1 seconds
Total requests            1000000
Successful requests       999946
Failed requests           54
Requests per second       18490.44 [#/sec]
Median time per request   32ms
Average time per request  32ms
Sample standard deviation 34ms
```

13.04user 33.92system 1:12.25elapsed 65%CPU (0avgtext+0avgdata 802496maxresident)k
0inputs+0outputs (0major+198289minor)pagefaults 0swaps

## gows-tcp

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   32ms
Fetch base                Average time per request  33ms
Fetch base                Sample standard deviation 4ms

Time taken for tests      55.4 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       18066.63 [#/sec]
Median time per request   32ms
Average time per request  33ms
Sample standard deviation 4ms
```
