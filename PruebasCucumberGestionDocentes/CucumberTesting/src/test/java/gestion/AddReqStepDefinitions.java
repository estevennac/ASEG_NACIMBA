//package gestion;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import java.util.concurrent.TimeUnit;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//public class AddReqStepDefinitions extends BasicStepDefinition {
//
//    @Given("el usuario está en la página de agregar requerimiento")
//    public void elUsuarioEstaEnLaPaginaDeAgregarRequerimiento() {
//        createPDF("Agregar Requerimiento");
//        addText("Inicio de prueba: el usuario está en la página de agregar requerimiento");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000/AddReq");
//    }
//
//    @When("el usuario ingresa los datos {string}, {string}, {string}, {string} y {string}")
//    public void elUsuarioIngresaLosDatos(String cargo, String departamento, String denominacion, String dedicacion, String sede) {
//        addText("el usuario ingresa los datos: cargo=" + cargo + ", departamento=" + departamento + ", denominacion=" + denominacion + ", dedicacion=" + dedicacion + ", sede=" + sede);
//
//        WebElement cargoSelect = driver.findElement(By.name("IDCARGO"));
//        WebElement departamentoSelect = driver.findElement(By.name("DEPARTAMENTO"));
//        WebElement denominacionSelect = driver.findElement(By.name("DENOMINACION"));
//        WebElement dedicacionSelect = driver.findElement(By.name("DEDICACION"));
//        WebElement sedeSelect = driver.findElement(By.name("SEDE"));
//
//        cargoSelect.sendKeys(cargo);
//        departamentoSelect.sendKeys(departamento);
//        denominacionSelect.sendKeys(denominacion);
//        dedicacionSelect.sendKeys(dedicacion);
//        sedeSelect.sendKeys(sede);
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
//            if (resultadoEsperado.equals("Requerimiento agregado correctamente")) {
//                WebElement successMessage = driver.findElement(By.xpath("//div[text()='Requerimiento agregado correctamente']"));
//                assertEquals("Requerimiento agregado correctamente", successMessage.getText().trim());
//                addText("Prueba correcta: El requerimiento fue agregado correctamente");
//            } else if (resultadoEsperado.equals("Por favor, llene todos los campos obligatorios")) {
//                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Por favor, llene todos los campos obligatorios')]"));
//                assertEquals("Por favor, llene todos los campos obligatorios", errorMessage.getText().trim());
//                addText("Prueba correcta: Se muestra el mensaje de error esperado");
//            }
//        } catch (Exception e) {
//            addText("Prueba Fallida: " );
//            captureScreenShot();
//            fail("Prueba Fallida: " );
//        } finally {
//            wait(1);
//            this.driver.quit();
//            closePDF();
//        }
//    }
//}
