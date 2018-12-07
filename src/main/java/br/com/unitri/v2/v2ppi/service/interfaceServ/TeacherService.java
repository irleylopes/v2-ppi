package br.com.unitri.v2.v2ppi.service.interfaceServ;


import br.com.unitri.v2.v2ppi.domain.Teacher;

public interface TeacherService {

    Teacher findById(Long id);

    void createUser(String username, String rawPassword);

    Teacher findByUsername(String username);

    Teacher create(Teacher client, String rawPassword);
}