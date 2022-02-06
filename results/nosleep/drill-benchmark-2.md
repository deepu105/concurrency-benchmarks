# Results from [drill](https://github.com/fcsonline/drill)

Benchmark using drill with below command for `benchmark-2.yml` (Concurrency 2000, Requests 1 million):

```
drill --benchmark benchmark.yml --stats -q
```

## rustws

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       653300
Fetch base                Failed requests           346700
Fetch base                Median time per request   53ms
Fetch base                Average time per request  36ms
Fetch base                Sample standard deviation 33ms

Time taken for tests      36.8 seconds
Total requests            1000000
Successful requests       653300
Failed requests           346700
Requests per second       27203.10 [#/sec]
Median time per request   53ms
Average time per request  36ms
Sample standard deviation 33ms
```

0:53.73 real, 1.88 user, 11.90 sys, 0 amem, 18808 mmem

## rustws-async

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       655046
Fetch base                Failed requests           344954
Fetch base                Median time per request   55ms
Fetch base                Average time per request  38ms
Fetch base                Sample standard deviation 34ms

Time taken for tests      38.1 seconds
Total requests            1000000
Successful requests       655046
Failed requests           344954
Requests per second       26236.32 [#/sec]
Median time per request   55ms
Average time per request  38ms
Sample standard deviation 34ms
```

1:11.39 real, 13.87 user, 30.95 sys, 0 amem, 21340 mmem

## rustws-async-thread

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       653706
Fetch base                Failed requests           346294
Fetch base                Median time per request   53ms
Fetch base                Average time per request  37ms
Fetch base                Sample standard deviation 34ms

Time taken for tests      37.1 seconds
Total requests            1000000
Successful requests       653706
Failed requests           346294
Requests per second       26927.50 [#/sec]
Median time per request   53ms
Average time per request  37ms
Sample standard deviation 34ms
```

0:42.88 real, 2.08s user, 12.01s sys, 32%? cpu, 0 amem, 18676 mmem

## rustws-async-tokio

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       0
Fetch base                Failed requests           1000000
Fetch base                Median time per request   18ms
Fetch base                Average time per request  18ms
Fetch base                Sample standard deviation 3ms

Time taken for tests      27.2 seconds
Total requests            1000000
Successful requests       0
Failed requests           1000000
Requests per second       36763.34 [#/sec]
Median time per request   18ms
Average time per request  18ms
Sample standard deviation 3ms
```

0:05.39 real, 0.05s user, 0.03s sys, 1%? cpu, 0 amem, 18920 mmem

## gows

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       565
Fetch base                Failed requests           999435
Fetch base                Median time per request   11ms
Fetch base                Average time per request  11ms
Fetch base                Sample standard deviation 14ms

Time taken for tests      25.2 seconds
Total requests            1000000
Successful requests       565
Failed requests           999435
Requests per second       39760.76 [#/sec]
Median time per request   11ms
Average time per request  11ms
Sample standard deviation 14ms
```

0:31.70 real, 13.88s user, 8.20s sys, 69%? cpu, 0 amem, 88352 mmem

## gows-tcp

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       663354
Fetch base                Failed requests           336646
Fetch base                Median time per request   55ms
Fetch base                Average time per request  39ms
Fetch base                Sample standard deviation 28ms

Time taken for tests      39.5 seconds
Total requests            1000000
Successful requests       663354
Failed requests           336646
Requests per second       25313.88 [#/sec]
Median time per request   55ms
Average time per request  39ms
Sample standard deviation 28ms
```

0:43.26 real, 17.18s user, 21.26s sys, 88%? cpu, 0 amem, 49532 mmem

## javaws

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       944305
Fetch base                Failed requests           55695
Fetch base                Median time per request   66ms
Fetch base                Average time per request  65ms
Fetch base                Sample standard deviation 59ms

Time taken for tests      54.4 seconds
Total requests            1000000
Successful requests       944305
Failed requests           55695
Requests per second       18384.20 [#/sec]
Median time per request   66ms
Average time per request  65ms
Sample standard deviation 59ms
```

1:17.30 real, 58.18s user, 80.90s sys, 179%? cpu, 0 amem, 1019636 mmem
java.net.SocketException: Broken pipe errors

## javaws-async

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       961879
Fetch base                Failed requests           38121
Fetch base                Median time per request   61ms
Fetch base                Average time per request  61ms
Fetch base                Sample standard deviation 38ms

Time taken for tests      50.9 seconds
Total requests            1000000
Successful requests       961879
Failed requests           38121
Requests per second       19631.15 [#/sec]
Median time per request   61ms
Average time per request  61ms
Sample standard deviation 38ms
```

0:57.51 real, 17.77s user, 32.52s sys, 87%? cpu, 0 amem, 806404 mmem

## jsws

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       414399
Fetch base                Failed requests           585601
Fetch base                Median time per request   24ms
Fetch base                Average time per request  45ms
Fetch base                Sample standard deviation 29ms

Time taken for tests      23.2 seconds
Total requests            1000000
Successful requests       414399
Failed requests           585601
Requests per second       43072.29 [#/sec]
Median time per request   24ms
Average time per request  45ms
Sample standard deviation 29ms
```

0:54.91 real, 23.72s user, 9.21s sys, 59%? cpu, 0 amem, 146304 mmem

## jsws-thread

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       997294
Fetch base                Failed requests           2706
Fetch base                Median time per request   14ms
Fetch base                Average time per request  15ms
Fetch base                Sample standard deviation 4ms

Time taken for tests      21.7 seconds
Total requests            1000000
Successful requests       997294
Failed requests           2706
Requests per second       45983.93 [#/sec]
Median time per request   14ms
Average time per request  15ms
Sample standard deviation 4ms
```

0:27.55 real, 0.08s user*, 0.03s sys*, 0%? cpu, 0 amem, 40668 mmem

## tsws

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       597019
Fetch base                Failed requests           402981
Fetch base                Median time per request   58ms
Fetch base                Average time per request  46ms
Fetch base                Sample standard deviation 32ms

Time taken for tests      23.9 seconds
Total requests            1000000
Successful requests       597019
Failed requests           402981
Requests per second       41898.73 [#/sec]
Median time per request   58ms
Average time per request  46ms
Sample standard deviation 32ms
```

0:40.56 real, 21.18s user, 11.73s sys, 81%? cpu, 0 amem, 116280 mmem
