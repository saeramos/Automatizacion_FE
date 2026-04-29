package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartItemsCount implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return CartPage.INVENTORY_ITEMS.resolveAllFor(actor).size();
    }

    public static CartItemsCount value() {
        return new CartItemsCount();
    }
}
