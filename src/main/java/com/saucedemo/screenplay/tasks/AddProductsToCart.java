package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductsToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.FIRST_ADD_TO_CART_BUTTON),
                Click.on(ProductsPage.SECOND_ADD_TO_CART_BUTTON)
        );
    }

    public static AddProductsToCart selectedOnes() {
        return Tasks.instrumented(AddProductsToCart.class);
    }
}
