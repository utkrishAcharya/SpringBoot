package myApplication.service;

import myApplication.appController.StudentController;
import myApplication.exception.AppException;
import myApplication.model.Student;

public interface StudentService {
    public StudentController addNewStudent(Student student) throws AppException;
    public StudentController updateStudentInfo(StudentController student) throws AppException;
    public StudentController getStudentInfo(String studentId ) throws AppException;
    public void deleteStudent(String studentId) throws AppException;
}
