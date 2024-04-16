package com.mtt.rnt.exception;

public class CertificadoMigradoException extends Exception {
    private static final long serialVersionUID = 5871923558274961052L;

    public CertificadoMigradoException(String msg) {
        super(msg);
    }

    public CertificadoMigradoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
