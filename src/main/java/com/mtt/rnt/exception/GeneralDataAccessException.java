package com.mtt.rnt.exception;

public class GeneralDataAccessException extends Exception{

    private static final long serialVersionUID = 1L;

    public static final String SAVE_ERROR = "SAVE_ERROR";
    public static final String UPDATE_ERROR = "UPDATE_ERROR";
    public static final String DELETE_ERROR = "DELETE_ERROR";
    public static final String GET_ERROR = "GET_ERROR";

    public GeneralDataAccessException(String msg) {
        super(msg);
    }

    public GeneralDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public GeneralDataAccessException(Throwable cause) {
        super(cause);
    }

}
