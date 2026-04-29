package com.saucedemo.screenplay.stepdefinitions;

import com.saucedemo.screenplay.models.Credentials;
import com.saucedemo.screenplay.questions.CartBadgeCount;
import com.saucedemo.screenplay.questions.CartTitle;
import com.saucedemo.screenplay.questions.LoginErrorMessage;
import com.saucedemo.screenplay.tasks.AddProductsToCart;
import com.saucedemo.screenplay.tasks.Login;
import com.saucedemo.screenplay.tasks.OpenCart;
import com.saucedemo.screenplay.tasks.SortProductsBy;
import com.saucedemo.screenplay.ui.CartPage;
import com.saucedemo.screenplay.utils.TestData;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.hamcrest.Matchers;

public class SauceDemoStepDefinitions {

    private Actor usuario;

    @Before
    public void setup() {
        usuario = Actor.named("Valeria");
        usuario.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
    }

    @Given("que el usuario abre la aplicacion")
    public void queElUsuarioAbreLaAplicacion() {
        usuario.attemptsTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("inicia sesion con credenciales validas")
    public void iniciaSesionConCredencialesValidas() {
        usuario.attemptsTo(Login.with(new Credentials(TestData.STANDARD_USER, TestData.VALID_PASSWORD)));
    }

    @When("ordena los productos por {string}")
    public void ordenaLosProductosPor(String criterio) {
        usuario.attemptsTo(SortProductsBy.option(criterio));
    }

    @When("agrega dos productos al carrito")
    public void agregaDosProductosAlCarrito() {
        usuario.attemptsTo(AddProductsToCart.selectedOnes());
    }

    @When("abre el carrito")
    public void abreElCarrito() {
        usuario.attemptsTo(OpenCart.page());
    }

    @When("inicia sesion con usuario bloqueado")
    public void iniciaSesionConUsuarioBloqueado() {
        usuario.attemptsTo(Login.with(new Credentials(TestData.LOCKED_USER, TestData.VALID_PASSWORD)));
    }

    @Then("deberia ver el titulo {string}")
    public void deberiaVerElTitulo(String tituloEsperado) {
        usuario.attemptsTo(
                WaitUntil.the(CartPage.TITLE, WebElementStateMatchers.containsText(tituloEsperado))
        );
        usuario.should(GivenWhenThen.seeThat(CartTitle.value(), Matchers.is(tituloEsperado)));
    }

    @Then("deberia ver {int} productos en el badge del carrito")
    public void deberiaVerProductosEnElBadgeDelCarrito(int cantidadEsperada) {
        usuario.should(GivenWhenThen.seeThat(CartBadgeCount.value(), Matchers.is(String.valueOf(cantidadEsperada))));
    }

    @Then("deberia ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String mensajeEsperado) {
        usuario.should(GivenWhenThen.seeThat(LoginErrorMessage.visible(), Matchers.is(mensajeEsperado)));
    }
}
