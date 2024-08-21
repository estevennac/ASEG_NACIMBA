package gestion;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateReqFailureStepDefinitions extends BasicStepDefinition {

    @Given("el usuario accede a la página de gestión de requerimientos")
    public void elUsuarioAccedeALaPaginaDeGestionDeRequerimientos() {
        createPDF("UpdateRequerimiento");
        addText("Inicio de prueba: el usuario accede a la página de gestión de requerimientos");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/UpdateReq");
    }

    @When("el usuario selecciona el requerimiento con ID {string}")
    public void elUsuarioSeleccionaElRequerimientoConID(String idrequerimiento) {
        addText("el usuario selecciona el requerimiento con ID: " + idrequerimiento);
        WebElement selectButton = driver.findElement(By.xpath("//tr[td[text()='" + idrequerimiento + "']]//img[@alt='Actualizar']"));
        selectButton.click();
    }

    @When("el usuario actualiza los datos del requerimiento con {string}, {string}, {string}, {string}")
    public void elUsuarioActualizaLosDatosDelRequerimiento(String sede, String departamento, String denominacion, String dedicacion) {
        addText("el usuario actualiza los datos del requerimiento");


        if (!sede.isEmpty()) {
            WebElement sedeInput = driver.findElement(By.name("sede"));
            sedeInput.sendKeys(sede);
        }
        if (!departamento.isEmpty()) {
            WebElement departamentoInput = driver.findElement(By.name("departamento"));
            departamentoInput.sendKeys(departamento);
        }
        if (!denominacion.isEmpty()) {
            WebElement denominacionInput = driver.findElement(By.name("denominacion"));
            denominacionInput.sendKeys(denominacion);
        }
        if (!dedicacion.isEmpty()) {
            WebElement dedicacionInput = driver.findElement(By.name("dedicacion"));
            dedicacionInput.sendKeys(dedicacion);
        }

        captureScreenShot();
        WebElement updateButton = driver.findElement(By.xpath("//button[text()='Actualizar']"));
        updateButton.click();
    }

    @Then("el resultado de la actualización es {string}")
    public void elResultadoDeLaActualizacionEs(String resultadoEsperado) {
        addText("Verificación del resultado de la actualización");
        wait(2);
        captureScreenShot();

        try {
             if (resultadoEsperado.equals("Campos vacíos y mensaje de error")) {
                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'error-message')]"));
                assertEquals("Campos obligatorios vacíos", errorMessage.getText().trim());
                addText("Prueba correcta: Se muestra el mensaje de error por campos vacíos.");
            } else if (resultadoEsperado.equals("Información incompleta y mensaje de error")) {
                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'error-message')]"));
                assertEquals("Información incompleta", errorMessage.getText().trim());
                addText("Prueba correcta: Se muestra el mensaje de error por información incompleta.");
            }
        } catch (AssertionError e) {
            addText("Prueba Fallida: " + e.getMessage());
            captureScreenShot();
            fail("Prueba Fallida: " + e.getMessage());
        } catch (Exception e) {
            addText("Prueba Fallida: ");
            captureScreenShot();
            fail("Prueba Fallida: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
                File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
                Files.copy(screenshot.toPath(), Paths.get("screenshot-" + System.currentTimeMillis() + ".png"));
            }

            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar el navegador: " + e.getMessage());
        } finally {
            closePDF();
        }
    }
}