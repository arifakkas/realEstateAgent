package se311project;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

// Agent of the Agency. Handles all of the work
// Facade of the facade pattern
// It is also both invoker and receiver of the Command pattern
// Serializable is implemented to write object
// We think estate rent and estate sale implementations and keeping track of them
// will be very annoying and we didn't implement them since the project is all about
// using the patterns appropriately
public class Agent implements Serializable {

    private String _name;
    private String _surname;
    private String _address;
    private int _identityNumber;
    private int _totalCountofEstates;
    private ArrayList<Customer> _listOfCustomers;
    private ArrayList<Estate> _listOfEstates;
    private String _password;
    private houseAdvert _houseAdvert;
    private landAdvert _landAdvert;
    private storeAdvert _storeAdvert;
    private static Agent _singletonAgent;

    private Agent() {
        //Singleton
    }

    //Singleton constructor
    public static Agent getSingletonAgent() throws ClassNotFoundException, IOException {

        if (_singletonAgent == null) {

            _singletonAgent = new Agent();
            _singletonAgent.setName("root");
            _singletonAgent.setSurname("root");
            _singletonAgent.setAddress("root");
            _singletonAgent.setPassword("root");
            _singletonAgent._listOfCustomers = new ArrayList<>();
            _singletonAgent._listOfEstates = new ArrayList<>();
            //Advert types are also singleton.
            _singletonAgent._houseAdvert = houseAdvert.getHouseAdverter();
            _singletonAgent._landAdvert = landAdvert.getLandAdverter();
            _singletonAgent._storeAdvert = storeAdvert.getStoreAdverter();
            // Users and estates are read from users whenever this method calls
            _singletonAgent._houseAdvert.setWaitingUsers();
            _singletonAgent._landAdvert.setWaitingUsers();
            _singletonAgent._storeAdvert.setWaitingUsers();
            _singletonAgent._listOfCustomers = fileOperationsHelper.readUsers();
            _singletonAgent._listOfEstates = fileOperationsHelper.readEstates();

        }
        return _singletonAgent;
    }

