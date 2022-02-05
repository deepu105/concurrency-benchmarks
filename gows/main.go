package main

import (
	"fmt"
	"io/ioutil"
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
	html, err := ioutil.ReadFile("hello.html") // read html file
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	w.WriteHeader(200)           // 200 OK
	fmt.Fprintf(w, string(html)) // send data to client side
}
