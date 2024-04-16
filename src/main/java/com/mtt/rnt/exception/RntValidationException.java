package com.mtt.rnt.exception;

/**
 * Clase para excepciones de validación.
 *
 * @author CesarOsses
 */
public class RntValidationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1316095990884256833L;

	/**
     * Constructor.
     *
     * @param message mensaje error
     */
    public RntValidationException(String message) {
        super(message);
    }
}
