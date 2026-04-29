package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target TITLE = Target.the("titulo del carrito")
            .locatedBy(".title");

    public static final Target INVENTORY_ITEMS = Target.the("items en carrito")
            .locatedBy(".cart_item");

    private CartPage() {
    }
}
