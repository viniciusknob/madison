# Madison v0.1.1 Beta

Madison é um framework de regras escrito em Java. Ele segue o mesmo conceito de [seu irmão](https://github.com/viniciusknob/madison.js) da linguagem JavaScript. 


## Versionamento

`<quebra>.<novo>.<melhoria>` = `1.2.3`

- **quebra**: Indica uma alteração que modifica consideravelmente a estrutura e composição do framework, resultando em quebra de compatibilidade(resetar novo e melhoria);
- **novo**: Indica uma nova funcionalidade sem quebra de compatibilidade (resetar melhoria);
- **melhoria**: Indica uma melhoria e/ou correção de bugs sem quebra de compatibilidade.


## Como funciona

Madison necessita de regras para funcionar. As regras são na verdade a configuração de Madison. Um conjunto de verificações contemplam uma regra, e um conjunto regras contemplam uma especificação. Toda regra inserida em Madison extende Rule, uma classe abstrata que possui os métodos necessários para implementação.
						

## Como usar

Vamos usar como exemplo as verificações para validar um CPF:

	
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
- Não pode ser null
- Não pode ser empty
- Não pode ter length != 11

Então temos:


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

Observe que o erro é inserido em `setDescriptionError`. Com isso temos todas as verificações para validar um CPF centralizadas. Vamos então agora inserir essa `Rule` em uma `Specification`:


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

**Vinícius Knob**

- [http://twitter.com/viniciusknob](http://twitter.com/viniciusknob)
- [http://github.com/viniciusknob](http://github.com/viniciusknob)


## Licença

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