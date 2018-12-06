package br.com.unitri.v2.v2ppi.service.interfaceServ;

import br.com.unitri.v2.v2ppi.models.Score;

import java.util.List;

public interface ScoreService {

    Score create(Score score);

    Score findById(Long id);

    Score update(Score score, Long id);

    void delete(Long id);

}
