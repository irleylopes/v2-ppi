package br.com.unitri.v2.v2ppi.repository;

import br.com.unitri.v2.v2ppi.domain.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    @Query(value = "SELECT * FROM discipline WHERE teacher_id = ?1", name =
            "findTeacher", nativeQuery = true)
    List<Discipline> findDisciplineByTeacherId(Long teacherId);
}
