package br.com.unitri.v2.v2ppi.models.response;

public class TeacherResponse {

    private Long id;

    private String username;

    public TeacherResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public TeacherResponse() {
    }

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

    @Override
    public String toString() {
        return "TeacherResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
