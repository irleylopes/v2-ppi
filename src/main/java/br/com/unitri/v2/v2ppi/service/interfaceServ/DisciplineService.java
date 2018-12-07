package br.com.unitri.v2.v2ppi.service.interfaceServ;

import br.com.unitri.v2.v2ppi.domain.Discipline;

import java.util.List;

public interface DisciplineService {

    Discipline create(Discipline client);

    Discipline findById(Long id);

    Discipline update(Discipline client, Long id);

    void delete(Long id);

    List<Discipline> findAll(String name);
}
