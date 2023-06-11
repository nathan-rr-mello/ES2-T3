package app

import (
	"net/http"
	"student-registration-service/model"

	"github.com/gin-gonic/gin"
)

func (s *Server) health(c *gin.Context) {
	c.String(http.StatusOK, "hello from student registration service")
}

func (s *Server) validateStudent(c *gin.Context) {
	var student model.Student
	if err := c.ShouldBindJSON(&student); err != nil {
		c.AbortWithError(http.StatusBadRequest, err)
	}
	c.Set("student", student)
	c.Next()
}

func (s *Server) saveStudent(c *gin.Context) {
	student, _ := c.MustGet("student").(model.Student)
	if err := s.studentRepository.Save(&student); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{
			"error": err,
		})
		return
	}
	c.JSON(http.StatusCreated, student)
}
