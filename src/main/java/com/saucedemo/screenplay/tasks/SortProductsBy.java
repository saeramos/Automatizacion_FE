package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SortProductsBy implements Task {

    private final String visibleText;

    public SortProductsBy(String visibleText) {
        this.visibleText = visibleText;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(visibleText).from(ProductsPage.SORT_DROPDOWN)
        );
    }

    public static SortProductsBy option(String visibleText) {
        return Tasks.instrumented(SortProductsBy.class, visibleText);
    }
}
