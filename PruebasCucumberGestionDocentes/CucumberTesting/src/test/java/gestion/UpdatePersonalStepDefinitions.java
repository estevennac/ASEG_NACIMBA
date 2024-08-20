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
//public class UpdatePersonalStepDefinitions extends BasicStepDefinition {
//
//    @Given("el usuario accede a la página de gestión de personal")
//    public void elUsuarioAccedeALaPaginaDeGestionDePersonal() {
//        createPDF("UpdateDocente");
//        addText("Inicio de prueba: el usuario accede a la página de gestión de personal");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000/UpdatePersonal");
//    }
//
//    @When("el usuario selecciona el docente con ID {string}")
//    public void elUsuarioSeleccionaElDocenteConID(String iddocente) {
//        addText("el usuario selecciona el docente con ID: " + iddocente);
//        WebElement selectButton = driver.findElement(By.xpath("//tr[td[text()='" + iddocente + "']]//img[@alt='Actualizar']"));
//        selectButton.click();
//    }
//
//    @When("el usuario actualiza los datos del docente con {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
//    public void elUsuarioActualizaLosDatosDelDocente(String apellidos, String nombres, String cedula, String nacionalidad, String genero, String correop, String correoi, String ciudad, String provincia, String numero, String campus, String observacion) {
//        addText("el usuario actualiza los datos del docente");
//
//        if (!apellidos.isEmpty()) {
//            WebElement apellidosInput = driver.findElement(By.name("apellidos"));
//            apellidosInput.clear();
//            apellidosInput.sendKeys(apellidos);
//        }
//        if (!nombres.isEmpty()) {
//            WebElement nombresInput = driver.findElement(By.name("nombres"));
//            nombresInput.clear();
//            nombresInput.sendKeys(nombres);
//        }
//        if (!cedula.isEmpty()) {
//            WebElement cedulaInput = driver.findElement(By.name("cedula"));
//            cedulaInput.clear();
//            cedulaInput.sendKeys(cedula);
//        }
//        if (!nacionalidad.isEmpty()) {
//            WebElement nacionalidadInput = driver.findElement(By.name("nacionalidad"));
//            nacionalidadInput.clear();
//            nacionalidadInput.sendKeys(nacionalidad);
//        }
//        if (!genero.isEmpty()) {
//            WebElement generoSelect = driver.findElement(By.name("genero"));
//            generoSelect.sendKeys(genero);
//        }
//        if (!correop.isEmpty()) {
//            WebElement correopInput = driver.findElement(By.name("correop"));
//            correopInput.clear();
//            correopInput.sendKeys(correop);
//        }
//        if (!correoi.isEmpty()) {
//            WebElement correoiInput = driver.findElement(By.name("correoi"));
//            correoiInput.clear();
//            correoiInput.sendKeys(correoi);
//        }
//        if (!ciudad.isEmpty()) {
//            WebElement ciudadSelect = driver.findElement(By.name("ciudad"));
//            ciudadSelect.sendKeys(ciudad);
//        }
//        if (!provincia.isEmpty()) {
//            WebElement provinciaSelect = driver.findElement(By.name("provincia"));
//            provinciaSelect.sendKeys(provincia);
//        }
//        if (!numero.isEmpty()) {
//            WebElement numeroInput = driver.findElement(By.name("numero"));
//            numeroInput.clear();
//            numeroInput.sendKeys(numero);
//        }
//        if (!campus.isEmpty()) {
//            WebElement campusInput = driver.findElement(By.name("campus"));
//            campusInput.clear();
//            campusInput.sendKeys(campus);
//        }
//        if (!observacion.isEmpty()) {
//            WebElement observacionInput = driver.findElement(By.name("observacion"));
//            observacionInput.clear();
//            observacionInput.sendKeys(observacion);
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
//            if (resultadoEsperado.equals("Personal actualizado correctamente")) {
//                WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Personal actualizado correctamente')]"));
//                assertEquals("Personal actualizado correctamente", successMessage.getText().trim());
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
//            addText("Prueba Fallida: " + e.getMessage());
//            captureScreenShot();
//            fail("Prueba Fallida: " + e.getMessage());
//        } catch (Exception e) {
//            //addText("Excepción encontrada: " + e.getMessage());
//            addText("Prueba Fallida: ");
//
//            captureScreenShot();
//            //fail("Excepción encontrada: " + e.getMessage());
//            fail("Prueba Fallida: " + e.getMessage());
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
