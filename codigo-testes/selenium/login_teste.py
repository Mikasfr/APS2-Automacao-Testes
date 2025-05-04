from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import time

# Configura opções do Chrome
chrome_options = Options()
chrome_options.add_argument("--headless")  # Roda sem interface gráfica
chrome_options.add_argument("--no-sandbox")  # Necessário para GitHub Actions
chrome_options.add_argument("--disable-dev-shm-usage")  # Evita problemas de memória
chrome_options.add_argument("--user-data-dir=/tmp/chrome-user-data")  # Diretório temporário único

# Inicia o cronômetro
start_time = time.time()

# Configura o driver
driver = webdriver.Chrome(ChromeDriverManager().install(), options=chrome_options)

# Acessa o site
driver.get("https://www.saucedemo.com/")

# Preenche o campo de usuário
driver.find_element(By.ID, "user-name").send_keys("standard_user")

# Preenche o campo de senha
driver.find_element(By.ID, "password").send_keys("secret_sauce")

# Clica no botão de login
driver.find_element(By.ID, "login-button").click()

# Aguarda 2 segundos
time.sleep(2)

# Verifica o login
assert "inventory" in driver.current_url, "Erro: Login falhou!"
end_time = time.time()
print(f"Teste Selenium: Login bem-sucedido. Tempo: {end_time - start_time:.2f} segundos")

# Fecha o navegador
driver.quit()