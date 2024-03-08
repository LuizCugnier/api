
# Rinha de Backend 2023

Projeto da api feita para rinha de backend de 2023, apenas para teste e conhecimento.

Realizei a implementação utilizando o framework spring boot com JPA, Spring Web e Lombok, junto com Postgres como DB.


## Stack utilizada

* Java 17
* Spring Boot
* NGINX
* PostgreSQL


## Como executar?
Para iniciar a aplicação você pode executar o seguinte comando:

```bash
  docker compose up --build
```

Para terminar a execução dos containers, execute o comando:

```bash
  docker compose down
```


## Documentação da API

#### Cria uma pessoa

```
  POST /pessoas
```
Recebendo um corpo como o exemplo abaixo.
```
{
    "apelido" : "josé",
    "nome" : "José Roberto",
    "nascimento" : "2000-10-01",
    "stack" : ["C#", "Node", "Oracle"]
}
```

#### Retorna uma pessoa com id específico

```
  GET /pessoas/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` | **Obrigatório**. O ID do usuário |

#### Retorna pessoas com o termo passado

```
  GET /pessoas?t=php
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `t`      | `string` | **Obrigatório**. Termo para busca |

#### Retorna quantidade de pessoas cadastradas

```
  GET /contagem-pessoas
```

#### Retorna todos os usuários (TESTE)

```
  GET /buscarpessoas
```
## Autor

- [@GutoCugnier](https://www.github.com/LuizCugnier)

