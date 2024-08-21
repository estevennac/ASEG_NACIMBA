package gestion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class UpdatePersonalSuccessStepDefinitions extends BasicStepDefinition {

    @Given("el usuario accede a la página de gestión de personal")
    public void elUsuarioAccedeALaPaginaDeGestionDePersonal() {
        createPDF("UpdateDocenteExitoso");
        addText("Inicio de prueba: el usuario accede a la página de gestión de personal");
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/UpdatePersonal");
    }

    @When("el usuario selecciona el docente con ID {string}")
    public void elUsuarioSeleccionaElDocenteConID(String iddocente) {
        addText("el usuario selecciona el docente con ID: " + iddocente);
        WebElement selectButton = driver.findElement(By.xpath("//tr[td[text()='" + iddocente + "']]//img[@alt='Actualizar']"));
        selectButton.click();
    }

    @When("el usuario actualiza los datos del docente con {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void elUsuarioActualizaLosDatosDelDocente(String apellidos, String nombres, String cedula, String nacionalidad, String genero, String correop, String correoi, String ciudad, String provincia, String numero, String campus, String observacion) {
        addText("el usuario actualiza los datos del docente");

        WebElement apellidosInput = driver.findElement(By.name("apellidos"));
        apellidosInput.clear();
        apellidosInput.sendKeys(apellidos);

        WebElement nombresInput = driver.findElement(By.name("nombres"));
        nombresInput.clear();
        nombresInput.sendKeys(nombres);

        WebElement cedulaInput = driver.findElement(By.name("cedula"));
        cedulaInput.clear();
        cedulaInput.sendKeys(cedula);

        WebElement nacionalidadInput = driver.findElement(By.name("nacionalidad"));
        nacionalidadInput.clear();
        nacionalidadInput.sendKeys(nacionalidad);

        WebElement generoSelect = driver.findElement(By.name("genero"));
        generoSelect.sendKeys(genero);

        WebElement correopInput = driver.findElement(By.name("correop"));
        correopInput.clear();
        correopInput.sendKeys(correop);

        WebElement correoiInput = driver.findElement(By.name("correoi"));
        correoiInput.clear();
        correoiInput.sendKeys(correoi);

        WebElement ciudadSelect = driver.findElement(By.name("ciudad"));
        ciudadSelect.sendKeys(ciudad);

        WebElement provinciaSelect = driver.findElement(By.name("provincia"));
        provinciaSelect.sendKeys(provincia);

        WebElement numeroInput = driver.findElement(By.name("numero"));
        numeroInput.clear();
        numeroInput.sendKeys(numero);

        WebElement campusInput = driver.findElement(By.name("campus"));
        campusInput.clear();
        campusInput.sendKeys(campus);

        WebElement observacionInput = driver.findElement(By.name("observacion"));
        observacionInput.clear();
        observacionInput.sendKeys(observacion);

        captureScreenShot();
        WebElement updateButton = driver.findElement(By.xpath("//button[text()='Actualizar']"));
        updateButton.click();
    }

    @Then("el resultado de la actualización es {string}")
    public void elResultadoDeLaActualizacionEs(String resultadoEsperado) {
        addText("Verificación del resultado de la actualización");
        wait(2);
        captureScreenShot();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Personal actualizado correctamente')]"));
        assertEquals("Personal actualizado correctamente", successMessage.getText().trim());
        addText("Prueba correcta: La actualización se realizó con éxito.");

        this.driver.quit();
        closePDF();
    }
}
