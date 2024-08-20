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
//public class UpdateContractStepDefinitions extends BasicStepDefinition {
//
//    @Given("el usuario accede a la página de actualización de contratos")
//    public void elUsuarioAccedeALaPaginaDeActualizacionDeContratos() {
//        createPDF("UpdateContract");
//        addText("Inicio de prueba: el usuario accede a la página de actualización de contratos");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000/UpdateContrato");
//    }
//
//    @When("el usuario selecciona el contrato con ID {string}")
//    public void elUsuarioSeleccionaElContratoConID(String idcontrato) {
//        addText("el usuario selecciona el contrato con ID: " + idcontrato);
//        WebElement selectButton = driver.findElement(By.xpath("//tr[td[text()='" + idcontrato + "']]//img[@alt='Actualizar']"));
//        selectButton.click();
//    }
//
//    @When("el usuario actualiza los datos del contrato con {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
//    public void elUsuarioActualizaLosDatosDelContrato(String fechainicio, String fechaFin, String fuente, String fecha, String certificacion_presupuestaria, String idmemo, String analistadelproceso, String archivomemo) {
//        addText("el usuario actualiza los datos del contrato");
//
//        if (!fechainicio.isEmpty()) {
//            WebElement fechainicioInput = driver.findElement(By.name("fechainicio"));
//            fechainicioInput.clear();
//            fechainicioInput.sendKeys(fechainicio);
//        }
//        if (!fechaFin.isEmpty()) {
//            WebElement fechafinInput = driver.findElement(By.name("fechaFin"));
//            fechafinInput.clear();
//            fechafinInput.sendKeys(fechaFin);
//        }
//        if (!fuente.isEmpty()) {
//            WebElement fuenteInput = driver.findElement(By.name("fuente"));
//            fuenteInput.clear();
//            fuenteInput.sendKeys(fuente);
//        }
//        if (!fecha.isEmpty()) {
//            WebElement fechaInput = driver.findElement(By.name("fecha"));
//            fechaInput.clear();
//            fechaInput.sendKeys(fecha);
//        }
//        if (!certificacion_presupuestaria.isEmpty()) {
//            WebElement certificacionPresupuestariaInput = driver.findElement(By.name("certificacion_presupuestaria"));
//            certificacionPresupuestariaInput.clear();
//            certificacionPresupuestariaInput.sendKeys(certificacion_presupuestaria);
//        }
//        if (!idmemo.isEmpty()) {
//            WebElement idmemoInput = driver.findElement(By.name("idmemo"));
//            idmemoInput.clear();
//            idmemoInput.sendKeys(idmemo);
//        }
//        if (!analistadelproceso.isEmpty()) {
//            WebElement analistaDelProcesoInput = driver.findElement(By.name("analistadelproceso"));
//            analistaDelProcesoInput.clear();
//            analistaDelProcesoInput.sendKeys(analistadelproceso);
//        }
//        if (!archivomemo.isEmpty()) {
//            WebElement archivoMemoInput = driver.findElement(By.name("archivomemo"));
//            archivoMemoInput.clear();
//            archivoMemoInput.sendKeys(archivomemo);
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
//            if (resultadoEsperado.equals("Contrato actualizado correctamente")) {
//                WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Contrato actualizado correctamente')]"));
//                assertEquals("Contrato actualizado correctamente", successMessage.getText().trim());
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
//            addText("Prueba Fallida");
//            captureScreenShot();
//            fail("Prueba Fallida ");
//        } catch (Exception e) {
//            addText("Prueba Fallida");
//            captureScreenShot();
//            fail("Prueba Fallida ");
//        }
//    }
//
//    @After
//    public void tearDown() {
//        try {
//            if (driver instanceof TakesScreenshot) {
//                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
//                File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
//                Files.copy(screenshot.toPath(), Paths.get("screenshot-" + System.currentTimeMillis() + ".png"));
//            }
//
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
