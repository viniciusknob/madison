package br.com.madison.mock;

import br.com.madison.rule.Rule;

public class RuleCPF extends Rule {
	
	private String _target;
	
	public RuleCPF(String target) {
		_target = target;
	}

	@Override
	public boolean check() {
		if (_target == null) {
			setDescriptionError("CPF can't be null");
			return false;
		}
		if (_target.isEmpty()) {
			setDescriptionError("CPF can't be empty");
			return false;
		}
		_target = _target.replaceAll("\\D", "");
		if (_target.length() != 11) {
			setDescriptionError("CPF must have 11 digits");
			return false;
		}
		for (String invalid : invalids()) {
			if (_target.equals(invalid)) {
				setDescriptionError("CPF invalid");
				return false;
			}
		}
		/*
		 * Other validations...
		 */
		return true;
	}
	
	private String[] invalids() {
		return new String[]{"00000000000", "11111111111",
							"22222222222", "33333333333",
							"44444444444", "55555555555",
							"66666666666", "77777777777",
							"88888888888", "99999999999"};
	}

}
