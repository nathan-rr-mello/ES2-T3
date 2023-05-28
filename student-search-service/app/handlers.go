package app

import (
	"net/http"
	"strconv"

	"github.com/gin-gonic/gin"
)

func (s *Server) health(c *gin.Context) {
	c.String(http.StatusOK, "hello from student search service")
}

func (s *Server) getStudentById(c *gin.Context) {
	id, err := strconv.Atoi(c.Param("id"))
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{
			"error": "path parameter id is expected to be a number",
		})
		return
	}

	student, err := s.studentRepository.GetById(uint(id))
	if err != nil {
		c.JSON(http.StatusNotFound, gin.H{
			"error": err.Error(),
		})
		return
	}
	c.JSON(http.StatusOK, student)
}

func (s *Server) getStudents(c *gin.Context) {

	if name := c.Query("name"); name != "" {
		students, err := s.studentRepository.GetByName(name)
		if err != nil {
			c.JSON(http.StatusBadRequest, gin.H{
				"error": err.Error(),
			})
		}
		c.JSON(http.StatusOK, students)
		return
	}

	students, err := s.studentRepository.GetAll()
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{
			"error": err.Error(),
		})
		return
	}
	c.JSON(http.StatusOK, students)
}
