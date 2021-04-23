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

------

### Criação de validador genérico

#### Tag: v1.4.1

#### Necessidades

- Tanto para o cadastro do autor quanto para o cadastro da categoria, foi necessário realizar uma validação de valor único no sistema. Neste caso, só muda um detalhe da query que estamos executando para fazer a verificação. E agora, será que você consegue criar seu validador customizado para reutilizá-lo nas validações de email de autor e nome de categoria?

------

### Criar um novo livro

#### Tag: v1.5

#### Necessidades

- Um título
- Um resumo do que vai ser encontrado no livro
- Um sumário de tamanho livre. O texto deve entrar no formato markdown, que é uma string. Dessa forma ele pode ser formatado depois da maneira apropriada.
- Preço do livro
- Número de páginas
- Isbn(identificador do livro)
- Data que ele deve entrar no ar(de publicação)
- Um livro pertence a uma categoria
- Um livro é de um autor

#### Restrições

- Título é obrigatório
- Título é único
- Resumo é obrigatório e tem no máximo 500 caracteres
- Sumário é de tamanho livre.
- Preço é obrigatório e o mínimo é de 20
- Número de páginas é obrigatória e o mínimo é de 100
- Isbn é obrigatório, formato livre
- Isbn é único
- Data que vai entrar no ar precisa ser no futuro
- A categoria não pode ser nula
- O autor não pode ser nulo

#### Resultado esperado

- Um novo livro precisa ser criado e status 200 retornado
- Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação

------

### Exibir lista de livros

#### Tag:  v1.6

#### **Necessidade**

Para que seja fácil pegar um id do livro, vamos exibir a lista de livros cadastrados.

#### **Resultado esperado**

Um json com a lista de livros com id e nome do livro

------

### Página de detalhes do livro

#### Tag: v1.7

#### Necessidades

- Ter um endpoint que em função de um id de livro retorne os detalhes necessários para montar a página.

#### Restrições

- Se o id não existir é para retornar 404

#### Resultado esperado

- que o front possa montar a página

------

### Cadastro de país e estados do país

#### Tag: v1.8

### **Necessidades**

Precisamos de um cadastro simples de países e seus respectivos estados.

Cada país tem um nome e cada estado tem um nome e pertence a um país.

#### Restrições para país

- o nome é obrigatório
- o nome é único

#### Restrição para estados

- o nome é obrigatório
- o nome é único para o mesmo país
- o país é obrigatório

#### Resultado esperado

- Dois endpoints para que seja possível cadastrar países e estados. Pode existir país sem estados associados.
- Caso alguma restrição não seja atendida, retornar 400 e json com os problemas de validação.