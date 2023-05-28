package sql

import (
	"student-registration-service/model"

	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

type StudentRepository struct {
	db *gorm.DB
}

func NewStudentRepository() (*StudentRepository, error) {
	db, err := gorm.Open(sqlite.Open("student.db"), &gorm.Config{})
	if err != nil {
		return nil, err
	}
	err = db.AutoMigrate(&model.Student{})
	if err != nil {
		return nil, err
	}
	return &StudentRepository{db}, nil
}

func (sr *StudentRepository) Save(student *model.Student) error {
	return sr.db.Create(student).Error
}
