# Results from [wrk](https://github.com/wg/wrk)

Benchmark using wrk with below command (Threads 8, Connections 500, duration 30 seconds):

```
wrk -t8 -c500 -d30s http://127.0.0.1:8080
```

## rustws

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.74ms   17.62ms 417.65ms   99.04%
    Req/Sec    15.30k     1.09k   20.06k    71.25%
  3655041 requests in 30.03s, 1.06GB read
  Socket errors: connect 0, read 3655041, write 0, timeout 0
Requests/sec: 121713.41
Transfer/sec:     36.10MB
```

0:42.34 real, 16.19 user, 118.53 sys, 0 amem, 18604 mmem

## rustws-async

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    11.07ms   73.90ms   1.67s    96.63%
    Req/Sec     7.71k     2.72k   23.27k    74.52%
  1838968 requests in 30.01s, 498.07MB read
  Socket errors: connect 0, read 1838968, write 0, timeout 2
Requests/sec:  61281.66
Transfer/sec:     16.60MB
```

0:45.58 real, 57.98 user, 155.48 sys, 0 amem, 21400 mmem

## rustws-async-thread

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.02ms   10.42ms 416.32ms   99.33%
    Req/Sec    15.51k     1.25k   19.90k    76.08%
  3704936 requests in 30.02s, 1.04GB read
  Socket errors: connect 0, read 3704936, write 0, timeout 0
Requests/sec: 123398.12
Transfer/sec:     35.30MB
```

0:50.19 real, 18.32s user, 119.39s sys, 274%? cpu, 0 amem, 18788 mmem

## rustws-async-tokio

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.83ms    1.52ms  27.26ms   79.90%
    Req/Sec    13.53k     0.95k   17.76k    69.42%
  3237034 requests in 30.07s, 0.90GB read
  Socket errors: connect 0, read 3237034, write 0, timeout 0
Requests/sec: 107636.72
Transfer/sec:     30.80MB
```

0:40.05 real, 47.78s user, 153.48s sys, 502%? cpu, 0 amem, 18728 mmem

## gows

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.24ms    1.13ms  27.64ms   85.19%
    Req/Sec    56.54k     3.24k   75.13k    63.50%
  13502707 requests in 30.01s, 1.52GB read
Requests/sec: 449928.66
Transfer/sec:     51.92MB
```

102.74user 84.25system 0:52.82elapsed 354%CPU (0avgtext+0avgdata 80460maxresident)k
192inputs+256outputs (5major+68290minor)pagefaults 0swaps

## gows-tcp

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.22ms  470.03us  18.50ms   77.43%
    Req/Sec     9.89k   480.39    11.88k    73.38%
  2362294 requests in 30.02s, 628.55MB read
  Socket errors: connect 0, read 2362294, write 0, timeout 0
Requests/sec:  78699.24
Transfer/sec:     20.94MB
```

0:35.41 real, 46.42s user, 87.54s sys, 378%? cpu, 0 amem, 50012 mmem

## javaws

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     8.18ms   60.97ms   1.67s    98.79%
    Req/Sec     3.93k     2.02k   10.41k    62.63%
  937698 requests in 30.02s, 232.51MB read
  Socket errors: connect 0, read 937736, write 0, timeout 39
Requests/sec:  31237.01
Transfer/sec:      7.75MB
```

0:44.56 real, 38.64s user, 54.41s sys, 208%? cpu, 0 amem, 310836 mmem
java.net.SocketException: Broken pipe errors

## javaws-async

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    10.94ms   75.97ms   1.98s    96.94%
    Req/Sec    15.21k     5.64k   35.90k    74.82%
  3624339 requests in 30.01s, 0.94GB read
  Socket errors: connect 0, read 3624338, write 0, timeout 80
Requests/sec: 120756.04
Transfer/sec:     32.02MB
```

0:41.11 real, 21.55s user, 51.79s sys, 178%? cpu, 0 amem, 767292 mmem

## jsws

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    19.75ms    3.54ms  88.57ms   93.32%
    Req/Sec     3.16k   336.35     3.76k    74.75%
  755176 requests in 30.03s, 211.02MB read
Requests/sec:  25150.68
Transfer/sec:      7.03MB
```

0:39.72 real, 29.90s user, 13.82s sys, 110%? cpu, 0 amem, 119500 mmem

## jsws-thread

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.40ms    1.89ms  57.76ms   87.13%
    Req/Sec    14.45k     1.27k   17.42k    86.21%
  3451123 requests in 30.03s, 0.94GB read
Requests/sec: 114930.69
Transfer/sec:     32.11MB
```

0:39.62 real, 0.07s user*, 0.02s sys*, 0%? cpu, 0 amem, 37144 mmem

## tsws

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    15.69ms   12.87ms 474.75ms   99.52%
    Req/Sec     4.04k   627.73     9.81k    96.12%
  964728 requests in 30.03s, 289.81MB read
  Socket errors: connect 0, read 1, write 0, timeout 0
Requests/sec:  32125.96
Transfer/sec:      9.65MB
```

0:39.50 real, 26.85s user, 16.68s sys, 110%? cpu, 0 amem, 104132 mmem

## rustws-actixweb

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   644.09us  359.35us  33.75ms   99.42%
    Req/Sec    97.21k     5.03k  114.82k    65.04%
  23212163 requests in 30.02s, 1.73GB read
Requests/sec: 773286.63
Transfer/sec:     59.00MB
```

69.68user 111.18system 1:33.94elapsed 192%CPU (0avgtext+0avgdata 420620maxresident)k
0inputs+25344outputs (0major+208570minor)pagefaults 0swaps

## javaws-undertow

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   716.54us    1.53ms  68.55ms   98.87%
    Req/Sec    99.75k    11.73k  125.95k    85.67%
  23822173 requests in 30.02s, 2.86GB read
Requests/sec: 793456.47
Transfer/sec:     97.61MB
```

51.23user 113.95system 1:15.60elapsed 218%CPU (0avgtext+0avgdata 706944maxresident)k
0inputs+0outputs (0major+176746minor)pagefaults 0swaps

## dotnet

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.28ms    1.18ms  51.33ms   98.25%
    Req/Sec    50.88k     3.42k   55.13k    96.21%
  12150853 requests in 30.02s, 1.38GB read
Requests/sec: 404750.49
Transfer/sec:     47.09MB
```

106.67user 81.16system 0:55.43elapsed 338%CPU (0avgtext+0avgdata 195416maxresident)k
0inputs+584outputs (12major+87136minor)pagefaults 0swaps
