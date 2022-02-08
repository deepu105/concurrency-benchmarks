# Results from [drill](https://github.com/fcsonline/drill)

Benchmark using drill with below command for `benchmark-1.yml` (Concurrency 1000, Requests 1 million):

```
drill --benchmark benchmark.yml --stats -q
```

## rustws

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   27ms
Fetch base                Average time per request  28ms
Fetch base                Sample standard deviation 20ms

Time taken for tests      47.4 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       21090.02 [#/sec]
Median time per request   27ms
Average time per request  28ms
Sample standard deviation 20ms
```

1:23.32 real, 2.71 user, 17.45 sys, 0 amem, 18792 mmem

## rustws-async

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   28ms
Fetch base                Average time per request  29ms
Fetch base                Sample standard deviation 21ms

Time taken for tests      48.9 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       20440.27 [#/sec]
Median time per request   28ms
Average time per request  29ms
Sample standard deviation 21ms
```

1:39.59 real, 21.25 user, 48.90 sys, 0 amem, 21284 mmem

## rustws-async-thread

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   27ms
Fetch base                Average time per request  27ms
Fetch base                Sample standard deviation 20ms

Time taken for tests      46.3 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       21588.55 [#/sec]
Median time per request   27ms
Average time per request  27ms
Sample standard deviation 20ms
```

0:51.34 real, 2.96s user, 17.25s sys, 39%? cpu, 0 amem, 18680 mmem

## rustws-async-tokio

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   28ms
Fetch base                Average time per request  28ms
Fetch base                Sample standard deviation 4ms

Time taken for tests      48.2 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       20754.26 [#/sec]
Median time per request   28ms
Average time per request  28ms
Sample standard deviation 4ms
```

0:56.35 real, 14.12s user, 39.20s sys, 94%? cpu, 0 amem, 18764 mmem

## gows

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   5ms
Fetch base                Average time per request  6ms
Fetch base                Sample standard deviation 2ms

Time taken for tests      16.4 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       61099.10 [#/sec]
Median time per request   5ms
Average time per request  6ms
Sample standard deviation 2ms
```

11.92user 10.87system 1:07.74elapsed 33%CPU (0avgtext+0avgdata 85060maxresident)k
0inputs+8outputs (2major+42424minor)pagefaults 0swaps

## gows-tcp

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   28ms
Fetch base                Average time per request  28ms
Fetch base                Sample standard deviation 3ms

Time taken for tests      48.0 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       20840.23 [#/sec]
Median time per request   28ms
Average time per request  28ms
Sample standard deviation 3ms
```

0:56.00 real, 20.30s user, 30.38s sys, 90%? cpu, 0 amem, 49452 mmem

## javaws

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       996934
Fetch base                Failed requests           3066
Fetch base                Median time per request   30ms
Fetch base                Average time per request  31ms
Fetch base                Sample standard deviation 109ms

Time taken for tests      51.9 seconds
Total requests            1000000
Successful requests       996934
Failed requests           3066
Requests per second       19261.93 [#/sec]
Median time per request   30ms
Average time per request  31ms
Sample standard deviation 109ms
```

1:01.75 real, 54.08s user, 83.02s sys, 222%? cpu, 0 amem, 1119164 mmem
java.net.SocketException: Broken pipe errors

## javaws-async

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       998527
Fetch base                Failed requests           1473
Fetch base                Median time per request   21ms
Fetch base                Average time per request  23ms
Fetch base                Sample standard deviation 42ms

Time taken for tests      31.8 seconds
Total requests            1000000
Successful requests       998527
Failed requests           1473
Requests per second       31476.62 [#/sec]
Median time per request   21ms
Average time per request  23ms
Sample standard deviation 42ms
```

0:37.70 real, 17.64s user, 32.82s sys, 133%? cpu, 0 amem, 806348 mmem

## jsws

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   45ms
Fetch base                Average time per request  47ms
Fetch base                Sample standard deviation 6ms

Time taken for tests      47.8 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       20923.67 [#/sec]
Median time per request   45ms
Average time per request  47ms
Sample standard deviation 6ms
```

0:53.36 real, 48.07s user, 20.51s sys, 128%? cpu, 0 amem, 141208 mmem

## jsws-thread

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       999998
Fetch base                Failed requests           2
Fetch base                Median time per request   7ms
Fetch base                Average time per request  7ms
Fetch base                Sample standard deviation 2ms

Time taken for tests      20.2 seconds
Total requests            1000000
Successful requests       999998
Failed requests           2
Requests per second       49500.07 [#/sec]
Median time per request   7ms
Average time per request  7ms
Sample standard deviation 2ms
```

0:30.91 real, 0.09s user*, 0.03s sys*, 0%? cpu, 0 amem, 39180 mmem

## tsws

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       954707
Fetch base                Failed requests           45293
Fetch base                Median time per request   35ms
Fetch base                Average time per request  34ms
Fetch base                Sample standard deviation 9ms

Time taken for tests      35.3 seconds
Total requests            1000000
Successful requests       954707
Failed requests           45293
Requests per second       28360.73 [#/sec]
Median time per request   35ms
Average time per request  34ms
Sample standard deviation 9ms
```

0:39.51 real, 32.45s user, 17.54s sys, 126%? cpu, 0 amem, 114444 mmem

## rustws-actixweb

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   4ms
Fetch base                Average time per request  5ms
Fetch base                Sample standard deviation 16ms

Time taken for tests      13.5 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       74234.91 [#/sec]
Median time per request   4ms
Average time per request  5ms
Sample standard deviation 16ms
```

4.66user 6.77system 0:28.52elapsed 40%CPU (0avgtext+0avgdata 34028maxresident)k
0inputs+0outputs (1major+15000minor)pagefaults 0swaps

## javaws-undertow

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   5ms
Fetch base                Average time per request  5ms
Fetch base                Sample standard deviation 3ms

Time taken for tests      14.8 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       67617.47 [#/sec]
Median time per request   5ms
Average time per request  5ms
Sample standard deviation 3ms
```

6.85user 8.11system 0:34.19elapsed 43%CPU (0avgtext+0avgdata 692000maxresident)k
0inputs+0outputs (0major+180072minor)pagefaults 0swaps

## dotnet

```
Concurrency 1000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       1000000
Fetch base                Failed requests           0
Fetch base                Median time per request   8ms
Fetch base                Average time per request  8ms
Fetch base                Sample standard deviation 3ms

Time taken for tests      24.8 seconds
Total requests            1000000
Successful requests       1000000
Failed requests           0
Requests per second       40378.34 [#/sec]
Median time per request   8ms
Average time per request  8ms
Sample standard deviation 3ms
```

66.08user 41.36system 0:34.98elapsed 307%CPU (0avgtext+0avgdata 393904maxresident)k
0inputs+8outputs (3major+113980minor)pagefaults 0swaps
