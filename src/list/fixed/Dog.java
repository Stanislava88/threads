package list.fixed;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Dog {

    private String name;

    public Dog(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
