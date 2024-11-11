import java.io.Serializable;

class Author implements Serializable {
    private String name;
    private int age;

    // Konstruktor
    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }
}