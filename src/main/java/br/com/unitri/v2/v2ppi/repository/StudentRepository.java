package br.com.unitri.v2.v2ppi.repository;

import br.com.unitri.v2.v2ppi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
