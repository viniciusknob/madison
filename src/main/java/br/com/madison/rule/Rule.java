package br.com.madison.rule;

public abstract class Rule {
	
	private String _descriptionError;
	
	protected void setDescriptionError(String descriptionError) {
		_descriptionError = descriptionError;
	}
	
	public String descriptionError() {
		return _descriptionError;
	}
	
	public abstract boolean check();

}
