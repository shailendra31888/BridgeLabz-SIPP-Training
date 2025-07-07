public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person person) {
        this.name = person.name;
        this.age = person.age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person(person1);
        person1.display();
        person2.display();
    }
}