package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CartTitle implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CartPage.TITLE).answeredBy(actor);
    }

    public static CartTitle value() {
        return new CartTitle();
    }
}
