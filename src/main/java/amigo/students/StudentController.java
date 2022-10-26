package amigo.students;

import amigo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "students")
    public List<Student> listStudent() {

        return studentService.listStudent();
    }

    @PostMapping(path = "item")
    public List<Student> add(@RequestBody Student student) {
        studentService.add(student);
        return studentService.listStudent();
    }

    @PutMapping(path = "putt")
    public void put(@RequestBody Student student) {
        studentService.update(student);
    }
}
