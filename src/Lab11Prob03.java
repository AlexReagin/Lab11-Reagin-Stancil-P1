import java.io.*;
import java.util.*;

public class Lab11Prob03 {
    public static void main(String[] args) {
        String inputFile  = "src/people.dat";
        String outputFile = "src/people-salary-sorted-objects.dat";

        List<Person> people = new ArrayList<>();

        try ( DataInputStream in = new DataInputStream(
                                      new BufferedInputStream(
                                        new FileInputStream(inputFile))) ) {
            while (true) {
                int    age     = in.readInt();
                String name    = in.readUTF();
                String address = in.readUTF();
                int    zip     = in.readInt();
                double salary  = in.readDouble();

                people.add(new Person(age, name, address, zip, salary));
            }
        } catch (EOFException eof) {
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Collections.sort(people);

        try ( ObjectOutputStream oos = new ObjectOutputStream(
                                        new BufferedOutputStream(
                                          new FileOutputStream(outputFile))) ) {
            for (Person p : people) {
                oos.writeObject(p);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}