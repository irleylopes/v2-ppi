package br.com.unitri.v2.v2ppi.service.interfaceServ;

import br.com.unitri.v2.v2ppi.domain.Score;

import java.util.List;

public interface ScoreService {

    List<Score> findAll(Long studentId);

    Score create(Score score, Long studentId);

    Score findById(Long id);

    Score update(Score score, Long id);

    void delete(Long id);

}
