import java.io.*;
import java.util.*;

public class Lab11Prob02 {
    public static void main(String[] args) {
        String inFile  = "src/people.dat";
        String outFile = "src/people-salary-sorted.dat";

        List<Person> people = new ArrayList<>();

        try ( DataInputStream in = new DataInputStream(
                                      new BufferedInputStream(
                                          new FileInputStream(inFile))) ) {
            while (true) {
                int    age     = in.readInt();
                String name    = in.readUTF();
                String address = in.readUTF();
                int    zip     = in.readInt();
                double salary  = in.readDouble();

                people.add(new Person(age, name, address, zip, salary));
            }
        } catch (EOFException eof) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(people);

        try ( DataOutputStream out = new DataOutputStream(
                                       new BufferedOutputStream(
                                           new FileOutputStream(outFile))) ) {
            for (Person p : people) {
                out.writeUTF(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}