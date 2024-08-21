package gestion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LoginFallidoStepDefinitions extends BasicStepDefinition {

    @Given("el usuario ingresa a la página de login")
    public void elUsuarioIngresaALaPaginaDeLogin() {
        createPDF("LoginFallido");
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
            if (resultadoEsperado.equals("Todos los campos son obligatorios")) {
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
            addText("Prueba fallida ");
            captureScreenShot();
            fail("Prueba Fallida ");
        } catch (Exception e) {
            addText("Prueba fallida ");
            fail("Prueba Fallida ");
        } finally {
            wait(1);
            this.driver.quit();
            closePDF();
        }
    }
}
