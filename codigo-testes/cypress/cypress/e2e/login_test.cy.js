describe('Teste de Login - Saucedemo', () => {
  it('Deve fazer login com sucesso', () => {
    const start = Date.now();
    cy.visit('/');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
    cy.url().should('include', '/inventory');
    const end = Date.now();
    cy.log(`Tempo de execução: ${(end - start) / 1000} segundos`);
  });
});