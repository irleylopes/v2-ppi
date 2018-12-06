package br.com.unitri.v2.v2ppi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unitri.v2.v2ppi.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByCpf(String cpf);

    Optional<Teacher> findById(Long id);

    Optional<Teacher> findByUsername(String username);
}
