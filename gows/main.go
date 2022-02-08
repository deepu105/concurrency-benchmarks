package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	// set router
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		handleConnection(w)
	})
	// set listen port
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}

func handleConnection(w http.ResponseWriter) {
	w.WriteHeader(200)      // 200 OK
	fmt.Fprintf(w, "Hello") // send data to client side
}
