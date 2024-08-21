package gestion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AddContratoSuccessStepDefinitions extends BasicStepDefinition {

    @Given("el usuario está en la página de agregar contrato")
    public void elUsuarioEstaEnLaPaginaDeAgregarContrato() {
        createPDF("Agregar Contrato");
        addText("Inicio de prueba: el usuario está en la página de agregar contrato");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/AddContratos");
    }

    @When("el usuario selecciona el docente {string}, el requerimiento {string} y llena los datos {string}, {string}, {string}, {string}, {string}, {string}, {string} y {string}")
    public void elUsuarioSeleccionaElDocenteYLlenaLosDatos(String docente, String requerimiento, String fechaInicio, String fechaFin, String fuente, String fecha, String certificacionPresupuestaria, String idMemo, String analistaDelProceso, String archivoMemo) {
        addText("el usuario selecciona el docente: " + docente + ", el requerimiento: " + requerimiento + " y llena los datos: fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", fuente=" + fuente + ", fecha=" + fecha + ", certificacionPresupuestaria=" + certificacionPresupuestaria + ", idMemo=" + idMemo + ", analistaDelProceso=" + analistaDelProceso + ", archivoMemo=" + archivoMemo);

        WebElement docenteSelect = driver.findElement(By.name("IDDOCENTE"));
        WebElement requerimientoSelect = driver.findElement(By.name("IDREQUERIMIENTO"));
        WebElement fechaInicioInput = driver.findElement(By.name("FECHAINICIO"));
        WebElement fechaFinInput = driver.findElement(By.name("FECHAFIN"));
        WebElement fuenteInput = driver.findElement(By.name("FUENTE"));
        WebElement fechaInput = driver.findElement(By.name("FECHA"));
        WebElement certificacionPresupuestariaInput = driver.findElement(By.name("CERTIFICACION_PRESUPUESTARIA"));
        WebElement idMemoInput = driver.findElement(By.name("IDMEMO"));
        WebElement analistaDelProcesoInput = driver.findElement(By.name("ANALISTADELPROCESO"));
        WebElement archivoMemoInput = driver.findElement(By.name("ARCHIVOMEMO"));

        docenteSelect.sendKeys(docente);
        requerimientoSelect.sendKeys(requerimiento);
        fechaInicioInput.sendKeys(fechaInicio);
        fechaFinInput.sendKeys(fechaFin);
        fuenteInput.sendKeys(fuente);
        fechaInput.sendKeys(fecha);
        certificacionPresupuestariaInput.sendKeys(certificacionPresupuestaria);
        idMemoInput.sendKeys(idMemo);
        analistaDelProcesoInput.sendKeys(analistaDelProceso);
        archivoMemoInput.sendKeys(archivoMemo);

        captureScreenShot();
    }

    @When("el usuario hace clic en {string}")
    public void elUsuarioHaceClicEn(String botonTexto) {
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

        WebElement successMessage = driver.findElement(By.xpath("//div[text()='Contrato agregado correctamente']"));
        assertEquals("Contrato agregado correctamente", successMessage.getText().trim());
        addText("Prueba correcta: El contrato fue agregado correctamente");
        closePDF();
    }
}
