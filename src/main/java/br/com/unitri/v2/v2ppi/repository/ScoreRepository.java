package br.com.unitri.v2.v2ppi.repository;

import br.com.unitri.v2.v2ppi.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query(value = "SELECT * FROM score WHERE student_id = ?1", name =
            "findStudent", nativeQuery = true)
    List<Score> findByStudentId(Long scoreId);
}
