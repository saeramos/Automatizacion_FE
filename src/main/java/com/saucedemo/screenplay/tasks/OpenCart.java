package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.ui.CartPage;
import com.saucedemo.screenplay.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class OpenCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.CART_BUTTON),
                Open.url("https://www.saucedemo.com/cart.html"),
                WaitUntil.the(CartPage.TITLE, WebElementStateMatchers.isVisible())
        );
    }

    public static OpenCart page() {
        return Tasks.instrumented(OpenCart.class);
    }
}
