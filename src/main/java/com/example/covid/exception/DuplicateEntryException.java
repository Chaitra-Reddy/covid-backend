package com.example.covid.exception;

public class DuplicateEntryException extends ServiceException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEntryException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuplicateEntryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateEntryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateEntryException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateEntryException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
