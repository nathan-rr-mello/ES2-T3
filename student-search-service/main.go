package main

import (
	"log"
	"student-search-service/app"

	"github.com/joho/godotenv"
)

func main() {
	if godotenv.Load() != nil {
		log.Fatal("failed to load env vars")
	}
	server, err := app.NewServer()
	if err != nil {
		log.Fatal("failed to open database")
	}
	if server.Run() != nil {
		log.Fatal("could not start server")
	}
}
