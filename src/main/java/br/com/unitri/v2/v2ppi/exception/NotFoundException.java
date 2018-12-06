package br.com.unitri.v2.v2ppi.exception;

public class NotFoundException extends RuntimeException {


    private String field;
    private String error;

    public NotFoundException(String error, String response, String field) {
        super(response);
        this.field = field;
        this.error = error;
    }

    public NotFoundException(String response) {
        super(response);
    }

    public String getField() {
        return this.field;
    }

    public String getError() {
        return error;
    }
}
