## rustws

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       654647
Fetch base                Failed requests           345353
Fetch base                Median time per request   59ms
Fetch base                Average time per request  41ms
Fetch base                Sample standard deviation 36ms

Time taken for tests      41.1 seconds
Total requests            1000000
Successful requests       654647
Failed requests           345353
Requests per second       24336.48 [#/sec]
Median time per request   59ms
Average time per request  41ms
Sample standard deviation 36ms
```

1.55user 16.55system 1:21.24elapsed 22%CPU (0avgtext+0avgdata 18932maxresident)k
0inputs+0outputs (0major+4933minor)pagefaults 0swaps

## rustws-async

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       658918
Fetch base                Failed requests           341082
Fetch base                Median time per request   62ms
Fetch base                Average time per request  43ms
Fetch base                Sample standard deviation 35ms

Time taken for tests      43.1 seconds
Total requests            1000000
Successful requests       658918
Failed requests           341082
Requests per second       23214.54 [#/sec]
Median time per request   62ms
Average time per request  43ms
Sample standard deviation 35ms
```

7.89user 22.06system 1:36.47elapsed 31%CPU (0avgtext+0avgdata 21456maxresident)k
0inputs+0outputs (0major+6799minor)pagefaults 0swaps

## rustws-async-thread

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       656244
Fetch base                Failed requests           343756
Fetch base                Median time per request   59ms
Fetch base                Average time per request  41ms
Fetch base                Sample standard deviation 36ms

Time taken for tests      41.4 seconds
Total requests            1000000
Successful requests       656244
Failed requests           343756
Requests per second       24141.03 [#/sec]
Median time per request   59ms
Average time per request  41ms
Sample standard deviation 36ms
```

1.19user 11.29system 1:32.50elapsed 13%CPU (0avgtext+0avgdata 19000maxresident)k
0inputs+0outputs (0major+5191minor)pagefaults 0swaps

## rustws-async-tokio

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       0
Fetch base                Failed requests           1000000
Fetch base                Median time per request   22ms
Fetch base                Average time per request  24ms
Fetch base                Sample standard deviation 6ms

Time taken for tests      35.4 seconds
Total requests            1000000
Successful requests       0
Failed requests           1000000
Requests per second       28209.77 [#/sec]
Median time per request   22ms
Average time per request  24ms
Sample standard deviation 6ms
```

0.04user 0.03system 0:02.18elapsed 3%CPU (0avgtext+0avgdata 18732maxresident)k
0inputs+0outputs (0major+5562minor)pagefaults 0swaps

## javaws

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       959709
Fetch base                Failed requests           40291
Fetch base                Median time per request   75ms
Fetch base                Average time per request  74ms
Fetch base                Sample standard deviation 47ms

Time taken for tests      62.3 seconds
Total requests            1000000
Successful requests       959709
Failed requests           40291
Requests per second       16043.71 [#/sec]
Median time per request   75ms
Average time per request  74ms
Sample standard deviation 47ms
```

49.65user 78.28system 2:25.90elapsed 87%CPU (0avgtext+0avgdata 775968maxresident)k
0inputs+0outputs (0major+2140423minor)pagefaults 0swaps

## javaws-async

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       978431
Fetch base                Failed requests           21569
Fetch base                Median time per request   68ms
Fetch base                Average time per request  68ms
Fetch base                Sample standard deviation 37ms

Time taken for tests      57.1 seconds
Total requests            1000000
Successful requests       978431
Failed requests           21569
Requests per second       17527.57 [#/sec]
Median time per request   68ms
Average time per request  68ms
Sample standard deviation 37ms
```

13.58user 33.65system 1:14.03elapsed 63%CPU (0avgtext+0avgdata 796904maxresident)k
0inputs+0outputs (0major+194116minor)pagefaults 0swaps

## gows-tcp

```
Concurrency 2000
Iterations 1000000
Rampup 2
Base URL http://localhost:8080


Fetch base                Total requests            1000000
Fetch base                Successful requests       0
Fetch base                Failed requests           1000000
Fetch base                Median time per request   21ms
Fetch base                Average time per request  22ms
Fetch base                Sample standard deviation 4ms

Time taken for tests      32.6 seconds
Total requests            1000000
Successful requests       0
Failed requests           1000000
Requests per second       30677.81 [#/sec]
Median time per request   21ms
Average time per request  22ms
Sample standard deviation 4ms
```
