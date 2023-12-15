package Seminar6_Lesson;

// import java.util.List;
import java.util.Objects;

// task 2, task3, task4
public class Cat {

    private String owner;
    private String name;
    private int age;
    private String bread;
    // private List<String> heathList;

    @Override
    public String toString() {
        return "Cat{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bread='" + bread + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(owner, cat.owner) && Objects.equals(name, cat.name)
                && Objects.equals(bread, cat.bread);
    }

    @Override
    public int hashCode() {
        // return Objects.hash(owner, name, age, bread);
        return 8 * name.hashCode() + 11 * owner.hashCode() + 27 * age + 31 * bread.hashCode();
    }

    public Cat(String owner, String name, int age, String bread) {
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.bread = bread;
    }
}
