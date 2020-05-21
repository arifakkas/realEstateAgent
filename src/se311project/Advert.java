package se311project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
//This class is the Subject class of the Observer pattern
// Serializable is used to write objects

abstract class Advert implements Serializable {

    //ArrayList will be using to keep track of the investors

    protected ArrayList<Customer> _waitingCustomers = new ArrayList<Customer>();
    protected Estate _estate;

    public ArrayList<Customer> getWaitingCustomers() {
        return this._waitingCustomers;
    }

    //File reading

    public void setWaitingUsers() throws ClassNotFoundException, IOException {
        _waitingCustomers = fileOperationsHelper.readWaitingUsers();
    }

    //Attach method of the Observer Pattern

    public void Attach(Customer customer) throws IOException {
        _waitingCustomers.add(customer);
        fileOperationsHelper.saveWaitingUserstoFile(_waitingCustomers);
    }

    public Estate getEstate() {
        return this._estate;
    }

    //Detach method of the Observer Pattern

    public void Detach(Customer customer) {
        Iterator parser = _waitingCustomers.iterator();

        while (parser.hasNext()) {

            Customer tempCustomer = (Customer) parser.next();

            if (tempCustomer.getName().equals(customer.getName())
                    && tempCustomer.getIdentityNumber() == customer.getIdentityNumber()) {
                _waitingCustomers.remove(tempCustomer);
                return;
            }
        }

    }

    //Notify method of the Observer Pattern
    //For each preference of the user, Notify method will update the user
    //If the preference of the user and adverted estate matches

    public void Notify(Estate estate) {
        Iterator parser = _waitingCustomers.iterator();
        while (parser.hasNext()) {
            Customer tempCustomer = (Customer) parser.next();
            if (tempCustomer.getPreference1() != null) {
                if (tempCustomer.getPreference1().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference1().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && tempCustomer.getPreference1().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference1().getPrice() - 50000 <= estate.getPrice()
                        && estate.getPrice() <= tempCustomer.getPreference1().getPrice() + 50000)
                        && (Objects.equals(tempCustomer.getPreference1().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference1().getForRent(), estate.getForRent()))) {
                    this._estate = estate;
                    tempCustomer.Update(this);
                }

            }
            if (tempCustomer.getPreference2() != null) {
                if (tempCustomer.getPreference2().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference2().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference2().getPrice() - 50000 <= estate.getPrice()
                        || estate.getPrice() <= tempCustomer.getPreference2().getPrice() + 50000)
                        && (Objects.equals(tempCustomer.getPreference2().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference2().getForRent(), estate.getForRent()))) {
                    this._estate = estate;
                    tempCustomer.Update(this);
                }
            }
            if (tempCustomer.getPreference3() != null) {
                if (tempCustomer.getPreference3().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference3().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference3().getPrice() - 50000.0 <= estate.getPrice()
                        && estate.getPrice() <= tempCustomer.getPreference3().getPrice() + 50000.0)
                        && (Objects.equals(tempCustomer.getPreference3().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference3().getForRent(), estate.getForRent()))) {
                    this._estate = estate;
                    tempCustomer.Update(this);
                }
            }

        }

    }
}
