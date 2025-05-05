# Testes com Cypress

## Descrição

Testes automatizados de interface web usando o **Cypress** para o APS 2. O teste realiza um login no site [saucedemo.com](https://www.saucedemo.com/).

## Testes Implementados

- **`cypress/e2e/login_test.cy.js`**:
  - Acessa o site saucedemo.com.
  - Preenche usuário (`standard_user`) e senha (`secret_sauce`).
  - Clica no botão de login.
  - Verifica se a URL contém "inventory".
  - Mede o tempo de execução.

## Requisitos

- Node.js 16+
- `npm install cypress --save-dev`

## Como Executar Localmente

1. Instale as dependências:
   ```bash
   npm install
   ```
