package amigo.students;

import amigo.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void delete(Student student) {
        studentRepository.deleteById(student.getId());
    }

    public void update(Student student) {
        Optional<Student> byId = studentRepository.findById(student.getId());

        if (byId.isPresent()) {
            Student item = byId.get();

            if (!student.getName().isEmpty()) {
                item.setName(student.getName());
            } if (student.getDob() != null) {
                item.setDob(student.getDob());
            }

            studentRepository.save(item);
        }

    }
}
