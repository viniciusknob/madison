package br.com.madison.specification;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.madison.mock.RuleCPF;

public class SpecificationTest extends Assert {

private Specification _specification;
	
	@Before
	public void before() {
		_specification = new Specification();
	}

	@Test(expected = SpecificationNotSatisfiedException.class)
	public void mustThrowException() throws SpecificationNotSatisfiedException {
		_specification.appendRule(new RuleCPF("Madison"));
		_specification.validate();
	}
	
	@Test
	public void firstStepRule() {
		_specification.appendRule(new RuleCPF(null));
		try {
			_specification.validate();
		} catch (SpecificationNotSatisfiedException e) {
			assertEquals("CPF can't be null", e.getMessage());
		}
	}
	
	@Test
	public void middleStepRule() {
		_specification.appendRule(new RuleCPF("9998887776")); // 10 digits
		try {
			_specification.validate();
		} catch (SpecificationNotSatisfiedException e) {
			assertEquals("CPF must have 11 digits", e.getMessage());
		}
	}
	
	@Test
	public void finalStepRule() {
		_specification.appendRule(new RuleCPF("11111111111"));
		try {
			_specification.validate();
		} catch (SpecificationNotSatisfiedException e) {
			assertEquals("CPF invalid", e.getMessage());
		}
	}
	
	@Test
	public void shouldFailSecondRule() {
		_specification.appendRule(new RuleCPF("93556305062"));
		_specification.appendRule(new RuleCPF(""));
		try {
			_specification.validate();
		} catch (SpecificationNotSatisfiedException e) {
			assertEquals("CPF can't be empty", e.getMessage());
		}
	}

}
