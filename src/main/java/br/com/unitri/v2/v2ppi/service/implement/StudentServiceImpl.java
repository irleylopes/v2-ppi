package br.com.unitri.v2.v2ppi.service.implement;

import br.com.unitri.v2.v2ppi.models.Student;
import br.com.unitri.v2.v2ppi.repository.StudentRepository;
import br.com.unitri.v2.v2ppi.service.interfaceServ.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        student = studentRepository.save(student);
        return student;
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @Override
    public Student update(Student student, Long id) {
        student = studentRepository.save(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
}
