package app

import (
	"student-registration-service/database/sql"
	"student-registration-service/model"

	"github.com/gin-gonic/gin"
)

type StudentRepository interface {
	Save(*model.Student) error
}

type Server struct {
	studentRepository StudentRepository
	router            *gin.Engine
}

func NewServer() (*Server, error) {
	rep, err := sql.NewStudentRepository()
	if err != nil {
		return nil, err
	}
	return &Server{
		studentRepository: rep,
		router:            gin.Default(),
	}, nil
}

func (s *Server) Run() error {
	s.initRoutes()
	return s.router.Run(":8080")
}
