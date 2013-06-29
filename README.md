# Madison v0.1.1 Beta

Madison � um framework de regras escrito em Java. Ele segue o mesmo conceito de [seu irm�o](https://github.com/viniciusknob/madison.js) da linguagem JavaScript. 


## Versionamento

`<quebra>.<novo>.<melhoria>` = `1.2.3`

- **quebra**: Indica uma altera��o que modifica consideravelmente a estrutura e composi��o do framework, resultando em quebra de compatibilidade(resetar novo e melhoria);
- **novo**: Indica uma nova funcionalidade sem quebra de compatibilidade (resetar melhoria);
- **melhoria**: Indica uma melhoria e/ou corre��o de bugs sem quebra de compatibilidade.


## Como funciona

Madison necessita de regras para funcionar. As regras s�o na verdade a configura��o de Madison. Um conjunto de verifica��es contemplam uma regra, e um conjunto regras contemplam uma especifica��o. Toda regra inserida em Madison extende Rule, uma classe abstrata que possui os m�todos necess�rios para implementa��o.
						

## Como usar

Vamos usar como exemplo as verifica��es para validar um CPF:

	
```java
public class RuleCPF extends Rule {
	
	private String _target;
	
	public RuleCPF(String target) {
		_target = target;
	}

	@Override
	public boolean check() {
		/*
		 * verificacoes...
		 */
		return true;
	}
}
```
	
Considerando que um CPF:
- N�o pode ser null
- N�o pode ser empty
- N�o pode ter length != 11

Ent�o temos:


```java
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
		return true;
	}

}
```

Observe que o erro � inserido em `setDescriptionError`. Com isso temos todas as verifica��es para validar um CPF centralizadas. Vamos ent�o agora inserir essa `Rule` em uma `Specification`:


```java
Specification specification = new Specification();
specification.appendRule(new RuleCPF("93556305062"));
```

Para executar Madison, veja:


```java
try {
	specification.validate();
} catch (SpecificationNotSatisfiedException e) {
	// tratamento da mensagem
}
```
	
## Autor

**Vin�cius Knob**

- [http://twitter.com/viniciusknob](http://twitter.com/viniciusknob)
- [http://github.com/viniciusknob](http://github.com/viniciusknob)


## Licen�a

Copyright (C) 2013 Vinicius Knob
 
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.