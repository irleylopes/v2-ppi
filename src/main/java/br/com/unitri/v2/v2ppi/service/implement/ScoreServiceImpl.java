package br.com.unitri.v2.v2ppi.service.implement;

import br.com.unitri.v2.v2ppi.models.Score;
import br.com.unitri.v2.v2ppi.repository.ScoreRepository;
import br.com.unitri.v2.v2ppi.service.interfaceServ.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Score create(Score score) {
        score = scoreRepository.save(score);
        return score;
    }

    @Override
    public Score findById(Long id) {
        Optional<Score> score = scoreRepository.findById(id);
        return score.get();
    }

    @Override
    public Score update(Score score, Long id) {
        score = scoreRepository.save(score);
        return score;
    }

    @Override
    public void delete(Long id) {
        scoreRepository.deleteById(id);
    }
}
