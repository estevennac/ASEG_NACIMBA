package gestion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LoginExitosoStepDefinitions extends BasicStepDefinition {

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
            }
        } catch (AssertionError e) {
            addText("Prueba Fallida: Se esperaba redirección a 'http://localhost:3000/HomeC' pero se redirigió a: " + driver.getCurrentUrl());
            captureScreenShot();
            fail("Prueba Fallida: " + e.getMessage());
        } catch (Exception e) {
            addText("Excepción encontrada: " + e.getMessage());
            fail("Excepción encontrada: " + e.getMessage());
        } finally {
            wait(1);
            this.driver.quit();
            closePDF();
        }
    }
}
