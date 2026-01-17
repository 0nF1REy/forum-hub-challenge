<p align="center">
    <img src="./resources/images/docs/logotypes/forum-hub.svg" width="300" alt="Logotipo — Forum Hub" />
</p>

<div align="center">

![Maintenance](https://img.shields.io/maintenance/yes/2025?style=for-the-badge)
![License MIT](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/status-Em%20Andamento-yellow?style=for-the-badge)
![Java 25](https://img.shields.io/badge/Java-25-blue.svg?style=for-the-badge&logo=openjdk)
![Spring Boot 4.0.1](https://img.shields.io/badge/Spring%20Boot-4.0.1-6db33f.svg?style=for-the-badge&logo=spring)
![Build com Maven](https://img.shields.io/badge/build-Maven-red.svg?style=for-the-badge&logo=apachemaven)
![Plataforma: API REST](https://img.shields.io/badge/platform-API--REST-lightgrey.svg?style=for-the-badge)

</div>

## 🧭 Guia de Navegação (Índice)

- **[💻 Sobre o Projeto](#sobre-o-projeto)**
- **[📋 Funcionalidades (CRUD de Tópicos)](#funcionalidades)**
- **[🚀 Tecnologias Utilizadas](#tecnologias)**
- **[🛠️ Como rodar o projeto](#execucao)**
- **[📌 Status do Desafio](#status)**
- **[👤 Sobre o Desenvolvedor](#sobre-o-desenvolvedor)**
- **[📚 Recursos Adicionais](#recursos-adicionais)**
- **[📜 Licença](#licenca)**

## Fórum Hub API - Challenge

## 💻 Sobre o Projeto <a name="sobre-o-projeto"></a>

O **Fórum Hub** é uma aplicação fictícia de fórum de discussões que necessita de um sistema robusto para gerenciamento de tópicos e interações entre usuários. O projeto foi desenvolvido como uma **API REST**, permitindo o cadastro, listagem, detalhamento, atualização e exclusão de tópicos, seguindo rigorosamente as boas práticas de arquitetura, validações de regras de negócio e desenvolvimento com **Spring Boot**.

A aplicação faz parte do desafio **Fórum Hub** do programa **Oracle Next Education (ONE)**, tendo como foco a construção de uma API moderna, organizada e escalável, com persistência em banco de dados relacional e preparação para futuras implementações de autenticação e autorização.

## 📋 Funcionalidades (CRUD de Tópicos) <a name="funcionalidades"></a>

A API permite as seguintes operações na URI `/topicos`:

- **Cadastro:** `POST /topicos` - Cria um novo tópico (valida duplicidade de título e mensagem).
- **Listagem:** `GET /topicos` - Retorna todos os tópicos com **Paginação** e **Ordenação** (padrão 10 itens, data asc).
  - _Filtros:_ É possível filtrar por `nomeCurso` e `ano`.
- **Detalhamento:** `GET /topicos/{id}` - Retorna os dados de um tópico específico.
- **Atualização:** `PUT /topicos/{id}` - Altera título e mensagem de um tópico existente.
- **Exclusão:** `DELETE /topicos/{id}` - Remove um tópico do banco de dados (retorna 204 No Content).

## 🚀 Tecnologias Utilizadas <a name="tecnologias"></a>

No desenvolvimento da API Rest do projeto, foi utilizado o que há de mais moderno no ecossistema Java:

<table align="center">
  <thead>
    <tr>
      <th>Logo</th>
      <th>Descrição</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td align="center">
        <a href="https://www.oracle.com/java" target="_blank">
          <img src="./resources/images/docs/logotypes/java.png" height="90" alt="Java 25">
        </a>
      </td>
      <td>Linguagem principal utilizada na API</td>
    </tr>
    <tr>
      <td align="center">
        <a href="https://spring.io/projects/spring-boot" target="_blank">
          <img src="./resources/images/docs/logotypes/spring-boot.png" height="80" alt="Spring Boot 4.0.1">
        </a>
      </td>
      <td>Framework para criação de aplicações Java modernas</td>
    </tr>
    <tr>
      <td align="center">
        <a href="https://maven.apache.org" target="_blank">
          <img src="./resources/images/docs/logotypes/maven.png" height="40" alt="Apache Maven">
        </a>
      </td>
      <td>Gerenciamento de dependências e build</td>
    </tr>
    <tr>
      <td align="center">
        <a href="https://www.postgresql.org/" target="_blank">
          <img src="./resources/images/docs/logotypes/postgre-sql.svg" height="90" alt="PostgreSQL">
        </a>
      </td>
      <td>Sistema gerenciador de banco de dados relacional</td>
    </tr>
    <tr>
      <td align="center">
        <a href="https://hibernate.org" target="_blank">
          <img src="./resources/images/docs/logotypes/hibernate.png" height="90" alt="Hibernate ORM">
        </a>
      </td>
      <td>Mapeamento objeto-relacional (ORM)</td>
    </tr>
    <tr>
      <td align="center">
        <a href="https://flywaydb.org" target="_blank">
          <img src="./resources/images/docs/logotypes/flyway.png" height="90" alt="Flyway">
        </a>
      </td>
      <td>Controle de versionamento de banco de dados</td>
    </tr>
    <tr>
      <td align="center">
        <a href="https://projectlombok.org" target="_blank">
          <img src="./resources/images/docs/logotypes/lombok.png" height="40" alt="Project Lombok">
        </a>
      </td>
      <td>Redução de código boilerplate em Java</td>
    </tr>
  </tbody>
</table>

## 🛠️ Como rodar o projeto <a name="execucao"></a>

1. Clone o repositório.
2. Certifique-se de ter o **JDK 25** instalado.
3. Configure as variáveis de ambiente no arquivo `.env`:
   - `DB_URL`: jdbc:postgresql://localhost:5432/seu_banco
   - `DB_USERNAME`: seu_usuario
   - `DB_PASSWORD`: sua_senha
   - `JWT_SECRET`: sua_chave_secreta
4. Execute o comando `mvn spring-boot:run`.
5. A API estará disponível em `http://localhost:8080`.

## 📌 Status do Desafio <a name="status"></a>

- [x] API com rotas seguindo modelo REST.
- [x] Validações de regras de negócio.
- [x] Persistência em banco de dados relacional.
- [ ] Implementação de Autenticação/Autorização (Em andamento).

## 👤 Sobre o Desenvolvedor <a name="sobre-o-desenvolvedor"></a>

<table align="center">
  <tr>
    <td align="center">
        <br>
        <a href="https://github.com/0nF1REy" target="_blank">
          <img src="./resources/images/docs/developer/alan-ryan.jpg" height="160" alt="Foto — Alan Ryan">
        </a>
        </p>
        <a href="https://github.com/0nF1REy" target="_blank">
          <strong>Alan Ryan</strong>
        </a>
        </p>
        ☕ Peopleware | Tech Enthusiast | Code Slinger ☕
        <br>
        Apaixonado por código limpo, arquitetura escalável e experiências digitais envolventes
        </p>
          Conecte-se comigo:
        </p>
        <a href="https://www.linkedin.com/in/alan-ryan-b115ba228" target="_blank">
          <img src="https://img.shields.io/badge/LinkedIn-Alan_Ryan-0077B5?style=flat&logo=linkedin" alt="LinkedIn">
        </a>
        <a href="https://gitlab.com/alanryan619" target="_blank">
          <img src="https://img.shields.io/badge/GitLab-@0nF1REy-FCA121?style=flat&logo=gitlab" alt="GitLab">
        </a>
        <a href="mailto:alanryan619@gmail.com" target="_blank">
          <img src="https://img.shields.io/badge/Email-alanryan619@gmail.com-D14836?style=flat&logo=gmail" alt="Email">
        </a>
        </p>
    </td>
  </tr>
</table>

</div>

---

## 📚 Recursos Adicionais <a name="recursos-adicionais"></a>

- [**Spring Boot**](https://spring.io/projects/spring-boot)
- [**Spring Data JPA**](https://spring.io/projects/spring-data-jpa)
- [**Hibernate ORM**](https://hibernate.org/orm/documentation/)
- [**Flyway**](https://documentation.red-gate.com/fd)
- [**PostgreSQL**](https://www.postgresql.org/docs/)
- [**Maven**](https://maven.apache.org/guides/)
- [**Java (OpenJDK)**](https://docs.oracle.com/en/java/)

## 📜 Licença <a name="licenca"></a>

Este projeto está sob a **licença MIT**. Consulte o arquivo **[LICENSE](LICENSE)** para obter mais detalhes.

> ℹ️ **Aviso de Licença:** &copy; 2026 Alan Ryan da Silva Domingues. Este projeto está licenciado sob os termos da licença MIT. Isso significa que você pode usá-lo, copiá-lo, modificá-lo e distribuí-lo com liberdade, desde que mantenha os avisos de copyright.

⭐ Se este repositório foi útil para você, considere dar uma estrela!
