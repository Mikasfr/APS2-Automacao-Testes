from selenium import webdriver
from selenium.webdriver.common.by import By
import time

start_time = time.time()  # Início do teste
driver = webdriver.Chrome()
driver.get("https://www.saucedemo.com/")
driver.find_element(By.ID, "user-name").send_keys("standard_user")
driver.find_element(By.ID, "password").send_keys("secret_sauce")
driver.find_element(By.ID, "login-button").click()
time.sleep(2)
assert "inventory" in driver.current_url, "Erro: Login falhou!"
end_time = time.time()  # Fim do teste
print(f"Teste Selenium: Login bem-sucedido. Tempo: {end_time - start_time:.2f} segundos")
driver.quit()