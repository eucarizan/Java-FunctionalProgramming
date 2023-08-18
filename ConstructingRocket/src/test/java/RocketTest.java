import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class RocketTest {

    @Test
    public void givenNotNullNavigationModuleWhenRocketCreatedThenExpectNotNull() {
        NavigationModule navigationModule = new NavigationModule("navModule");
        Rocket rocket = new Rocket(navigationModule);

        String result = Objects.requireNonNull(rocket.getNavigationModule().orElse(null)).getTitle();
        String expected = "navModule";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenNullNavigationModuleWhenRocketCreatedThenExpectOptionalEmpty() {
        Rocket rocket = new Rocket(null);

        String result = rocket.getNavigationModule().toString();
        String expected = "Optional.empty";

        Assert.assertEquals(expected, result);
    }
}