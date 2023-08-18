public class Main {
    public static void main(String[] args) {
        Rocket rocket1 = new Rocket(new NavigationModule("navMod"));
        System.out.println(rocket1.getNavigationModule().get().getTitle());

        Rocket rocket2 = new Rocket(null);
        System.out.println(rocket2.getNavigationModule());
    }
}
