//package gestion;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//public class AddTiempoStepDefinitions extends BasicStepDefinition {
//
//    @Given("el usuario está en la página de agregar tiempo")
//    public void elUsuarioEstaEnLaPaginaDeAgregarTiempo() {
//        createPDF("Agregar Tiempo");
//        addText("Inicio de prueba: el usuario está en la página de agregar tiempo");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://localhost:3000/AddTiempo");
//    }
//
//    @When("el usuario ingresa los datos {string}, {string}, {string}")
//    public void elUsuarioIngresaLosDatos(String descripcion, String codigo, String horas) {
//        addText("el usuario ingresa los datos: descripcion=" + descripcion + ", codigo=" + codigo + ", horas=" + horas);
//
//        WebElement descripcionSelect = driver.findElement(By.name("DESCRIPCION"));
//        WebElement codigoInput = driver.findElement(By.name("CODIGO"));
//        WebElement horasInput = driver.findElement(By.name("HORAS"));
//
//        descripcionSelect.sendKeys(descripcion);
//        codigoInput.sendKeys(codigo);
//        horasInput.sendKeys(horas);
//
//        captureScreenShot();
//    }
//
//    @When("el usuario hace clic en {string}")
//    public void el_usuario_hace_clic_en(String botonTexto) {
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
//            if (resultadoEsperado.equals("Tiempo agregado correctamente")) {
//                WebElement successMessage = driver.findElement(By.xpath("//div[text()='Tiempo agregado correctamente']"));
//                assertEquals("Tiempo agregado correctamente", successMessage.getText().trim());
//                addText("Prueba correcta: El tiempo fue agregado correctamente");
//            } else if (resultadoEsperado.equals("Por favor, llene todos los campos obligatorios")) {
//                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Por favor, llene todos los campos obligatorios')]"));
//                assertEquals("Por favor, llene todos los campos obligatorios", errorMessage.getText().trim());
//                addText("Prueba correcta: Se muestra el mensaje de error esperado");
//            }
//        } catch (Exception e) {
//            addText("Prueba Fallida " );
//            captureScreenShot();
//            fail("Prueba Fallida " );
//        } finally {
//            wait(1);
//            this.driver.quit();
//            closePDF();
//        }
//    }
//}
