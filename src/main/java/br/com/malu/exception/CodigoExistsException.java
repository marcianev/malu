package br.com.malu.exception;

import java.io.Serial;

public class CodigoExistsException extends Exception{
	public CodigoExistsException(String message) {
		super(message);
	}
	
	@Serial
	private static final long serialVersionUID = 1L;

}
