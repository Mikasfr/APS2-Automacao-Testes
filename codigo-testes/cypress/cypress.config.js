const { defineConfig } = require('cypress');

module.exports = defineConfig({
  e2e: {
    baseUrl: 'https://www.saucedemo.com',
    specPattern: 'cypress/e2e/**/*.cy.{js,jsx,ts,tsx}',
  },
  video: true, // Já é true por padrão
  videoCompression: 32, // Qualidade do vídeo (0 = baixa, 32 = alta)
  videoUploadOnPasses: false, // Só gera vídeo se o teste falhar (opcional)
});