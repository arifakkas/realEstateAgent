package se311project;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Agent extends agentAdapter implements Serializable {

    private String _name;
    private String _surname;
    private String _address;
    private int _identityNumber;
    private int _totalCountofEstates;
    private ArrayList<Customer> _listOfCustomers;
    private ArrayList<Estate> _listOfEstates;
    private ArrayList<String> _messages;
    private houseAdvert _houseAdvert;
    private landAdvert _landAdvert;
    private storeAdvert _storeAdvert;
    private static Agent _singletonAgent;

    private Agent() {
        //Singleton
    }

    public static Agent getSingletonAgent() throws ClassNotFoundException, IOException {

        if (_singletonAgent == null) {

            _singletonAgent = new Agent();
            _singletonAgent.setName("Arif");
            _singletonAgent.setSurname("Akkaş");
            _singletonAgent.setAddress("Gaybi Efendi Mah. Uysal Sok. No=27");
            _singletonAgent._listOfCustomers = new ArrayList<>();
            _singletonAgent._listOfEstates = new ArrayList<>();
            _singletonAgent._messages = new ArrayList<>();

            _singletonAgent._houseAdvert = houseAdvert.getHouseAdverter();
            _singletonAgent._landAdvert = landAdvert.getLandAdverter();
            _singletonAgent._storeAdvert = storeAdvert.getStoreAdverter();
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

    public void CustomerOperations(int operation, String customerName, String customerSurname,
            Long identityNumber) throws ClassNotFoundException, IOException {
        if (operation == 0) {//Create customer
            Customer tempCustomer = new Customer(customerName, customerSurname, identityNumber);
            _singletonAgent.addToList(tempCustomer);
            fileOperationsHelper.saveUsersToFile(_listOfCustomers);
        } else if (operation == 1) {

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
                                + " -> " + tempCustomer.getPreference1().getLocation().getCity()
                                + " -> " + tempCustomer.getPreference1().getLocation().getCity()
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
                                + "->" + tempCustomer.getPreference2().getLocation().getCity()
                                + "->" + tempCustomer.getPreference2().getLocation().getCity()
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
                                + "->" + tempCustomer.getPreference3().getLocation().getCity()
                                + "->" + tempCustomer.getPreference3().getLocation().getCity()
                                + "->" + tempCustomer.getPreference3().getLocation().getNeighborhood()
                        );
                        System.out.println("Is for Sale = " + tempCustomer.getPreference3().getForSale().toString());
                        System.out.println("Is for Rent = " + tempCustomer.getPreference3().getForRent().toString());
                        System.out.println("Price = " + tempCustomer.getPreference3().getPrice() + "$");

                    }
                }
            }
        } else if (operation == 3) {//Delete preferences
            main.getActiveUser().setPreference1(null);
            main.getActiveUser().setPreference2(null);
            main.getActiveUser().setPreference3(null);
            _houseAdvert.Detach(main.getActiveUser());
            System.out.println("All preferences have been deleted");
            fileOperationsHelper.saveUsersToFile(_listOfCustomers);

        } else if (operation == 4) {
            Iterator parser = _singletonAgent._listOfEstates.iterator();
            Estate tempEstate = (Estate) parser.next();
        }
    }

    public void EstateOperations(int operation, int estateType, Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) throws IOException, ClassNotFoundException {

        if (operation == 0) {//Create Estate
            _listOfCustomers = fileOperationsHelper.readUsers();
            _listOfEstates = fileOperationsHelper.readEstates();
            if (estateType == 0) {//House
                House tempEstate = (House) EstateCreator.createEstate(0, location, forSale, forRent, price, date);
                _listOfEstates.add(tempEstate);
                fileOperationsHelper.saveEstatesToFile(_listOfEstates);
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
            Iterator parser = _listOfEstates.iterator();
            while (parser.hasNext()) {
                Estate searchedEstate = (Estate) parser.next();
                if (searchedEstate.getLocation().getNeighborhood().equals(location.getNeighborhood())
                        && Objects.equals(searchedEstate.getPrice(), price)
                        && searchedEstate.getDate().equals(date)) {
                    System.out.println("An estate has been deleted!");
                    _listOfEstates.remove(searchedEstate);
                    fileOperationsHelper.saveEstatesToFile(_listOfEstates);
                    return;
                }
            }
        } else if (operation == 2) {//get the total count
            _listOfEstates = fileOperationsHelper.readEstates();
            _totalCountofEstates = getTotalCountofEstates();
            System.out.println("Total count of estates = " + _totalCountofEstates);
        } else if (operation == 3) {//delete the estates which are older than 6 months
            _listOfEstates = fileOperationsHelper.readEstates();
            Iterator parser = _listOfEstates.iterator();
            while (parser.hasNext()) {
                Estate tempEstate = (Estate) parser.next();
                if ((MONTHS.between(tempEstate.getDate(), LocalDate.now())) >= 6) {
                    Command command = new agentCommands(1, 0, tempEstate.getLocation(),
                            tempEstate.getForSale(), tempEstate.getForRent(),
                            tempEstate.getPrice(), tempEstate.getDate());
                    command.executeCommand();
                    fileOperationsHelper.saveEstatesToFile(_listOfEstates);
                }
            }
        } else if (operation == 4) {//Advert estate
            
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

        } else if (operation == 6) {
            Iterator parser = getListOfEstates().iterator();
            int type = 0;

            while (parser.hasNext()) {

                Estate tempEstate = (Estate) parser.next();
                if (tempEstate.getClass().equals(House.class)) {
                    type = 0;
                } else if (tempEstate.getClass().equals(Land.class)) {
                    type = 1;
                } else if (tempEstate.getClass().equals(Store.class)) {
                    type = 2;
                }
                Command command = new agentCommands(4, type, tempEstate.getLocation(), tempEstate.getForSale(), tempEstate.getForRent(),
                        tempEstate.getPrice(), tempEstate.getDate());
                _singletonAgent.executeCommand(command);
            }

        }
    }

    public void executeCommand(Command command) throws IOException, ClassNotFoundException {
        command.executeCommand();
    }
}
