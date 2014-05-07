package com.dptosweb.service;

public class DepartamentoExistsException extends Exception{
	
	private static final long serialVersionUID = 4602919381022417928L;

	/**
     * Constructor for DepartamentoExistsException.
     *
     * @param message exception message
     */
    public DepartamentoExistsException(final String message) {
        super(message);
    }
}
