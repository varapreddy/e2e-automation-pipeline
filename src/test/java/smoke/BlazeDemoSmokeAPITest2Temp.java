package smoke;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.BlazeDemoAPISteps;
import steps.api.BlazeDemoAPISteps2Temp;
import steps.api.FindFlightsAPISteps;

@RunWith(SerenityRunner.class)
public class BlazeDemoSmokeAPITest2Temp {
    @Steps
    BlazeDemoAPISteps2Temp blazeDemoAPISteps2Temp;

    @Test
    @WithTag(type="type", name="Smoke")
    public void verifyFlightsSearchWithAPI() {
    	System.out.println("vara");
        blazeDemoAPISteps2Temp.verifyThatAppIsRunning();
    }
}
