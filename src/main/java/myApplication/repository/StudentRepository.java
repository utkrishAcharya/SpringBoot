package myApplication.repository;

import myApplication.appController.StudentController;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends MongoRepository<StudentController, String> {

}
