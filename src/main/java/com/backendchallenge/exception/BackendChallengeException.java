package com.backendchallenge.exception;


/**
 * @author 
 *
 * Custom Exception class for com.BackendChallengeException.
 */
public class BackendChallengeException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessge;

    private String errorCode;


    public BackendChallengeException(String errorCode, String errorMessge) {
        this.errorCode = errorCode;
        this.errorMessge = errorMessge;
    }

    public BackendChallengeException(String s, String errorMessge, String errorCode) {
        super(s);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public BackendChallengeException(String s, Throwable throwable, String errorMessge, String errorCode) {
        super(s, throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public BackendChallengeException(Throwable throwable, String errorMessge, String errorCode) {
        super(throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public BackendChallengeException(Throwable e) {
        super(e);
    }



    public String getErrorMessge() {
        return errorMessge;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
