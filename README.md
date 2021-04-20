# Casa do Código

## Tecnologias:

Java 11

Sprigboot 2.4.5

Maven

MySQL

Spring JPA



## Restrições:

* Sem utilização de bibiliotecas de conversão de objetos de entrada para objetos de domínios, como Lombok.
* Sem criação de classes de serviço.
* Somente 2 setter por classe @Entity ou qualque outra anotação JPA.



## Implementações

### Cadastro novo autor

#### Tag: v1.2

#### Atributos

* nome
* email
* descrição
* hora do registro

#### Restrições

- O instante não pode ser nulo
- O email é obrigatório
- O email tem que ter formato válido
- O nome é obrigatório
- A descrição é obrigatória e não pode passar de 400 caracteres

#### Resultado esperado

- Um novo autor criado e status 200 retornado

------

### Email único para autor

#### Tag: v1.3

#### Necessidades

- O email do autor precisa ser único no sistema

#### Resultado esperado

- Erro de validação no caso de email duplicado

------

### Cadastro de uma classe

#### Tag: v1.4

#### Necessidades

- Toda categoria precisa de um nome

#### Restrições

- O nome é obrigatório
- O nome não pode ser duplicado

#### Resultado esperado

- Uma nova categoria cadastrada no sistema e status 200 retorno
- Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação

### Criação de validador genérico

#### Tag: v1.4.1

#### Necessidades

- Tanto para o cadastro do autor quanto para o cadastro da categoria, foi necessário realizar uma validação de valor único no sistema. Neste caso, só muda um detalhe da query que estamos executando para fazer a verificação. E agora, será que você consegue criar seu validador customizado para reutilizá-lo nas validações de email de autor e nome de categoria?