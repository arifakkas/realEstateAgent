package se311project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// This class is using for reading and saving to the file
// 3 files will be created when the program runs
// One of them holds the customers as object
// One of them holds the estates as object
// And the last one holds the waitingUsers in the Observer Pattern
public class fileOperationsHelper {

    public static void saveWaitingUserstoFile(ArrayList<Customer> Customers) throws IOException {
        File waitingUsers = new File("waitingUsers.dat");
        // This if clause is using to avoid over writing
        if (waitingUsers.exists()) {
            waitingUsers.delete();
        }
        FileOutputStream fos = new FileOutputStream("waitingUsers.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Customer c : Customers) {
            oos.writeObject(c);
        }
        fos.close();
        oos.close();
    }

    public static ArrayList<Customer> readWaitingUsers() throws ClassNotFoundException, IOException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        File waitingusersFile = new File("waitingUsers.dat");
        waitingusersFile.createNewFile();
        // This file creation process is using to avoid exceptions related with
        // file not found

        try {
            FileInputStream fi = new FileInputStream(new File("waitingUsers.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                customers.add((Customer) oi.readObject());
            }
            oi.close();
            fi.close();
        } catch (Exception e) {

        }

        return customers;
    }

    public static void saveUsersToFile(ArrayList<Customer> Customers) throws IOException {
        File users = new File("users.dat");
        // This if clause is using to avoid over writing
        if (users.exists()) {
            users.delete();
        }
        FileOutputStream fos = new FileOutputStream("users.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Customer c : Customers) {
            oos.writeObject(c);
        }
        fos.close();
        oos.close();
    }

    public static void saveEstatesToFile(ArrayList<Estate> Estates) throws IOException {
        File estates = new File("estates.dat");
        // This if clause is using to avoid over writing
        if (estates.exists()) {
            estates.delete();
        }
        FileOutputStream fos = new FileOutputStream("estates.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Estate e : Estates) {
            oos.writeObject(e);
        }
        fos.close();
        oos.close();
    }

    public static ArrayList<Customer> readUsers() throws ClassNotFoundException, IOException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        File usersFile = new File("users.dat");
        usersFile.createNewFile();
        // This file creation process is using to avoid exceptions related with
        // file not found

        try {
            FileInputStream fi = new FileInputStream(new File("users.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                customers.add((Customer) oi.readObject());
            }
            oi.close();
            fi.close();
        } catch (Exception e) {

        }

        return customers;
    }

    public static ArrayList<Estate> readEstates() throws ClassNotFoundException, IOException {
        ArrayList<Estate> estates = new ArrayList<Estate>();
        File estatesFile = new File("estates.dat");
        estatesFile.createNewFile();
        // This file creation process is using to avoid exceptions related with
        // file not found

        try {
            FileInputStream fi = new FileInputStream(new File("estates.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                estates.add((Estate) oi.readObject());
            }
            oi.close();
            fi.close();
        } catch (Exception e) {

        }

        return estates;
    }
}
