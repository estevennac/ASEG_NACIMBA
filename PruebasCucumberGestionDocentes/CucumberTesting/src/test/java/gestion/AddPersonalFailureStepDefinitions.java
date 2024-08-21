package gestion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AddPersonalFailureStepDefinitions extends BasicStepDefinition {

    @Given("el usuario está en la página de agregar docente")
    public void elUsuarioEstaEnLaPaginaDeAgregarDocente() {
        createPDF("Agregar Docente");
        addText("Inicio de prueba: el usuario está en la página de agregar docente");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/AddPersonal");
    }

    @When("el usuario ingresa los datos {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} y {string}")
    public void elUsuarioIngresaLosDatos(String apellidos, String nombres, String cedula, String nacionalidad, String genero, String correoPersonal, String correoInstitucional, String ciudad, String provincia, String numeroPersonal, String campus, String observaciones) {
        addText("el usuario ingresa los datos: apellidos=" + apellidos + ", nombres=" + nombres + ", cedula=" + cedula + ", nacionalidad=" + nacionalidad + ", genero=" + genero + ", correoPersonal=" + correoPersonal + ", correoInstitucional=" + correoInstitucional + ", ciudad=" + ciudad + ", provincia=" + provincia + ", numeroPersonal=" + numeroPersonal + ", campus=" + campus + ", observaciones=" + observaciones);

        WebElement apellidosInput = driver.findElement(By.name("APELLIDOS"));
        WebElement nombresInput = driver.findElement(By.name("NOMBRES"));
        WebElement cedulaInput = driver.findElement(By.name("CEDULA"));
        WebElement nacionalidadInput = driver.findElement(By.name("NACIONALIDAD"));
        WebElement generoSelect = driver.findElement(By.name("GENERO"));
        WebElement correoPersonalInput = driver.findElement(By.name("CORREO_PERSONAL"));
        WebElement correoInstitucionalInput = driver.findElement(By.name("CORREO_INSTITUCIONAL"));
        WebElement ciudadSelect = driver.findElement(By.name("CIUDAD"));
        WebElement provinciaSelect = driver.findElement(By.name("PROVINCIA"));
        WebElement numeroPersonalInput = driver.findElement(By.name("NROPERSONAL"));
        WebElement campusSelect = driver.findElement(By.name("CAMPUSSEDEPERSONAL"));
        WebElement observacionesInput = driver.findElement(By.name("OBSERVACIONESPERSONAL"));

        apellidosInput.sendKeys(apellidos);
        nombresInput.sendKeys(nombres);
        cedulaInput.sendKeys(cedula);
        nacionalidadInput.sendKeys(nacionalidad);
        generoSelect.sendKeys(genero);
        correoPersonalInput.sendKeys(correoPersonal);
        correoInstitucionalInput.sendKeys(correoInstitucional);
        ciudadSelect.sendKeys(ciudad);
        provinciaSelect.sendKeys(provincia);
        numeroPersonalInput.sendKeys(numeroPersonal);
        campusSelect.sendKeys(campus);
        observacionesInput.sendKeys(observaciones);

        captureScreenShot();
    }

    @When("el usuario hace clic en {string}")
    public void el_usuario_hace_clic_en(String botonTexto) {
        addText("El usuario hace clic en: " + botonTexto);
        WebElement boton = driver.findElement(By.xpath("//button[text()='" + botonTexto + "']"));
        boton.click();
        captureScreenShot();
    }

    @Then("el resultado de la operación es {string}")
    public void elResultadoDeLaOperacionEs(String resultadoEsperado) {
        addText("Verificación del resultado de la operación");
        wait(2);
        captureScreenShot();

        try {
            if (resultadoEsperado.equals("Por favor, llene todos los campos obligatorios")) {
                WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Por favor, llene todos los campos obligatorios')]"));
                assertEquals("Por favor, llene todos los campos obligatorios", errorMessage.getText().trim());
                addText("Prueba correcta: Se muestra el mensaje de error esperado");
            }
        } catch (Exception e) {
            addText("Prueba Fallida " );
            captureScreenShot();
            fail("Prueba Fallida " );
        } finally {
            wait(1);
            this.driver.quit();
            closePDF();
        }
    }
}
