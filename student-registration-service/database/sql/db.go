package sql

import (
	"fmt"
	"os"
	"student-registration-service/model"

	"gorm.io/driver/postgres"
	//"gorm.io/driver/sqlite"
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

func (sr *StudentRepository) Save(student *model.Student) error {
	return sr.db.Create(student).Error
}
