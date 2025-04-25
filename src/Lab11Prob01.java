import java.io.*;
public class Lab11Prob01 {
    public static void main(String[] args) {
        String inputFile  = "src/people.dat";
        String outputFile = "src/people-copy.dat";

        try (
            DataInputStream  in  = new DataInputStream(
                                     new BufferedInputStream(
                                       new FileInputStream(inputFile)));
            DataOutputStream out = new DataOutputStream(
                                     new BufferedOutputStream(
                                       new FileOutputStream(outputFile)));
        ) {
            while (true) {
                int    age     = in.readInt();
                String name    = in.readUTF();    
                String address = in.readUTF();     
                int    zip     = in.readInt();
                double salary  = in.readDouble();

                System.out.printf(
                  "Age: %d, Name: %s, Address: %s, Zip: %d, Salary: %.2f%n",
                  age, name, address, zip, salary);

                out.writeInt(age);
                out.writeUTF(name);
                out.writeUTF(address);
                out.writeInt(zip);
                out.writeDouble(salary);
            }
        } catch (EOFException eof) {
            System.out.println("Finished reading all records.");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}