    public void addToList(Customer customer) {
        this._listOfCustomers.add(customer);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String surname) {
        this._surname = surname;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        this._address = address;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public int getIdentityNumber() {
        return _identityNumber;
    }

    public void setIdentityNumber(int identityNumber) {
        this._identityNumber = identityNumber;
    }

    public int getTotalCountofEstates() {
        return _listOfEstates.size();
    }

    public ArrayList<Customer> getListOfCustomers() {
        return _listOfCustomers;
    }

    public ArrayList<Estate> getListOfEstates() {
        return _listOfEstates;
    }

    // This are the commands which can be done by only knowing customer's attributes
    public void CustomerOperations(int operation, String customerName, String customerSurname,
            Long identityNumber) throws ClassNotFoundException, IOException {
        if (operation == 0) {//Create customer
            // There is no key attribute, so there can be more than one user with the same attributes
            // If we are using SQL to save users and estates, we can easily achieve that
            Customer tempCustomer = new Customer(customerName, customerSurname, identityNumber);
            _singletonAgent.addToList(tempCustomer);
            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
        } else if (operation == 1) {//Delete User
            // Iterator pattern is using to parse ArrayLists
            Iterator parser = _singletonAgent.getListOfCustomers().iterator();
            while (parser.hasNext()) {
                Customer tempCustomer = (Customer) parser.next();
                if (tempCustomer.getName().equals(customerName) && tempCustomer.getSurname().equals(customerSurname)) {
                    _singletonAgent._listOfCustomers.remove(tempCustomer);
                    fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                    System.out.println("System deleted the user " + customerName + " " + customerSurname);
                    return;
                }
            }
            System.out.println("\n");
            System.out.println("System couldn't delete that user");

        } else if (operation == 2) {//Display preferences
            _singletonAgent._listOfCustomers = fileOperationsHelper.readUsers();
            Iterator parser = _singletonAgent.getListOfCustomers().iterator();

            while (parser.hasNext()) {
                Customer tempCustomer = (Customer) parser.next();
                if (tempCustomer.getName().equals(customerName) && tempCustomer.getSurname().equals(customerSurname)) {

                    if (tempCustomer.getPreference1() == null && tempCustomer.getPreference2() == null
                            && tempCustomer.getPreference3() == null) {
                        System.out.println("You didn't give your preferences yet.");
                    }
                    if (tempCustomer.getPreference1() != null) {

                        System.out.println("\n");
                        System.out.println("Preference 1 for the customer "
                                + tempCustomer.getName() + " " + tempCustomer.getSurname());
                        System.out.println("Location = " + tempCustomer.getPreference1().getLocation().getCountry()
                                + " -> " + tempCustomer.getPreference1().getLocation().getRegion()
                                + " -> " + tempCustomer.getPreference1().getLocation().getCity()
                                + " -> " + tempCustomer.getPreference1().getLocation().getCounty()
                                + " -> " + tempCustomer.getPreference1().getLocation().getNeighborhood()
                        );
                        System.out.println("Is for Sale = " + tempCustomer.getPreference1().getForSale().toString());
                        System.out.println("Is for Rent = " + tempCustomer.getPreference1().getForRent().toString());
                        System.out.println("Price = " + tempCustomer.getPreference1().getPrice() + "$");
                    }
                    if (tempCustomer.getPreference2() != null) {
                        System.out.println("\n");
                        System.out.println("Preference 1 for the customer "
                                + tempCustomer.getName() + " " + tempCustomer.getSurname());
                        System.out.println("Location = " + tempCustomer.getPreference2().getLocation().getCountry()
                                + "->" + tempCustomer.getPreference2().getLocation().getRegion()
                                + "->" + tempCustomer.getPreference2().getLocation().getCity()
                                + "->" + tempCustomer.getPreference2().getLocation().getCounty()
                                + "->" + tempCustomer.getPreference2().getLocation().getNeighborhood()
                        );
                        System.out.println("Is for Sale = " + tempCustomer.getPreference2().getForSale().toString());
                        System.out.println("Is for Rent = " + tempCustomer.getPreference2().getForRent().toString());
                        System.out.println("Price = " + tempCustomer.getPreference2().getPrice() + "$");

                    }
                    if (tempCustomer.getPreference3() != null) {
                        System.out.println("\n");
                        System.out.println("Preference 1 for the customer "
                                + tempCustomer.getName() + " " + tempCustomer.getSurname());
                        System.out.println("Location = " + tempCustomer.getPreference3().getLocation().getCountry()
                                + "->" + tempCustomer.getPreference3().getLocation().getRegion()
                                + "->" + tempCustomer.getPreference3().getLocation().getCity()
                                + "->" + tempCustomer.getPreference3().getLocation().getCounty()
                                + "->" + tempCustomer.getPreference3().getLocation().getNeighborhood()
                        );
                        System.out.println("Is for Sale = " + tempCustomer.getPreference3().getForSale().toString());
                        System.out.println("Is for Rent = " + tempCustomer.getPreference3().getForRent().toString());
                        System.out.println("Price = " + tempCustomer.getPreference3().getPrice() + "$");

                    }
                }
            }
        } else if (operation == 3) {//Delete preferences
            Iterator parser = _listOfCustomers.iterator();
            while (parser.hasNext()) {
                Customer tempCustomer = (Customer) parser.next();
                if (tempCustomer.getName().equals(customerName)
                        && tempCustomer.getSurname().equals(customerSurname)) {
                    // Make preferences null
                    tempCustomer.setPreference1(null);
                    tempCustomer.setPreference2(null);
                    tempCustomer.setPreference3(null);
                    // Detach user from the _waitingUsers
                    _houseAdvert.Detach(tempCustomer);
                    _landAdvert.Detach(tempCustomer);
                    _storeAdvert.Detach(tempCustomer);
                    System.out.println("All preferences have been deleted");
                    fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                    fileOperationsHelper.readUsers();
                }
            }
        } else if (operation == 4) { //Show all users
            Iterator parser = _singletonAgent.getListOfCustomers().iterator();
            int counter = 0;
            while (parser.hasNext()) {
                Customer tempCustomer = (Customer) parser.next();

                System.out.println("\n");
                System.out.println("Customer name and surname = " + tempCustomer.getName()
                        + " " + tempCustomer.getSurname());
                System.out.println("Customer identity number = " + tempCustomer.getIdentityNumber());
                counter++;
            }
            if (counter == 0) {
                System.out.println("\n");
                System.out.println("There is no user on the system");
                System.out.println("\n");
            }
        }
        return;

    }

    // This are the operations related with the estates
    // Operation parameter is using to decide which methods will be called
    public void EstateOperations(int operation, int estateType, Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) throws IOException, ClassNotFoundException {

        if (operation == 0) {//Create Estate
            _listOfCustomers = fileOperationsHelper.readUsers();
            _listOfEstates = fileOperationsHelper.readEstates();
            if (estateType == 0) {//House
                House tempEstate = (House) EstateCreator.createEstate(0, location, forSale, forRent, price, date);
                _listOfEstates.add(tempEstate);
                fileOperationsHelper.saveEstatesToFile(_listOfEstates);
                // When an estate created, advert method is calling to notify the
                // waiting users. Since our project doesn't contain multithreading,
                // this is not a certain solution. If a user gives informations about
                // an estate and if it matches with his/her preferences, then
                // user can be notified with Observer Pattern.
                // We implemented another method for notification.
                EstateOperations(4, 0, location, forSale, forRent, price, date);
            } else if (estateType == 1) {//Land
                Land tempEstate = (Land) EstateCreator.createEstate(1, location, forSale, forRent, price, date);
                _listOfEstates.add(tempEstate);
                fileOperationsHelper.saveEstatesToFile(_listOfEstates);
                EstateOperations(4, 1, location, forSale, forRent, price, date);
            } else if (estateType == 2) {//Store
                Store tempEstate = (Store) EstateCreator.createEstate(2, location, forSale, forRent, price, date);
                _listOfEstates.add(tempEstate);
                fileOperationsHelper.saveEstatesToFile(_listOfEstates);
                EstateOperations(4, 2, location, forSale, forRent, price, date);
            }

        } else if (operation == 1) {//Delete Estate
            Class className = null;
            if (estateType == 0) {
                className = House.class;
            } else if (estateType == 1) {
                className = Land.class;
            } else if (estateType == 2) {
                className = Store.class;
            }
            Iterator parser = _listOfEstates.iterator();
            while (parser.hasNext()) {
                Estate searchedEstate = (Estate) parser.next();
                if (searchedEstate.getLocation().getNeighborhood().equals(location.getNeighborhood())
                        && searchedEstate.getLocation().getCounty().equals(location.getCounty())
                        && searchedEstate.getLocation().getCity().equals(location.getCity())
                        && searchedEstate.getForSale().equals(forSale)
                        && searchedEstate.getForRent().equals(forRent)
                        && searchedEstate.getClass().equals(className)) {
                    System.out.println("An estate has been deleted!");
                    _listOfEstates.remove(searchedEstate);
                    fileOperationsHelper.saveEstatesToFile(_listOfEstates);
                    return;
                }
            }
            System.out.println("\n");
            System.out.println("System couldn't find that estate");
        } else if (operation == 2) {// Get the total count
            _listOfEstates = fileOperationsHelper.readEstates();
            _totalCountofEstates = getTotalCountofEstates();
            System.out.println("Total count of estates = " + _totalCountofEstates);
        } else if (operation == 3) {// Delete the estates which are older than 6 months
            int type = 0;

            _listOfEstates = fileOperationsHelper.readEstates();
            Iterator parser = _listOfEstates.iterator();
            while (parser.hasNext()) {
                Estate tempEstate = (Estate) parser.next();
                if ((MONTHS.between(tempEstate.getDate(), LocalDate.now())) >= 6) {
                    if (tempEstate.getClass().equals(House.class)) {
                        type = 0;
                    } else if (tempEstate.getClass().equals(Land.class)) {
                        type = 1;
                    } else if (tempEstate.getClass().equals(Store.class)) {
                        type = 2;
                    }
                    // Delete command is called.
                    Command command = new agentCommands(1, type, tempEstate.getLocation(),
                            tempEstate.getForSale(), tempEstate.getForRent(),
                            tempEstate.getPrice(), tempEstate.getDate());
                    _singletonAgent.executeCommand(command);
                    fileOperationsHelper.saveEstatesToFile(_listOfEstates);
                    System.out.println("An estate has been deleted!");
                }
            }
            System.out.println("Estates which are older than 6 months have deleted");

        } else if (operation == 4) {// Advert estate
            // This method finds the given estate on the arraylist and
            // calls the advert method of the Concrete Subject classes of the
            // Observer pattern

            Iterator adverter = _listOfEstates.iterator();
            while (adverter.hasNext()) {
                Estate tempEstate = (Estate) adverter.next();
                if (tempEstate.getLocation().getCountry().equals(location.getCountry())
                        && tempEstate.getLocation().getCity().equals(location.getCity())
                        && tempEstate.getLocation().getNeighborhood().equals(location.getNeighborhood())
                        && tempEstate.getForRent().equals(forRent)
                        && tempEstate.getForSale().equals(forSale)
                        && Objects.equals(tempEstate.getPrice(), price)
                        && tempEstate.getDate().equals(date)) {
                    if (tempEstate.getClass().equals(House.class)) {
                        _houseAdvert.setEstate(tempEstate);
                        _houseAdvert.advert(tempEstate);
                    } else if (tempEstate.getClass().equals(Land.class)) {
                        _landAdvert.setEstate(tempEstate);
                        _landAdvert.advert(tempEstate);
                    } else if (tempEstate.getClass().equals(Store.class)) {
                        _storeAdvert.setEstate(tempEstate);
                        _storeAdvert.advert(tempEstate);
                    }
                    return;

                }
            }

        } else if (operation == 5) {//Set preference

            // Finds user from the arraylist and finds the appropriate preference
            // with the given estate. Create estate method is not calling because
            // preferences are not saving to arraylist. They are attribute of the
            // Customer object
            _listOfCustomers = fileOperationsHelper.readUsers();
            _listOfEstates = fileOperationsHelper.readEstates();
            Customer temp = main.getActiveUser();
            Estate preferedEstate;
            Iterator parser = _listOfCustomers.iterator();
            while (parser.hasNext()) {
                Customer tempUser = (Customer) parser.next();
                if (temp.getName().equals(tempUser.getName()) && temp.getSurname().equals(tempUser.getSurname())) {
                    if (estateType == 0) {// House
                        preferedEstate = (House) EstateCreator.createEstate(0, location, forSale, forRent, price, LocalDate.now());
                        if (tempUser.getPreference1() == null) {
                            tempUser.setPreference1(preferedEstate);
                            _houseAdvert.Attach(tempUser);
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            System.out.println("House preference 1 is fulfilled");

                        } else if (tempUser.getPreference2() == null) {
                            tempUser.setPreference2(preferedEstate);
                            System.out.println("House preference 2 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _houseAdvert.Attach(tempUser);

                        } else if (tempUser.getPreference3() == null) {
                            tempUser.setPreference3(preferedEstate);
                            System.out.println("House preference 3 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _houseAdvert.Attach(tempUser);
                        } else {
                            System.out.println("You already filled your preferences!");
                        }

                    } else if (estateType == 1) {//Land
                        preferedEstate = new Land(location, forSale, forRent, price, LocalDate.now());
                        if (tempUser.getPreference1() == null) {
                            tempUser.setPreference1(preferedEstate);
                            System.out.println("Land preference 1 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _landAdvert.Attach(tempUser);

                        } else if (tempUser.getPreference2() == null) {
                            tempUser.setPreference2(preferedEstate);
                            System.out.println("Land preference 2 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _landAdvert.Attach(tempUser);

                        } else if (tempUser.getPreference3() == null) {
                            tempUser.setPreference3(preferedEstate);
                            System.out.println("Land preference 3 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _landAdvert.Attach(tempUser);
                        } else {
                            System.out.println("You already filled your preferences!");
                        }
                    } else if (estateType == 2) {
                        preferedEstate = new Store(location, forSale, forRent, price, LocalDate.now());
                        if (tempUser.getPreference1() == null) {
                            tempUser.setPreference1(preferedEstate);
                            System.out.println("Store preference 1 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _storeAdvert.Attach(tempUser);

                        } else if (tempUser.getPreference2() == null) {
                            tempUser.setPreference2(preferedEstate);
                            System.out.println("Store preference 2 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _storeAdvert.Attach(tempUser);

                        } else if (tempUser.getPreference3() == null) {
                            tempUser.setPreference3(preferedEstate);
                            System.out.println("Store preference 3 is fulfilled");
                            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
                            _storeAdvert.Attach(tempUser);
                        } else {
                            System.out.println("You already filled your preferences!");
                        }
                    }

                }
                return;
            }

        } else if (operation == 6) {//show all estates
            // Displays the estates to the screen with a given type
            Iterator parser = getListOfEstates().iterator();
            int counter = 0;

            while (parser.hasNext()) {
                Estate tempEstate = (Estate) parser.next();

                if (estateType == 0) {
                    if (tempEstate.getClass().equals(House.class)) {
                        System.out.println("\n");
                        System.out.println("\t\tHouse\t\t");

                        System.out.println("Location = " + tempEstate.getLocation().getCountry()
                                + "->" + tempEstate.getLocation().getRegion()
                                + "->" + tempEstate.getLocation().getCity()
                                + "->" + tempEstate.getLocation().getCounty()
                                + "->" + tempEstate.getLocation().getNeighborhood()
                        );
                        System.out.println("Is for Sale = " + tempEstate.getForSale().toString());
                        System.out.println("Is for Rent = " + tempEstate.getForRent().toString());
                        System.out.println("Price = " + tempEstate.getPrice() + "$");
                        counter++;
                    }
                } else if (estateType == 1) {
                    if (tempEstate.getClass().equals(Land.class)) {
                        System.out.println("\n");
                        System.out.println("\t\tLand\t\t");

                        System.out.println("Location = " + tempEstate.getLocation().getCountry()
                                + "->" + tempEstate.getLocation().getRegion()
                                + "->" + tempEstate.getLocation().getCity()
                                + "->" + tempEstate.getLocation().getCounty()
                                + "->" + tempEstate.getLocation().getNeighborhood()
                        );
                        System.out.println("Is for Sale = " + tempEstate.getForSale().toString());
                        System.out.println("Is for Rent = " + tempEstate.getForRent().toString());
                        System.out.println("Price = " + tempEstate.getPrice() + "$");
                        counter++;
                    }
                } else if (estateType == 2) {
                    if (tempEstate.getClass().equals(Store.class)) {
                        System.out.println("\n");
                        System.out.println("\t\tStore\t\t");

                        System.out.println("Location = " + tempEstate.getLocation().getCountry()
                                + "->" + tempEstate.getLocation().getRegion()
                                + "->" + tempEstate.getLocation().getCity()
                                + "->" + tempEstate.getLocation().getCounty()
                                + "->" + tempEstate.getLocation().getNeighborhood()
                        );
                        System.out.println("Is for Sale = " + tempEstate.getForSale().toString());
                        System.out.println("Is for Rent = " + tempEstate.getForRent().toString());
                        System.out.println("Price = " + tempEstate.getPrice() + "$");
                        counter++;
                    }
                }

            }
            if (counter == 0) {
                System.out.println("\n");
                System.out.println("There is no estate with the given type");
                System.out.println("\n");
            }
        } else if (operation == 7) {// Advert all Estates
            // For all estates, it calls the advert method
            // Since this project doesn't contain multithreading,
            // a user can check the estates and if an estate matches
            // with the users preferences, then user will be notified
            // with the Observer Pattern

            Iterator parser = _singletonAgent._listOfEstates.iterator();
            while (parser.hasNext()) {
                Estate tempEstate = (Estate) parser.next();

                Command command = new agentCommands(4, 0, tempEstate.getLocation(),
                        tempEstate.getForSale(), tempEstate.getForRent(),
                        tempEstate.getPrice(), tempEstate.getDate());
                _singletonAgent.executeCommand(command);

            }
        }
    }

    // Command pattern execute command.
    public void executeCommand(Command command) throws IOException, ClassNotFoundException {
        command.executeCommand();
    }
}
