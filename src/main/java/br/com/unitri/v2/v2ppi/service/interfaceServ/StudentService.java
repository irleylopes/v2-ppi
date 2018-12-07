package br.com.unitri.v2.v2ppi.service.interfaceServ;

import br.com.unitri.v2.v2ppi.domain.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student, Long disciplineId);

    Student findById(Long id);

    Student update(Student student, Long id);

    void delete(Long id);

    List<Student> findAll(Long disciplineId);
}
