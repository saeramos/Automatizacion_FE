package com.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {

    public static final Target TITLE = Target.the("titulo de productos")
            .locatedBy(".title");

    public static final Target SORT_DROPDOWN = Target.the("filtro de orden")
            .locatedBy(".product_sort_container");

    public static final Target FIRST_ADD_TO_CART_BUTTON = Target.the("primer boton agregar al carrito")
            .locatedBy("(//button[contains(.,'Add to cart')])[1]");

    public static final Target SECOND_ADD_TO_CART_BUTTON = Target.the("segundo boton agregar al carrito")
            .locatedBy("(//button[contains(.,'Add to cart')])[2]");

    public static final Target FIRST_INVENTORY_ITEM_NAME = Target.the("primer producto listado")
            .locatedBy(".inventory_item_name");

    public static final Target CART_BADGE = Target.the("contador del carrito")
            .locatedBy(".shopping_cart_badge");

    public static final Target CART_BUTTON = Target.the("icono del carrito")
            .locatedBy(".shopping_cart_link");

    private ProductsPage() {
    }
}
