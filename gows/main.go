package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"runtime"
	"time"
)

func helloWorld(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello world!") // send data to client side
}

func main() {
	runtime.GOMAXPROCS(1) // limit max threads used by goroutines
	var count = 0
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		defer r.Body.Close()
		count++
		if (count % 10) == 0 {
			println("Adding delay. Count: ", count)
			time.Sleep(2 * time.Second)
		}
		html, _ := ioutil.ReadFile("hello.html")
		w.WriteHeader(200)
		fmt.Fprintf(w, string(html)) // send data to client side
	}) // set router
	err := http.ListenAndServe(":8080", nil) // set listen port
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}
