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

## Integração com GitHub Actions (CI/CD)

- **Workflow**: `.github/workflows/ci-cypress.yml`.
- **Gatilho**: Roda a cada `push` na branch `main`.
- **Passos**:
  1. Checkout do repositório.
  2. Configura Node.js.
  3. Instala dependências.
  4. Instala o binário do Cypress com `cypress install`.
  5. Executa `npx cypress run`.

## Resultados

- Saída: Log confirmando login bem-sucedido.
- Tempo médio de execução: ~2 segundos.
- Vídeos: Gerados em `cypress/cypress/videos/` localmente. Arquivos salvos em `relatorio/videos/` no repositório.
