//package gestion;
//
//import io.cucumber.java.After;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.concurrent.TimeUnit;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//public class UpdateCargoStepDefinitions extends BasicStepDefinition {
//
//    @Given("el usuario accede a la página de gestión de cargos")
//    public void elUsuarioAccedeALaPaginaDeGestionDeCargos() {
//        createPDF("UpdateCargo");
//        addText("Inicio de prueba: el usuario accede a la página de gestión de cargos");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000/UpdateCargo");
//    }
//
//    @When("el usuario selecciona el cargo con ID {string}")
//    public void elUsuarioSeleccionaElCargoConID(String idcargo) {
//        addText("el usuario selecciona el cargo con ID: " + idcargo);
//        WebElement selectButton = driver.findElement(By.xpath("//tr[td[text()='" + idcargo + "']]//img[@alt='Actualizar']"));
//        selectButton.click();
//    }
//
//    @When("el usuario actualiza los datos del cargo con {string}, {string}, {string}, {string}, {string}")
//    public void elUsuarioActualizaLosDatosDelCargo(String tipoPersonal, String categoria, String nivel, String grado, String remuneracion) {
//        addText("el usuario actualiza los datos del cargo");
//
//        if (!tipoPersonal.isEmpty()) {
//            WebElement tipoPersonalSelect = driver.findElement(By.name("tipoPersonal"));
//            tipoPersonalSelect.sendKeys(tipoPersonal);
//        }
//        if (!categoria.isEmpty()) {
//            WebElement categoriaSelect = driver.findElement(By.name("categoria"));
//            categoriaSelect.sendKeys(categoria);
//        }
//        if (!nivel.isEmpty()) {
//            WebElement nivelSelect = driver.findElement(By.name("nivel"));
//            nivelSelect.sendKeys(nivel);
//        }
//        if (!grado.isEmpty()) {
//            WebElement gradoSelect = driver.findElement(By.name("grado"));
//            gradoSelect.sendKeys(grado);
//        }
//        if (!remuneracion.isEmpty()) {
//            WebElement remuneracionInput = driver.findElement(By.name("remuneracion"));
//            remuneracionInput.clear();
//            remuneracionInput.sendKeys(remuneracion);
//        }
//
//        captureScreenShot();
//        WebElement updateButton = driver.findElement(By.xpath("//button[text()='Actualizar']"));
//        updateButton.click();
//    }
//
//    @Then("el resultado de la actualización es {string}")
//    public void elResultadoDeLaActualizacionEs(String resultadoEsperado) {
//        addText("Verificación del resultado de la actualización");
//        wait(2);
//        captureScreenShot();
//
//        try {
//            if (resultadoEsperado.equals("Cargo actualizado correctamente")) {
//                WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Cargo actualizado correctamente')]"));
//                assertEquals("Cargo actualizado correctamente", successMessage.getText().trim());
//                addText("Prueba correcta: La actualización se realizó con éxito.");
//            } else if (resultadoEsperado.equals("Campos vacíos y mensaje de error")) {
//                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'error-message')]"));
//                assertEquals("Campos obligatorios vacíos", errorMessage.getText().trim());
//                addText("Prueba correcta: Se muestra el mensaje de error por campos vacíos.");
//            } else if (resultadoEsperado.equals("Información incompleta y mensaje de error")) {
//                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'error-message')]"));
//                assertEquals("Información incompleta", errorMessage.getText().trim());
//                addText("Prueba correcta: Se muestra el mensaje de error por información incompleta.");
//            }
//        } catch (AssertionError e) {
//            addText("Prueba Fallida ");
//            captureScreenShot();
//            fail("Prueba Fallida ");
//        } catch (Exception e) {
//            addText("Prueba Fallida " );
//            captureScreenShot();
//            fail("Prueba Fallida " );
//        }
//    }
//
//    @After
//    public void tearDown() {
//        try {
//            // Captura una captura de pantalla en caso de fallos
//            if (driver instanceof TakesScreenshot) {
//                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
//                File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
//                Files.copy(screenshot.toPath(), Paths.get("screenshot-" + System.currentTimeMillis() + ".png"));
//            }
//
//            // Cierra el navegador después de cada prueba
//            if (driver != null) {
//                driver.quit();
//            }
//        } catch (Exception e) {
//            System.err.println("Error al cerrar el navegador: " + e.getMessage());
//        } finally {
//            closePDF();
//        }
//    }
//}
