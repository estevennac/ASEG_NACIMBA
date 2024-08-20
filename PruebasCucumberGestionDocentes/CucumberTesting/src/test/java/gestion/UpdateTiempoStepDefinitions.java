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
//public class UpdateTiempoStepDefinitions extends BasicStepDefinition {
//
//    @Given("el usuario accede a la página de gestión de tiempos")
//    public void elUsuarioAccedeALaPaginaDeGestionDeTiempos() {
//        createPDF("UpdateTiempo");
//        addText("Inicio de prueba: el usuario accede a la página de gestión de tiempos");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000/UpdateTiempo");
//    }
//
//    @When("el usuario selecciona el tiempo con ID {string}")
//    public void elUsuarioSeleccionaElTiempoConID(String idtiempo) {
//        addText("el usuario selecciona el tiempo con ID: " + idtiempo);
//        WebElement selectButton = driver.findElement(By.xpath("//tr[td[text()='" + idtiempo + "']]//img[@alt='Actualizar']"));
//        selectButton.click();
//    }
//
//    @When("el usuario actualiza los datos del tiempo con {string}, {string}, {string}")
//    public void elUsuarioActualizaLosDatosDelTiempo(String horas, String codigo, String descripcion) {
//        addText("el usuario actualiza los datos del tiempo");
//
//        if (!horas.isEmpty()) {
//            WebElement horasInput = driver.findElement(By.name("horas"));
//            horasInput.clear();
//            horasInput.sendKeys(horas);
//        }
//        if (!codigo.isEmpty()) {
//            WebElement codigoInput = driver.findElement(By.name("codigo"));
//            codigoInput.clear();
//            codigoInput.sendKeys(codigo);
//        }
//        if (!descripcion.isEmpty()) {
//            WebElement descripcionInput = driver.findElement(By.name("descripcion"));
//            descripcionInput.clear();
//            descripcionInput.sendKeys(descripcion);
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
//            if (resultadoEsperado.equals("Requerimiento actualizado correctamente")) {
//                WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Requerimiento actualizado correctamente')]"));
//                assertEquals("Requerimiento actualizado correctamente", successMessage.getText().trim());
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
//            //addText("Prueba Fallida: " + e.getMessage());
//            addText("Prueba Fallida" );
//            captureScreenShot();
//            //fail("Prueba Fallida: " + e.getMessage());
//            fail("Prueba Fallida ");
//        } catch (Exception e) {
//            addText("Prueba Fallida" );
//            captureScreenShot();
//            fail("Prueba Fallida ");
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
//            // Maneja cualquier excepción que pueda ocurrir al cerrar el driver
//            System.err.println("Error al cerrar el navegador: " + e.getMessage());
//        } finally {
//            closePDF();
//        }
//    }
//}
