package steps.api;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;

public class BlazeDemoAPISteps2Temp {
    @Step
    public void verifyThatAppIsRunning() {
        given().get("http://blazedemo.com").then().statusCode(202);
    }
}