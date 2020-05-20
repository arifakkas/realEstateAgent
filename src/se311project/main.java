package se311project;

import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.*;
import java.time.Month;
import static java.time.temporal.ChronoUnit.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class main {

    private static Customer _activeCustomer;

    public static void activateUser(Customer customer) {
        _activeCustomer = customer;
    }

    public static Customer getActiveUser() {
        return _activeCustomer;
    }

    public static void logOff() {
        _activeCustomer = null;
    }

    public static void mainMenu() throws ClassNotFoundException, IOException {

        Scanner input = new Scanner(System.in);
        Boolean status = true;

        while (status) {
            System.out.println("\n");
            System.out.println("***********    MENU    ***********");
            System.out.println("Please Choose An Option:");
            System.out.println("1 -> Customer");
            System.out.println("2 -> Agent");
            System.out.println("3 -> Exit");
            System.out.println("**********************************");
            System.out.println("\n");
            System.out.print("Please select your user type: ");
            System.out.println("");
            String choice = input.next();
            int i;
            try {
                i = Integer.parseInt(choice);
            } catch (Exception e) {
                i = 0;
                System.out.println("Please select appropiate choice");
            }
            if (i == 1) {
                customerEntry();
            } else if (i == 2) {
                //agentMenu();
            } else if (i == 3) {
                System.out.println("Thank you, until next time");
                System.exit(1);
            } else {
                mainMenu();
            }
        }

    }

    public static void customerEntry() throws ClassNotFoundException, IOException {
        Scanner input = new Scanner(System.in);

        Boolean status = true;

        while (status) {
            System.out.println("\n");
            System.out.println("***********   CUSTOMER ENTRY POINT    ***********");
            System.out.println("Please Choose An Option:");
            System.out.println("1 -> Sign in");
            System.out.println("2 -> Sign up");
            System.out.println("3 -> Back to Main Menu");
            System.out.println("4 -> Exit");
            System.out.println("*************************************************");
            System.out.println("\n");
            String choice = input.next();
            int i;
            try {
                i = Integer.parseInt(choice);
            } catch (Exception e) {
                i = 0;
                System.out.println("Please select appropiate choice");
            }
            if (i == 1) {
                customerSignIn();
            } else if (i == 2) {
                customerRegister();
            } else if (i == 3) {
                mainMenu();
            } else if (i == 4) {
                System.exit(1);
            } else {
                customerEntry();
            }

        }
    }

    public static void customerSignIn() throws ClassNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Please give your name");
        System.out.println("\n");
        String name = input.nextLine();
        System.out.println("\n");
        System.out.println("Please give your surname");
        System.out.println("\n");
        String surname = input.nextLine();
        Agent agent = Agent.getSingletonAgent();
        Boolean flag = false;

        Iterator parser = agent.getListOfCustomers().iterator();
        while (parser.hasNext()) {
            Customer temp = (Customer) parser.next();
            if (temp.getName().equals(name) && temp.getSurname().equals(surname)) {
                System.out.println("\n");
                System.out.println("Welcome    " + name + " " + surname);
                flag = true;
                activateUser(temp);
                customerMenu();
                return;

            }
        }
        if (flag == false) {
            System.out.println("System couldn't find that user");
        }

    }

    public static void customerRegister() throws ClassNotFoundException, IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Please Type Your Name");
        System.out.println("\n");
        String name = input.nextLine();
        System.out.println("\n");
        System.out.println("Please Type Your Surname");
        System.out.println("\n");
        String surname = input.nextLine();
        System.out.println("\n");
        System.out.println("Please Type Your Identity Number");
        System.out.println("\n");
        Boolean status = true;
        Long iNumber = 0L;
        String identityNumber = input.nextLine();
        if (identityNumber.matches("[0-9]+")) {
            iNumber = Long.parseLong(identityNumber);

        } else {
            while (status) {
                System.out.println("Please give appropriate identity number!");
                identityNumber = input.nextLine();
                if (identityNumber.matches("[0-9]+")) {
                    status = false;
                    iNumber = Long.parseLong(identityNumber);
                } else {

                }
            }
        }

        Agent agent = Agent.getSingletonAgent();
        try {
            Command command = new customerCommands(0, name, surname, iNumber);
            agent.executeCommand(command);
            System.out.println("\n");
            System.out.println("You have succesfully signed up\t" + name + " " + surname);

            customerEntry();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void customerMenu() throws ClassNotFoundException, IOException {
        Scanner input = new Scanner(System.in);

        Boolean status = true;

        while (status) {
            System.out.println("\n");
            System.out.println("***********   CUSTOMER MENU    ***********");
            System.out.println("Please Choose An Option:");
            System.out.println("1 -> Sell or Rent Estate");
            System.out.println("2 -> Register Your Preferences");
            System.out.println("3 -> See Your Preferences");
            System.out.println("4 -> Delete Your Preferences");
            System.out.println("5 -> Check estates matches with your preferences");
            System.out.println("6 -> Check all the estates");
            System.out.println("7 -> Exit");
            System.out.println("******************************************");
            System.out.println("\n");
            String choice = input.next();
            int i;
            try {
                i = Integer.parseInt(choice);
            } catch (Exception e) {
                i = 0;
                System.out.println("Please select appropiate choice");
            }
            if (i == 1) {
                createEstate(1);
            } else if (i == 2) {
                createEstate(2);
            } else if (i == 3) {
                displayPreferences();
            } else if (i == 4) {
                deletePreferences();
            } else if (i == 5) {
                advertAll();
            }else if(i == 6){
                //Display all estates with a given type, will implemented
            }
            else if (i == 7) {
                System.out.println("Thank you, until next time");
                System.exit(1);
            }

        }
    }

    public static void createEstate(int operation) throws IOException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.println("Please Select the Type of the Estate");
        System.out.println("1 -> House");
        System.out.println("2 -> Land");
        System.out.println("3 -> Store");

        String choice = input.nextLine();
        int i;
        try {
            i = Integer.parseInt(choice);
        } catch (Exception e) {
            i = 0;
            System.out.println("Please select appropiate choice");
        }
        switch (i) {
            case (1):// House
                System.out.println("Please write the Country of the Estate");
                String country = input.nextLine();
                System.out.println("Please write the Region of the Estate");
                String region = input.nextLine();
                System.out.println("Please write the City of the Estate");
                String city = input.nextLine();
                System.out.println("Please write the County of the Estate");
                String county = input.nextLine();
                System.out.println("Please write the Neighborhood of the Estate");
                String neighborhood = input.nextLine();
                Location location = null;

                location = new Location(country, region, county, city, neighborhood);
                if (location == null) {
                    System.out.println("Some problem occured");
                } else {
                    System.out.println("Location succesfully created");
                    System.out.println("is it avaliable for Sale?  Y/N");
                    Boolean status = true;
                    Boolean fSale = null;

                    while (status) {
                        String forSale = input.nextLine();
                        if (forSale.toLowerCase().equals("yes") || forSale.equals("y")) {
                            fSale = true;
                            status = false;
                        } else if (forSale.toLowerCase().equals("no") || forSale.equals("n")) {
                            fSale = false;
                            status = false;
                        } else {
                            System.out.println("Please select appropriate choice");
                        }
                    }

                    System.out.println("is it avaliable for Rent?  Y/N");
                    status = true;
                    Boolean fRent = null;

                    while (status) {
                        String forRent = input.nextLine();
                        if (forRent.toLowerCase().equals("yes") || forRent.toLowerCase().equals("y")) {
                            fRent = true;
                            status = false;
                        } else if (forRent.toLowerCase().equals("no") || forRent.toLowerCase().equals("n")) {
                            fRent = false;
                            status = false;
                        } else {
                            System.out.println("Please select appropriate choice");
                        }
                    }
                    status = true;
                    String price = null;
                    Long p = 0L;
                    System.out.println("Please give the price");
                    while (status) {
                        price = input.nextLine();
                        if (price.matches("[0-9]+")) {

                            p = Long.parseLong(price);
                            status = false;
                        } else {
                            System.out.println("Please give appropriate price");
                        }
                    }

                    LocalDate date = LocalDate.now();
                    if (operation == 1) {//create
                        Command command = new agentCommands(0, 0, location, fSale, fRent, p, date);
                        getActiveUser().getAdapter().execute(command);
                        System.out.println("Agent succesfully take the informations about the estate");
                        System.out.println("\n");
                        break;
                    } else {
                        Command command = new agentCommands(5, 0, location, fSale, fRent, p, date);
                        getActiveUser().getAdapter().execute(command);
                        System.out.println("Your preference has succesfully saved");
                        System.out.println("\n");
                        break;
                    }
                }

            case (2):// Land
                System.out.println("Please write the Country of the Estate");
                country = input.nextLine();
                System.out.println("Please write the Region of the Estate");
                region = input.nextLine();
                System.out.println("Please write the City of the Estate");
                city = input.nextLine();
                System.out.println("Please write the County of the Estate");
                county = input.nextLine();
                System.out.println("Please write the Neighborhood of the Estate");
                neighborhood = input.nextLine();
                location = null;

                location = new Location(country, region, county, city, neighborhood);
                if (location == null) {
                    System.out.println("Some problem occured");
                } else {
                    System.out.println("Location succesfully created");
                    System.out.println("is it avaliable for Sale?  Y/N");
                    Boolean status = true;
                    Boolean fSale = null;

                    while (status) {
                        String forSale = input.nextLine();
                        if (forSale.toLowerCase().equals("yes") || forSale.equals("y")) {
                            fSale = true;
                            status = false;
                        } else if (forSale.toLowerCase().equals("no") || forSale.equals("n")) {
                            fSale = false;
                            status = false;
                        } else {
                            System.out.println("Please select appropriate choice");
                        }
                    }

                    System.out.println("is it avaliable for Rent?  Y/N");
                    status = true;
                    Boolean fRent = null;

                    while (status) {
                        String forRent = input.nextLine();
                        if (forRent.toLowerCase().equals("yes") || forRent.toLowerCase().equals("y")) {
                            fRent = true;
                            status = false;
                        } else if (forRent.toLowerCase().equals("no") || forRent.toLowerCase().equals("n")) {
                            fRent = false;
                            status = false;
                        } else {
                            System.out.println("Please select appropriate choice");
                        }
                    }
                    status = true;
                    String price = null;
                    Long p = 0L;
                    System.out.println("Please give the price");
                    while (status) {
                        price = input.nextLine();
                        if (price.matches("[0-9]+")) {

                            p = Long.parseLong(price);
                            status = false;
                        } else {
                            System.out.println("Please give appropriate price");
                        }
                    }

                    LocalDate date = LocalDate.now();

                    if (operation == 1) {//create
                        Command command = new agentCommands(0, 1, location, fSale, fRent, p, date);
                        getActiveUser().getAdapter().execute(command);
                        System.out.println("Agent succesfully take the informations about the estate");
                        System.out.println("\n");
                        break;
                    } else {
                        Command command = new agentCommands(5, 1, location, fSale, fRent, p, date);
                        getActiveUser().getAdapter().execute(command);
                        System.out.println("Your preference has succesfully saved");
                        System.out.println("\n");
                        break;
                    }
                }
            case (3):// Store
                System.out.println("Please write the Country of the Estate");
                country = input.nextLine();
                System.out.println("Please write the Region of the Estate");
                region = input.nextLine();
                System.out.println("Please write the City of the Estate");
                city = input.nextLine();
                System.out.println("Please write the County of the Estate");
                county = input.nextLine();
                System.out.println("Please write the Neighborhood of the Estate");
                neighborhood = input.nextLine();
                location = null;

                location = new Location(country, region, county, city, neighborhood);
                if (location == null) {
                    System.out.println("Some problem occured");
                } else {
                    System.out.println("Location succesfully created");
                    System.out.println("is it avaliable for Sale?  Y/N");
                    Boolean status = true;
                    Boolean fSale = null;

                    while (status) {
                        String forSale = input.nextLine();
                        if (forSale.toLowerCase().equals("yes") || forSale.equals("y")) {
                            fSale = true;
                            status = false;
                        } else if (forSale.toLowerCase().equals("no") || forSale.equals("n")) {
                            fSale = false;
                            status = false;
                        } else {
                            System.out.println("Please select appropriate choice");
                        }
                    }

                    System.out.println("is it avaliable for Rent?  Y/N");
                    status = true;
                    Boolean fRent = null;

                    while (status) {
                        String forRent = input.nextLine();
                        if (forRent.toLowerCase().equals("yes") || forRent.toLowerCase().equals("y")) {
                            fRent = true;
                            status = false;
                        } else if (forRent.toLowerCase().equals("no") || forRent.toLowerCase().equals("n")) {
                            fRent = false;
                            status = false;
                        } else {
                            System.out.println("Please select appropriate choice");
                        }
                    }
                    status = true;
                    String price = null;
                    Long p = 0L;
                    System.out.println("Please give the price");
                    while (status) {
                        price = input.nextLine();
                        if (price.matches("[0-9]+")) {

                            p = Long.parseLong(price);
                            status = false;
                        } else {
                            System.out.println("Please give appropriate price");
                        }
                    }

                    LocalDate date = LocalDate.now();

                    if (operation == 1) {//create
                        Command command = new agentCommands(0, 2, location, fSale, fRent, p, date);
                        getActiveUser().getAdapter().execute(command);
                        System.out.println("Agent succesfully take the informations about the estate");
                        System.out.println("\n");
                        break;
                    } else {
                        Command command = new agentCommands(5, 2, location, fSale, fRent, p, date);
                        getActiveUser().getAdapter().execute(command);
                        System.out.println("Your preference has succesfully saved");
                        System.out.println("\n");
                        break;
                    }

                }
        }
    }

    public static void displayPreferences() throws ClassNotFoundException, IOException {
        Command command = new customerCommands(2, getActiveUser().getName(), getActiveUser().getSurname(), getActiveUser().getIdentityNumber());
        Agent agent = Agent.getSingletonAgent();
        agent.executeCommand(command);
    }

    public static void deletePreferences() throws ClassNotFoundException, IOException {
        Command command = new customerCommands(3, getActiveUser().getName(), getActiveUser().getSurname(), getActiveUser().getIdentityNumber());
        Agent agent = Agent.getSingletonAgent();
        agent.executeCommand(command);
        return;

    }

    public static void advertAll() throws ClassNotFoundException, IOException {
        System.out.println("Program will print if there is an estate matches with your preferences");
        Command command = new agentCommands(6, 1, null, Boolean.FALSE, Boolean.TRUE, Long.MIN_VALUE, LocalDate.MIN);
        Agent agent = Agent.getSingletonAgent();
        agent.executeCommand(command);
        return;
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Agent agent = Agent.getSingletonAgent();
        System.out.println("There is/are " + agent.getListOfCustomers().size() + " customers on the system.");
        System.out.println("There is/are " + agent.getListOfEstates().size() + " estates on the system.");

        mainMenu();

    }

}
