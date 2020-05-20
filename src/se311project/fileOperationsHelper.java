package se311project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class fileOperationsHelper {

    public fileOperationsHelper() {

    }

    public static void saveWaitingUserstoFile(ArrayList<Customer> Customers) throws IOException {
        File waitingUsers = new File("waitingUsers.dat");
        if(waitingUsers.exists()){
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
        if(users.exists()){
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
        if(estates.exists()){
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
