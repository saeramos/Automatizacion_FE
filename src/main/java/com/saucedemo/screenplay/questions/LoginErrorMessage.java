package com.saucedemo.screenplay.questions;

import com.saucedemo.screenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginErrorMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor);
    }

    public static LoginErrorMessage visible() {
        return new LoginErrorMessage();
    }
}
