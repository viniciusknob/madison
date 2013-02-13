package br.com.madison.specification;

import java.util.ArrayList;
import java.util.List;

import br.com.madison.rule.Rule;

public class Specification {
	
	private List<Rule> _rules = new ArrayList<Rule>();
	
	public void appendRule(Rule rule) {
		_rules.add(rule);
	}
	
	public void validate() throws SpecificationNotSatisfiedException {
		for (Rule rule : _rules) {
			if (!rule.check())
				throw new SpecificationNotSatisfiedException(rule.descriptionError());
		}
	}
	
}
