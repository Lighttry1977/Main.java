package jobportal;

public abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Абстрактный метод для отображения информации
    public abstract void display();
}
