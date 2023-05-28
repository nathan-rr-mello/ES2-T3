package app

func (s *Server) initRoutes() {
	s.router.GET("/health", s.health)
	s.router.GET("/search/:id", s.getStudentById)
	s.router.GET("/search", s.getStudents)
}