import java.text.NumberFormat;
import java.util.Locale;

public class Person implements Comparable<Person> {
    private int age;
    private String name;
    private String address;
    private int zipCode;
    private double salary;

    public Person() { }

    public Person(int age, String name, String address, int zipCode, double salary) {
        this.age     = age;
        this.name    = name;
        this.address = address;
        this.zipCode = zipCode;
        this.salary  = salary;
    }


    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return age + " "
             + name + " "
             + address + " "
             + zipCode + " "
             + nf.format(salary);
    }

    @Override
    public int compareTo(Person other) {
        return Double.compare(other.salary, this.salary);
    }
}