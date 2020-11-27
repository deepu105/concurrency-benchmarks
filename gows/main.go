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
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) { // set router
		defer r.Body.Close()
		count++
		// add 2 second delay to every 10th request
		if (count % 10) == 0 {
			println("Adding delay. Count: ", count)
			time.Sleep(2 * time.Second)
		}
		html, _ := ioutil.ReadFile("hello.html") // read html file
		w.WriteHeader(200)                       // 200 OK
		fmt.Fprintf(w, string(html))             // send data to client side
	})
	err := http.ListenAndServe(":8080", nil) // set listen port
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}
