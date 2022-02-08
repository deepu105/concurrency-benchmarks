## Best results

These are the best results during comparisons

### Rust

#### Multi-threaded

```console
Document Length:        176 bytes
Concurrency Level:      100
Time taken for tests:   20.038 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2830000 bytes
HTML transferred:       1760000 bytes
Requests per second:    499.05 [#/sec] (mean)
Time per request:       200.380 [ms] (mean)
Time per request:       2.004 [ms] (mean, across all concurrent requests)
Transfer rate:          137.92 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:     0  200 600.0      0    2000
Waiting:        0  200 600.0      0    2000
Total:          0  200 600.0      0    2002

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%   2000
  95%   2000
  98%   2000
  99%   2000
 100%   2002 (longest request)
```

#### Asynchronous

```console
Document Length:        176 bytes
Concurrency Level:      100
Time taken for tests:   20.037 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2830000 bytes
HTML transferred:       1760000 bytes
Requests per second:    499.08 [#/sec] (mean)
Time per request:       200.369 [ms] (mean)
Time per request:       2.004 [ms] (mean, across all concurrent requests)
Transfer rate:          137.93 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:     0  200 600.0      0    2001
Waiting:        0  200 600.0      0    2001
Total:          0  200 600.0      0    2002

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%   2000
  95%   2000
  98%   2000
  99%   2000
 100%   2002 (longest request)
```

#### Asynchronous multi-threaded

```console
Document Length:        176 bytes
Concurrency Level:      100
Time taken for tests:   20.039 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      3030000 bytes
HTML transferred:       1760000 bytes
Requests per second:    499.03 [#/sec] (mean)
Time per request:       200.391 [ms] (mean)
Time per request:       2.004 [ms] (mean, across all concurrent requests)
Transfer rate:          147.66 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:     0  200 600.0      0    2000
Waiting:        0  200 600.0      0    2000
Total:          0  200 600.0      0    2002

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%   2000
  95%   2000
  98%   2000
  99%   2000
 100%   2002 (longest request)
```

#### Asynchronous multi-threaded with Tokio

```console
Document Length:        176 bytes
Concurrency Level:      100
Time taken for tests:   20.051 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      3030000 bytes
HTML transferred:       1760000 bytes
Requests per second:    498.72 [#/sec] (mean)
Time per request:       200.512 [ms] (mean)
Time per request:       2.005 [ms] (mean, across all concurrent requests)
Transfer rate:          147.57 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:     0  200 600.2      0    2003
Waiting:        0  200 600.2      0    2003
Total:          0  200 600.2      0    2004

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%   2000
  95%   2001
  98%   2001
  99%   2002
 100%   2004 (longest request)
```

### Go

When GC hits there is an added 2 seconds overall and I'm ignoring those

#### Asynchronous TCP

```console
Document Length:        174 bytes
Concurrency Level:      100
Time taken for tests:   20.047 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2780000 bytes
HTML transferred:       1740000 bytes
Requests per second:    498.83 [#/sec] (mean)
Time per request:       200.468 [ms] (mean)
Time per request:       2.005 [ms] (mean, across all concurrent requests)
Transfer rate:          135.43 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:     0  200 600.0      0    2002
Waiting:        0  200 600.1      0    2002
Total:          0  200 600.0      0    2004

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      1
  90%   2000
  95%   2000
  98%   2000
  99%   2001
 100%   2004 (longest request)
```

#### Asynchronous HTTP

```console
Document Length:        174 bytes
Concurrency Level:      100
Time taken for tests:   20.049 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2910000 bytes
HTML transferred:       1740000 bytes
Requests per second:    498.79 [#/sec] (mean)
Time per request:       200.486 [ms] (mean)
Time per request:       2.005 [ms] (mean, across all concurrent requests)
Transfer rate:          141.75 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:     0  200 599.8      0    2002
Waiting:        0  200 599.8      0    2002
Total:          0  200 599.8      0    2003

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%      4
  95%   2000
  98%   2000
  99%   2001
 100%   2003 (longest request)
```

### Java

#### Multi-threaded

```console
Document Length:        176 bytes
Concurrency Level:      100
Time taken for tests:   20.053 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2600000 bytes
HTML transferred:       1760000 bytes
Requests per second:    498.67 [#/sec] (mean)
Time per request:       200.533 [ms] (mean)
Time per request:       2.005 [ms] (mean, across all concurrent requests)
Transfer rate:          126.62 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.2      0       2
Processing:     0  200 600.0      0    2004
Waiting:        0  200 600.0      0    2004
Total:          0  200 600.0      0    2004

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      1
  90%   2000
  95%   2000
  98%   2000
  99%   2001
 100%   2004 (longest request)
```

#### Asynchronous

```console
Document Length:        176 bytes
Concurrency Level:      100
Time taken for tests:   20.037 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2770000 bytes
HTML transferred:       1760000 bytes
Requests per second:    499.07 [#/sec] (mean)
Time per request:       200.374 [ms] (mean)
Time per request:       2.004 [ms] (mean, across all concurrent requests)
Transfer rate:          135.00 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       2
Processing:     0  200 600.0      0    2000
Waiting:        0  200 600.0      0    2000
Total:          0  200 600.0      0    2001

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%   2000
  95%   2000
  98%   2000
  99%   2000
 100%   2001 (longest request)
```

### Node.js

#### Multi-threaded

```console
Document Length:        174 bytes
Concurrency Level:      100
Time taken for tests:   20.088 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2540000 bytes
HTML transferred:       1740000 bytes
Requests per second:    497.80 [#/sec] (mean)
Time per request:       200.882 [ms] (mean)
Time per request:       2.009 [ms] (mean, across all concurrent requests)
Transfer rate:          123.48 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       2
Processing:     0  200 599.7      0    2007
Waiting:        0  200 599.7      0    2007
Total:          0  200 599.7      0    2007

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      1
  80%      1
  90%      7
  95%   2000
  98%   2001
  99%   2001
 100%   2007 (longest request)
```

#### Asynchronous HTTP

```console
Document Length:        174 bytes
Concurrency Level:      100
Time taken for tests:   20.117 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      2540000 bytes
HTML transferred:       1740000 bytes
Requests per second:    497.09 [#/sec] (mean)
Time per request:       201.172 [ms] (mean)
Time per request:       2.012 [ms] (mean, across all concurrent requests)
Transfer rate:          123.30 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       2
Processing:     0  201 599.8      0    2003
Waiting:        0  200 599.9      0    2003
Total:          0  201 599.8      0    2004

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      1
  75%      1
  80%      2
  90%   1998
  95%   2000
  98%   2001
  99%   2001
 100%   2004 (longest request)
```

### Deno Asynchronous HTTP

```console
Document Length:        174 bytes
Concurrency Level:      100
Time taken for tests:   20.393 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      3150000 bytes
HTML transferred:       1740000 bytes
Requests per second:    490.37 [#/sec] (mean)
Time per request:       203.927 [ms] (mean)
Time per request:       2.039 [ms] (mean, across all concurrent requests)
Transfer rate:          150.85 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       5
Processing:     0  202 600.3      1    2029
Waiting:        0  202 600.3      1    2029
Total:          0  202 600.3      1    2029

Percentage of the requests served within a certain time (ms)
  50%      1
  66%      1
  75%      2
  80%      3
  90%   2001
  95%   2002
  98%   2002
  99%   2003
 100%   2029 (longest request)
```