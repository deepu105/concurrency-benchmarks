## rustws

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.96ms    3.62ms 208.19ms   99.88%
    Req/Sec    11.41k   503.50    13.21k    65.46%
  2730772 requests in 30.10s, 359.39MB read
  Socket errors: connect 0, read 2730772, write 0, timeout 0
Requests/sec:  90730.26
Transfer/sec:     11.94MB
```

6.85user 80.48system 1:03.34elapsed 137%CPU (0avgtext+0avgdata 18892maxresident)k
0inputs+0outputs (0major+4946minor)pagefaults 0swaps

## rustws-async

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    13.79ms   86.88ms   1.66s    96.47%
    Req/Sec     8.09k     2.45k   14.38k    65.12%
  1932327 requests in 30.01s, 204.55MB read
  Socket errors: connect 0, read 1932328, write 0, timeout 85
Requests/sec:  64388.42
Transfer/sec:      6.82MB
```

1.05user 11.18system 1:17.64elapsed 15%CPU (0avgtext+0avgdata 18608maxresident)k
0inputs+0outputs (0major+4930minor)pagefaults 0swaps

## rustws-async-thread

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.88ms    4.43ms 209.35ms   99.86%
    Req/Sec    12.07k   593.24    14.19k    62.04%
  2888596 requests in 30.08s, 349.86MB read
  Socket errors: connect 0, read 2888596, write 0, timeout 0
Requests/sec:  96042.83
Transfer/sec:     11.63MB
```

8.89user 81.62system 1:08.69elapsed 131%CPU (0avgtext+0avgdata 166476maxresident)k
0inputs+8440outputs (0major+40280minor)pagefaults 0swaps

## rustws-async-tokio

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.52ms    1.15ms  20.68ms   68.49%
    Req/Sec    12.13k   705.54    14.67k    67.06%
  2895641 requests in 30.03s, 350.72MB read
  Socket errors: connect 0, read 2895641, write 0, timeout 0
Requests/sec:  96437.01
Transfer/sec:     11.68MB
```

22.05user 99.13system 0:52.28elapsed 231%CPU (0avgtext+0avgdata 200444maxresident)k
0inputs+10104outputs (0major+74063minor)pagefaults 0swaps

## javaws

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    10.18ms   66.08ms   1.67s    98.06%
    Req/Sec     3.77k     1.40k    8.21k    69.08%
  901410 requests in 30.02s, 75.65MB read
  Socket errors: connect 0, read 901433, write 0, timeout 49
Requests/sec:  30028.28
Transfer/sec:      2.52MB
```

32.74user 50.58system 1:04.73elapsed 128%CPU (0avgtext+0avgdata 443400maxresident)k
0inputs+0outputs (0major+1030937minor)pagefaults 0swaps

## javaws-async

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    11.27ms   75.75ms   1.67s    96.82%
    Req/Sec    12.83k     4.19k   31.06k    68.17%
  3064947 requests in 30.01s, 306.91MB read
  Socket errors: connect 0, read 3064945, write 0, timeout 92
Requests/sec: 102122.24
Transfer/sec:     10.23MB
```

14.12user 51.94system 0:57.36elapsed 115%CPU (0avgtext+0avgdata 724112maxresident)k
0inputs+0outputs (0major+177523minor)pagefaults 0swaps

## gows-tcp

```
Running 30s test @ http://127.0.0.1:8080
  8 threads and 500 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     7.17ms  789.06us  32.79ms   89.40%
    Req/Sec     8.45k   549.95    10.28k    90.61%
  1217289 requests in 30.02s, 104.48MB read
  Socket errors: connect 0, read 1217785, write 6360431, timeout 0
Requests/sec:  40546.48
Transfer/sec:      3.48MB
```
