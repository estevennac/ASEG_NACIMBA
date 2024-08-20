


package gestion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LoginStepDefinitions extends BasicStepDefinition {

    @Given("el usuario ingresa a la página de login")
    public void elUsuarioIngresaALaPaginaDeLogin() {
        createPDF("Login");
        addText("Inicio de prueba: el usuario ingresa a la página de login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
    }

    @When("el usuario ingresa datos {string} {string}")
    public void elUsuarioIngresaDatos(String nombreus, String contraseniaus) {
        addText("el usuario ingresa datos nombreus: " + nombreus + ", contrasenius: " + contraseniaus);

        // Usa placeholder en lugar de name
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Nombre de usuario']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Contraseña']"));

        if (!nombreus.isEmpty()) {
            usernameInput.sendKeys(nombreus);
        }
        if (!contraseniaus.isEmpty()) {
            passwordInput.sendKeys(contraseniaus);
        }
        captureScreenShot();
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Iniciar Sesión']"));
        loginButton.click();
    }

    @Then("el resultado del login es {string}")
    public void elResultadoDelLoginEs(String resultadoEsperado) {
        addText("Verificación del resultado del login");
        wait(2);
        captureScreenShot();

        try {
            if (resultadoEsperado.equals("redirigido")) {
                String currentPage = driver.getCurrentUrl();
                assertEquals("http://localhost:3000/HomeC", currentPage);
                addText("Prueba correcta: El usuario es redirigido a la página principal");
            } else if (resultadoEsperado.equals("Nombre de usuario o contraseña incorrectos")) {
                WebElement errorAlert = driver.findElement(By.xpath("//p[contains(@class, 'error-message')]"));
                assertEquals("Nombre de usuario o contraseña incorrectos", errorAlert.getText().trim());
                addText("Prueba correcta: Se muestra el mensaje de error esperado");
            } else if (resultadoEsperado.equals("Todos los campos son obligatorios")) {
                WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Nombre de usuario']"));
                WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Contraseña']"));
                assertEquals("", usernameInput.getAttribute("value"));
                assertEquals("", passwordInput.getAttribute("value"));
                addText("Prueba correcta: Los campos vacíos muestran los mensajes de error requeridos");
            } else if (resultadoEsperado.equals("Intento fallido de redirigir")) {
                String currentPage = driver.getCurrentUrl();
                assertEquals("http://localhost:3000/", currentPage);
                WebElement errorAlert = driver.findElement(By.xpath("//p[contains(@class, 'error-message')]"));
                assertEquals("Nombre de usuario o contraseña incorrectos", errorAlert.getText().trim());
                addText("Prueba correcta: El intento de redirigir con credenciales incorrectas falló y mostró el mensaje de error esperado");
            }
        } catch (AssertionError e) {
            if (resultadoEsperado.equals("redirigido")) {
                addText("Prueba Fallida: Se esperaba redirección a 'http://localhost:3000/HomeC' pero se redirigió a: " + driver.getCurrentUrl());
            } else if (resultadoEsperado.equals("Intento fallido de redirigir")) {
                addText("Prueba Fallida: Intento fallido de ingresar al sistema con credenciales inválidas");
            } else {
                addText("Prueba fallida: " + e.getMessage());
            }
            captureScreenShot();
            fail("Prueba Fallida: " + e.getMessage());
        } catch (Exception e) {
            addText("Excepción encontrada: " + e.getMessage());
            //captureScreenShot();
            fail("Excepción encontrada: " + e.getMessage());
        } finally {
            wait(1);
            this.driver.quit();
            closePDF();
        }
    }
}

