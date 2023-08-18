import java.util.Optional;

public class Rocket {
    private final NavigationModule navigationModule;

    public Rocket(NavigationModule navigationModule) {
        this.navigationModule = navigationModule;
    }

    public Optional<NavigationModule> getNavigationModule() {
        // write your code here
        return Optional.ofNullable(navigationModule);
    }
}
