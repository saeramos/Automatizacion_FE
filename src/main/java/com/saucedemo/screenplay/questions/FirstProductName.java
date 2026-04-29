package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class FirstProductName implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.FIRST_INVENTORY_ITEM_NAME).answeredBy(actor);
    }

    public static FirstProductName listed() {
        return new FirstProductName();
    }
}
