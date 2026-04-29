package com.saucedemo.screenplay.tasks;

import com.saucedemo.screenplay.models.Credentials;
import com.saucedemo.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Tasks;

public class Login implements Task {

    private final Credentials credentials;

    public Login(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(credentials.getUsername()).into(LoginPage.USERNAME),
                Enter.theValue(credentials.getPassword()).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static Login with(Credentials credentials) {
        return Tasks.instrumented(Login.class, credentials);
    }
}
