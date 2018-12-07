package br.com.unitri.v2.v2ppi.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String cpf;

    @OneToMany(mappedBy = "teacher")
    private List<Discipline> disciplines;

    public Teacher(String username, String cpf) {
        this.username = username;
        this.cpf = cpf;
    }

    public Teacher(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}