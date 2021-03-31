package com.example.covid.exception;

public class ZoneNotFoundException extends ServiceException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZoneNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZoneNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ZoneNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ZoneNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ZoneNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
