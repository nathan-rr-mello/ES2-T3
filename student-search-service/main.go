package main

import (
	"log"
	"student-search-service/app"
)

func main() {
	server, err := app.NewServer()
	if err != nil {
		log.Fatal("failed to open database")
	}
	if server.Run() != nil {
		log.Fatal("could not start server")
	}
}
