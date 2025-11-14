# 🍽️ FEIfood

Aplicação desktop em Java para gerenciamento de pedidos de comida, desenvolvida como projeto da disciplina **Arquitetura de Software e Programação Orientada a Objetos**.

---

## 🧾 Sobre o projeto

O **FEIfood** é um sistema simples de pedidos que permite:

- Cadastro e login de clientes;
- Consulta de alimentos e bebidas cadastrados;
- Montagem de pedidos com carrinho;
- Avaliação/feedback do pedido.

O foco do projeto é praticar **POO**, **MVC** e boas práticas de organização de código em Java.

---

## ✨ Funcionalidades

- 👤 **Cadastro de clientes**
  - Registro de novos usuários no sistema.
- 🔐 **Login**
  - Autenticação de clientes via tela de login.
- 🧆 **Consulta de alimentos/bebidas**
  - Listagem de itens cadastrados.
  - Filtro por **descrição** e **tipo** (na tela de Pedido).
- 🛒 **Carrinho / Pedido**
  - Seleção de itens para o pedido.
  - Resumo dos itens escolhidos.
- 🔍 **Pesquisa**
  - Tela dedicada para pesquisa de registros.
- ⭐ **Avaliação**
  - Tela de avaliação do pedido/experiência.
- 💾 **Persistência em banco de dados**
  - Uso de DAOs e JDBC para comunicação com o banco.

---

## 🧱 Arquitetura e organização do código

O projeto segue uma arquitetura **MVC (Model–View–Controller)**, organizada em pacotes:

- `src/Model/`
  - `Alimento.java`
  - `Bebida.java`
  - `Cliente.java`
  - Contém as classes de domínio (entidades do sistema).

- `src/Dao/`
  - `AlimentoDAO.java`
  - `ClienteDAO.java`
  - `Conexao.java`
  - Responsável pelo acesso ao banco de dados (DAO + classe de conexão).

- `src/Controller/`
  - `AlimentoControle.java`
  - `CadastroControle.java`
  - `ControleLogin.java`
  - `PedidoControle.java`
  - Camada de controle (regras de negócio, orquestração entre View e DAO).

- `src/View/`
  - `Login.java` / `Login.form`
  - `Cadastro.java` / `Cadastro.form`
  - `Pedido.java` / `Pedido.form`
  - `Carrinho.java` / `Carrinho.form`
  - `Pesquisa.java` / `Pesquisa.form`
  - `Avaliar.java` / `Avaliar.form`
  - Telas gráficas feitas em **Java Swing** (NetBeans GUI Builder).

- `src/feifood/Main.java`
  - Classe principal, ponto de entrada da aplicação.

---

## 🛠️ Tecnologias utilizadas

- ☕ **Java** (recomendado JDK 11+ ou 17+)
- 🧰 **Java Swing** (interfaces gráficas)
- 🔌 **JDBC** (acesso ao banco de dados)
- 🧩 **NetBeans** + projeto **Ant** (`build.xml`)
- 💾 Banco de dados relacional (configurado em `Dao/Conexao.java`)

---

## 📦 Pré-requisitos

Antes de rodar o projeto, você precisa ter:

- [x] **JDK** 11 ou superior instalado  
- [x] **NetBeans** (recomendado, por causa dos `.form` e Ant)  
- [x] Um **banco de dados relacional** configurado e acessível (ex.: local)  
- [x] Ajustar a classe `Conexao.java` com:
  - URL do banco;
  - Usuário;
  - Senha.

---

## ▶️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/lucasqchau/FEIfood.git
cd FEIfood
