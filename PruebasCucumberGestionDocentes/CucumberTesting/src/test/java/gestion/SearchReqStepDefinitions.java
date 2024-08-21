package gestion;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchReqStepDefinitions extends BasicStepDefinition {

    private boolean testPassed;
    private static int scenarioCounter = 0;

    @Given("el usuario está en la página de búsqueda de requerimientos")
    public void elUsuarioEstaEnLaPaginaDeBusquedaDeRequerimientos() {
        createPDF("BusquedaRequerimientos");
        addText("Inicio de prueba: el usuario está en la página de búsqueda de requerimientos");
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/SearchReq");
        testPassed = true;
        scenarioCounter++;
    }

    @When("el usuario ingresa {string} en el campo de búsqueda")
    public void elUsuarioIngresaEnElCampoDeBusqueda(String searchQuery) {
        addText("El usuario ingresa en el campo de búsqueda: " + searchQuery);
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='BUSCAR....']"));
        searchInput.sendKeys(searchQuery);
        captureScreenShot();
    }

    @Then("el sistema debe mostrar {string}")
    public void elSistemaDebeMostrar(String expectedResult) {
        addText("Verificación del resultado de búsqueda");

        List<WebElement> results = driver.findElements(By.cssSelector(".content-table tbody tr"));
        boolean resultsFound = results.size() > 0;

        if (expectedResult.equals("No se encontraron resultados")) {
            if (resultsFound) {
                addText("Prueba fallida: Se esperaban 'No se encontraron resultados', pero se encontraron resultados.");
                testPassed = false;
            }
            assertTrue("Se esperaban 'No se encontraron resultados', pero se encontraron resultados.", !resultsFound);
        } else {
            if (!resultsFound) {
                addText("Prueba fallida: No se encontraron los resultados esperados para la búsqueda: " + expectedResult);
                testPassed = false;
            }
            assertTrue("No se encontraron resultados para la búsqueda: " + expectedResult, resultsFound);
        }

        captureScreenShot();
    }

    @After
    public void tearDown() {
        if (testPassed) {
            addText("Prueba exitosa.");
        } else {
            addText("Prueba fallida.");
        }

        captureScreenShot();
        closePDF();
        if (driver != null) {
            driver.quit();
        }

        // Verifica que la prueba haya pasado
        assertTrue("La prueba ha fallado.", testPassed);
    }
}
