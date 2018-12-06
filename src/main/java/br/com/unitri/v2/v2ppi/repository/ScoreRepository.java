package br.com.unitri.v2.v2ppi.repository;

import br.com.unitri.v2.v2ppi.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
