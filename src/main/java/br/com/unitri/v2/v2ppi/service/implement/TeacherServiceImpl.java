package br.com.unitri.v2.v2ppi.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import br.com.unitri.v2.v2ppi.models.entity.Teacher;
import br.com.unitri.v2.v2ppi.models.request.TeacherRequest;
import br.com.unitri.v2.v2ppi.models.response.TeacherResponse;
import br.com.unitri.v2.v2ppi.repository.TeacherRepository;


@Service
public class TeacherServiceImpl {
    @Autowired
    private DataSource datasource;

    @Autowired
    private TeacherRepository teacherRepository;

    private void createUser(String username, String rawPassword){

        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(datasource);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        User userDetails = new User(username, encoder.encode(rawPassword), authorities);
        userDetailsService.createUser(userDetails);
    }

    public Teacher findByUsername(String username){
        Optional<Teacher> clientOptional = teacherRepository.findByUsername(username);
        if(!clientOptional.isPresent()) {
            throw new RuntimeException();
        }
        Teacher client = clientOptional.get();
        return clientOptional.get();

    }

    public Teacher create(Teacher client, String rawPassword) {
        clientExist(client);
        Teacher clientSave = teacherRepository.save(client);
        clientSaved(clientSave);
        createUser(client.getUsername(), rawPassword);
        return clientSave;
    }

    public TeacherResponse findById(Long id) {
        Optional<Teacher> clientOptional = teacherRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new RuntimeException();
        }
        Teacher client = clientOptional.get();
        return new TeacherResponse(client.getId(), client.getUsername());
    }

    public TeacherResponse update(TeacherRequest clientRequest, Long id) {
        // FIELD'S UPDATE -> NAME
        Optional<Teacher> clientOptional = teacherRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new RuntimeException();
        }
        Teacher client = clientOptional.get();
        client.setUsername(clientRequest.getUsername());
        Teacher clientSave = teacherRepository.save(client);
        clientSaved(clientSave);
        return new TeacherResponse(clientSave.getId(), clientSave.getUsername());
    }

    public void cancelUser(TeacherRequest clientRequest) {

        Teacher client = teacherRepository.findByCpf(clientRequest.getCpf());
        clientNotExist(client);
        Teacher clientSave = teacherRepository.save(client);
        clientSaved(clientSave);
    }

    public void clientSaved(Teacher clientSave) {

        if(clientSave==null) {
            throw new RuntimeException();
        }
    }

    public void clientExist(Teacher client) {
        Teacher clientE = teacherRepository.findByCpf(client.getCpf());
        if(clientE!=null) {
            throw new RuntimeException();
        }
    }

    public void clientNotExist(Teacher client)  {
        if(client==null){
            throw new RuntimeException();
        }
    }

    /*public Teacher buildClient(TeacherRequest clientRequest) {
        return new Teacher(
                clientRequest.getUsername(),
                clientRequest.getCpf(),
                clientRequest.getPassword()
        );
    }*/
}
