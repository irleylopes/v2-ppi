package br.com.unitri.v2.v2ppi.repository;

import br.com.unitri.v2.v2ppi.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student WHERE discipline_id = ?1", name =
            "findDiscipline", nativeQuery = true)
    List<Student> findByDiscipline(Long disciplineId);
}
