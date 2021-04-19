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



## Classes

### Cadastro novo autor

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
