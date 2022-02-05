package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"sync/atomic"
	"time"
)

func main() {
	var count int32 = 0
	// set router
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		atomic.AddInt32(&count, 1)
		handleConnection(w, count)
	})
	// set listen port
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}

func handleConnection(w http.ResponseWriter, count int32) {
	// add 2 second delay to every 10th request
	if (count % 10) == 0 {
		println("Adding delay. Count: ", count)
		time.Sleep(2 * time.Second)
	}
	html, _ := ioutil.ReadFile("hello.html") // read html file
	w.Header().Add("Connection", "keep-alive")
	w.WriteHeader(200)           // 200 OK
	fmt.Fprintf(w, string(html)) // send data to client side
}
