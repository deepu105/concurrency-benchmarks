package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"time"
)

func main() {
	var count = 0
	// set router
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		defer r.Body.Close()
		count++
		handleConnection(w, count)
	})
	// set listen port
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}

func handleConnection(w http.ResponseWriter, count int) {
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
