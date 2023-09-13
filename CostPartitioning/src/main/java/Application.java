public class Application {
    private final String name;
    private final boolean free;

    public Application(String name, boolean free) {
        this.name = name;
        this.free = free;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return free;
    }

}
