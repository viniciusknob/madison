package br.com.madison.specification;

public class SpecificationNotSatisfiedException extends Exception {

	private static final long serialVersionUID = 890534243141671899L;

	public SpecificationNotSatisfiedException() {}

	public SpecificationNotSatisfiedException(String message) {
		super(message);
	}

	public SpecificationNotSatisfiedException(Throwable cause) {
		super(cause);
	}

	public SpecificationNotSatisfiedException(String message, Throwable cause) {
		super(message, cause);
	}

}