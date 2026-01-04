package myApplication.service;

import myApplication.appController.StudentController;
import myApplication.exception.AppException;
import myApplication.model.Student;
import myApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceimplement {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student addNewStudent (Student student) throws AppException {





    }

}
