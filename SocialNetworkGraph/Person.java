
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

    String name;
    int age;
    List<String> hobbies;
    Date timestamp;

    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
        this.timestamp = new Date();
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Hobbies: " + hobbies + ")";
    }
}
