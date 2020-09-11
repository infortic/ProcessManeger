# Gerencia de Tarefas

Esta API tem os seguintes Recursos: 

`Cadastro de Tarefa`
`Cadastro de Usuario`
`Serviço de Login`

## Executando e testando o projeto

### Pré-requisitos
* Java 8
* Mave
* Banco de Dados PostGres V8+
### Passo a passo
## OBS: Em caso de a porta 5001 não estar dispónivel altere-a no "application.yml" no seguinte caminho:
`\src\main\resources\application.properties`

### 1 - Baixando e instalando o PostGres

`1.a - Você pode baixar uma versão do postgres no seguinte link:`
https://www.postgresql.org/download/

importante durante a instalação selecione o drive JDBC, pois o mesmo é necessario para o java reconhecer o banco de dados.

Apos o download o processo de instalação é bastante simples e ituitivo, mas em caso de duvidas este material poderá ser consultado: 

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

acesse o 

Por exemplo, a string de conexão com o banco `postgres` rodando local na porta `8084`
seria `jdbc:postgresql://localhost:5432/recrutamento`. Para configurar usuário `postgres` e senha `cleiton` uma configuração
válida seria a abaixo:

```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/recrutamento    
    username: postgres     
    password: cleiton

```
#### 3 - Buildar e executar a aplicação

Dentro do diretório root da aplicação executar os passos abaixo.

3.1 Para rodar os testes:

##Obs para rodar os testes lembre-se que o maven precisa estar instalado. 

`$ mvn test #Para rodar os testes`

3.2 Para buildar a aplicação:
`$ mvn clean install #buildando o pacote da aplicação`

3.3 Para executar a aplicação:

O Maven através do `spring-boot-maven-plugin` gera o jar executável.
Então basta entrar no diretório `target/` e executar:

`$ java -jar octoevents-0.0.1-SNAPSHOT.jar`

A partir deste ponto se tudo ocorrer corretamente a aplicação estará rodando 
e atendendo requisições através da porta cadastrada no arquivo `application.yml` (se não foi alterado estará na porta 8080).

É possível utilizar o client do swagger através da url [http://localhost:8084/swagger-ui.html]


#### 4 Criar o tunel para acessar os endpoints externamente

Utilizamos o `ngrok` para criar uma ponte para da nossa API externamente.

Faça o download do ngrok no seguinte link: https://ngrok.com/download 

Após o dowload execute o arquivo baixado e entre com  a seguinte linha de comando 

`$ ngrok http 8084` 

Retornarão as urls (http ou https) pelas quais se poderá acessar a aplicação externamente.

#### 5 Criar um repositório e cadastrar o webhook no github.

Cadastrar o endpoint /events como webhook e escolher a opção de escutar 
apenas os eventos de `issues`.

* Webhooks Overview: https://developer.github.com/webhooks/ 
* Creating Webhooks : https://developer.github.com/webhooks/creating/

#### 6 - Testar a aplicação
* Realizar as operações que deverão disparar eventos no repositório do Github ao qual foi cadastrado o webhook:
    1) criar nova issue
    2) Adicionar labels
    3) Adicionar Assigne
    4) Adicionar mais Assignees
    5) Criar Milestone
    6) fechar a issue.
    7) Atualizar o nome da issue.
    
* Acompanhar nos logs as chamadas realizadas.

* Utiliar um client ou Acessar a inteface web do swagger gerada pela aplicação para testar o endpoint `GET issues/{issueId}/events` 
para recuperar os eventos gravados.

**Observação:**

É possível acompanhar o `id`'s das `issues` através do payload das chamadas ao `/events` logadas, porém
a saída não está muito formatada. Alternativamente podemos buscar
os ids no banco.

É possível através da query abaixo obter estes id's.

`SELECT DISTINCT id FROM github_issue_snapshot`


## Endpoints 


`GET /issues/{issueId}/events`

`POST /events`


## Principais tecnologias e frameworks utilizados

- Java 8
- Spring Boot 2
- JUnit 5
- Mockito
- Hibernate
- Swagger
