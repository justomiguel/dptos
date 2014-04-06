package com.dptosweb.service;


/**
 * An exception that is thrown by classes wanting to trap unique 
 * constraint violations.  This is used to wrap Spring's 
 * DataIntegrityViolationException so it's checked in the web layer.
 *
 * @author <a href="mailto:justomiguelvargas@gmail.com">Justo Vargas</a>
 */
public class LocalidadExistsException extends Exception {
    private static final long serialVersionUID = 4050483051788154162L;

    /**
     * Constructor for UserExistsException.
     *
     * @param message exception message
     */
    public LocalidadExistsException(final String message) {
        super(message);
    }
}
