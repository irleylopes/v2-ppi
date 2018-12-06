package br.com.unitri.v2.v2ppi.repository;

import br.com.unitri.v2.v2ppi.models.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
