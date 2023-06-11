package sql

import (
	"fmt"
	"os"
	"student-search-service/model"

	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

type StudentRepository struct {
	db *gorm.DB
}

func NewStudentRepository() (*StudentRepository, error) {

	host := os.Getenv("AWS_RDS_HOST")
	pass := os.Getenv("AWS_RDS_PASSWORD")

	dsn := fmt.Sprintf("host=%s user=student_user password=%s dbname=postgres port=5432 sslmode=disable",
		host,
		pass,
	)

	db, err := gorm.Open(postgres.Open(dsn), &gorm.Config{})
	if err != nil {
		return nil, err
	}
	err = db.AutoMigrate(&model.Student{})
	if err != nil {
		return nil, err
	}
	return &StudentRepository{db}, nil
}

func (sr *StudentRepository) GetAll() ([]model.Student, error) {
	var students []model.Student
	sr.db.Find(&students)
	if len(students) == 0 {
		return nil, gorm.ErrRecordNotFound
	}
	return students, nil
}

func (sr *StudentRepository) GetById(id uint) (model.Student, error) {
	var student model.Student
	err := sr.db.First(&student, id).Error
	return student, err
}

func (sr *StudentRepository) GetByName(name string) ([]model.Student, error) {
	var students []model.Student
	sr.db.Where("name LIKE ?", "%"+name+"%").Find(&students)
	if len(students) == 0 {
		return nil, gorm.ErrRecordNotFound
	}
	return students, nil
}
