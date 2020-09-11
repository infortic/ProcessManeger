# Gerencia de Tarefas

Esta API tem os seguintes Recursos: 

`Cadastro de Tarefa`
`Cadastro de Usuário`
`Serviço de Login`

## Executando e testando o projeto

### Pré-requisitos
* Java 8
* Mave
* Banco de Dados PostGres V8+
### Passo a passo

`Ultilize esta linha de código para baixar a branch da aplicação`

`git clone https://github.com/infortic/ProcessManeger.git`

### 1 - Baixando e instalando o PostGres

`1.a - Você pode baixar uma versão do postgres no seguinte link:`
https://www.postgresql.org/download/

importante durante a instalação selecione o drive JDBC, pois o mesmo é necessário para o java reconhecer o banco de dados.

Apos o download o processo de instalação é bastante simples e intuitivo, mas em caso de duvidas este material poderá ser consultado: 

`no Windows: `https://www.postgresqltutorial.com/install-postgresql/
`no Linux: `https://www.digitalocean.com/community/tutorials/como-instalar-e-utilizar-o-postgresql-no-ubuntu-16-04-pt 

`1.b - Criando o banco de dados`

Acesso o PGADMIN (aplicação instalada junto com o banco) e execute o seguinte query:

```
CREATE DATABASE dados
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```
`1.c - Configurando o banco na aplicação`

acesse o arquivo "application.yml" no seguinte caminho:
`\src\main\resources\application.properties`

No exemplo a baixo vemos um exemplo a baixo vemos a configuração original da aplicação com o banco de dados "dados", user "postgres" e senha "root"
```
spring.datasource.url=jdbc:postgresql://localhost:5432/dados
spring.datasource.username=postgres
spring.datasource.password=root
```
caso necessário esta configuração pode ser alterada!



#### 3 - Buildar e executar a aplicação

Dentro do diretório root da aplicação executar os passos abaixo.

3.a - Para buildar a aplicação:
` mvn clean install #buildando o pacote da aplicação`

a linha de código a cima criara uma pasta chamada `target` com a versão final da aplicação.

3.3 Para executar a aplicação:

` java -jar ProcessManeger-0.0.1.jar`

A partir deste ponto se tudo ocorrer corretamente a aplicação estará rodando 
e atendendo requisições através da porta cadastrada no arquivo `application.yml` (se não foi alterado estará na porta 5001).

É possível utilizar o client do swagger através da url [http://localhost:5001/swagger-ui.html], possibilitando a verificação dos endpoints, dos DTOs esperados, e até mesmo realizar testes de requisições. 

