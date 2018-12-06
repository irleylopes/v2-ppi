package br.com.unitri.v2.v2ppi.models.request;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeacherRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Pattern(regexp = "^.{3,255}$", message = "O campo deve conter no mínimo 3 caracteres")
    @NotBlank(message = "O campo deve ser informado")
    private String username;

    @CPF(message = "O CPF informado está inválido")
    private String cpf;

    @NotBlank(message = "O campo deve ser informado")
    private String password;

    @JsonCreator(mode = JsonCreator.Mode.DEFAULT)
    public TeacherRequest(
            @JsonProperty("username") String username,
            @JsonProperty("cpf") String cpf,
            @JsonProperty("password") String password
    ) {
        this.username = username;
        this.cpf = cpf;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherRequest that = (TeacherRequest) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cpf, password);
    }

    @Override
    public String toString() {
        return "TeacherRequest{" +
                "username='" + username + '\'' +
                ", cpf='" + cpf + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}