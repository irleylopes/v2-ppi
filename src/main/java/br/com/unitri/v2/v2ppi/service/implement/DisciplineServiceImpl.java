package br.com.unitri.v2.v2ppi.service.implement;

import br.com.unitri.v2.v2ppi.models.entity.Discipline;
import br.com.unitri.v2.v2ppi.repository.DisciplineRepository;
import br.com.unitri.v2.v2ppi.service.interfaceServ.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public Discipline create(Discipline discipline) {
        discipline = disciplineRepository.save(discipline);
        return discipline;
    }

    @Override
    public Discipline findById(Long id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        return discipline.get();
    }

    @Override
    public Discipline update(Discipline discipline, Long id) {
        discipline.setId(id);
        discipline = disciplineRepository.save(discipline);
        return discipline;
    }

    @Override
    public void delete(Long id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    public List<Discipline> findAll() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        return disciplines;
    }
}
