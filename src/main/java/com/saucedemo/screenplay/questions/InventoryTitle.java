package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class InventoryTitle implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.TITLE).answeredBy(actor);
    }

    public static InventoryTitle value() {
        return new InventoryTitle();
    }
}
