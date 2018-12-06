package br.com.unitri.v2.v2ppi.service.interfaceServ;


import br.com.unitri.v2.v2ppi.models.entity.Teacher;
import br.com.unitri.v2.v2ppi.models.request.TeacherRequest;
import br.com.unitri.v2.v2ppi.models.response.TeacherResponse;

public interface TeacherService {

    Teacher create(Teacher client);

    TeacherResponse findById(Long id);

    TeacherResponse update(TeacherRequest client, Long id);

    void cancelUser(TeacherRequest client);

    void clientSaved(Teacher clientSave);

    void clientExist(Teacher client);

    void clientNotExist(Teacher client);
}