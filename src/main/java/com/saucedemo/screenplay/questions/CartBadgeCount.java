package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CartBadgeCount implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.CART_BADGE).answeredBy(actor);
    }

    public static CartBadgeCount value() {
        return new CartBadgeCount();
    }
}
