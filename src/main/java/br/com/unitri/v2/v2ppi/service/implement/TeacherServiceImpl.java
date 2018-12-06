package br.com.unitri.v2.v2ppi.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import br.com.unitri.v2.v2ppi.service.interfaceServ.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import br.com.unitri.v2.v2ppi.models.Teacher;
import br.com.unitri.v2.v2ppi.repository.TeacherRepository;


@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private DataSource datasource;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.get();
    }

    @Override
    public void createUser(String username, String rawPassword){

        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(datasource);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        User userDetails = new User(username, encoder.encode(rawPassword), authorities);
        userDetailsService.createUser(userDetails);
    }

    @Override
    public Teacher findByUsername(String username){
        Optional<Teacher> clientOptional = teacherRepository.findByUsername(username);
        if(!clientOptional.isPresent()) {
            throw new RuntimeException();
        }
        Teacher client = clientOptional.get();
        return clientOptional.get();

    }

    @Override
    public Teacher create(Teacher client, String rawPassword) {
        Teacher clientSave = teacherRepository.save(client);
        createUser(client.getUsername(), rawPassword);
        return clientSave;
    }
}
