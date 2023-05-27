package app

func (s *Server) initRoutes() {
	s.router.GET("/health", s.health)
	s.router.POST("/register", s.validateStudent, s.saveStudent)
}