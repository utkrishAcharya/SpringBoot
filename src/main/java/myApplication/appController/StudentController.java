package myApplication.appController;

import myApplication.exception.AppException;
import myApplication.model.Student;
import myApplication.service.StudentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
public Response addNewStudent(@RequestBody Student student) {
        Response response = new Response();
        try{
            Student savedStudent = studentService.addNewStudent(student);
            response.setStatus("Success");
            response.setMessage("New Student Added Successfully");
            response.setData(savedStudent);

        }catch (AppException utk){
            String message = "Failed to add new Student: " + utk.getMessage();
            response.setMessage(message);
            response.setStatus("Failed");

        }
        return response;


    }

@PutMapping("/update/{studentID}")
    public String updateStudentInfo(@PathVariable("studentID")String memberId, @RequestBody Student updateStudent ) {
        return "Student info updated successfully for studentId: \" + studentId;"

}
}
