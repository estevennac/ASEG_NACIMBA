//package gestion;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import java.util.concurrent.TimeUnit;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//public class AddCargoStepDefinitions extends BasicStepDefinition {
//
//    @Given("el usuario está en la página de agregar cargo")
//    public void elUsuarioEstaEnLaPaginaDeAgregarCargo() {
//        createPDF("Agregar Cargo");
//        addText("Inicio de prueba: el usuario está en la página de agregar cargo");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000/AddCargo");
//    }
//
//    @When("el usuario ingresa los datos {string}, {string}, {string}, {string}, {string}, {string}")
//    public void elUsuarioIngresaLosDatos(String tiempo, String tipoPersonal, String categoria, String nivel, String grado, String remuneracion) {
//        addText("el usuario ingresa los datos: tiempo=" + tiempo + ", tipoPersonal=" + tipoPersonal + ", categoria=" + categoria + ", nivel=" + nivel + ", grado=" + grado + ", remuneracion=" + remuneracion);
//
//        WebElement tiempoSelect = driver.findElement(By.name("IDTIEMPO"));
//        WebElement tipoPersonalSelect = driver.findElement(By.name("TIPOPERSONAL"));
//        WebElement categoriaSelect = driver.findElement(By.name("CATEGORIA"));
//        WebElement nivelSelect = driver.findElement(By.name("NIVEL"));
//        WebElement gradoSelect = driver.findElement(By.name("GRADO"));
//        WebElement remuneracionInput = driver.findElement(By.name("REMUNERACION"));
//
//        tiempoSelect.sendKeys(tiempo);
//        tipoPersonalSelect.sendKeys(tipoPersonal);
//        categoriaSelect.sendKeys(categoria);
//        nivelSelect.sendKeys(nivel);
//        gradoSelect.sendKeys(grado);
//        remuneracionInput.sendKeys(remuneracion);
//
//        captureScreenShot();
//    }
//
//    @When("el usuario hace clic en {string}")
//    public void elUsuarioHaceClicEn(String botonTexto) {
//        addText("El usuario hace clic en: " + botonTexto);
//        WebElement boton = driver.findElement(By.xpath("//button[text()='" + botonTexto + "']"));
//        boton.click();
//        captureScreenShot();
//    }
//
//    @Then("el resultado de la operación es {string}")
//    public void elResultadoDeLaOperacionEs(String resultadoEsperado) {
//        addText("Verificación del resultado de la operación");
//        wait(2);
//        captureScreenShot();
//
//        try {
//            if (resultadoEsperado.equals("Cargo agregado correctamente")) {
//                WebElement successMessage = driver.findElement(By.xpath("//div[text()='Cargo agregado correctamente']"));
//                assertEquals("Cargo agregado correctamente", successMessage.getText().trim());
//                addText("Prueba correcta: El cargo fue agregado correctamente");
//            } else if (resultadoEsperado.equals("Por favor, llene todos los campos obligatorios")) {
//                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Por favor, llene todos los campos obligatorios')]"));
//                assertEquals("Por favor, llene todos los campos obligatorios", errorMessage.getText().trim());
//                addText("Prueba correcta: Se muestra el mensaje de error esperado");
//            }
//        } catch (Exception e) {
//            addText("Prueba Fallida: " + e.getMessage());
//            captureScreenShot();
//            fail("Prueba Fallida: " + e.getMessage());
//        } finally {
//            wait(1);
//            this.driver.quit();
//            closePDF();
//        }
//    }
//}
