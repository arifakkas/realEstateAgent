package se311project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

// This class is one of the Concrete Subjects of the Observer Pattern
// Singleton pattern is used
public class houseAdvert extends Advert implements Serializable {

    private static houseAdvert _houseAdvert;

    private houseAdvert() {
    }

    public static houseAdvert getHouseAdverter() {

        if (_houseAdvert == null) {

            _houseAdvert = new houseAdvert();

        }
        return _houseAdvert;
    }

    protected Estate _estate;

    public void setEstate(Estate estate) {
        this._estate = estate;
    }

    @Override
    public void setWaitingUsers() throws ClassNotFoundException, IOException {
        super.setWaitingUsers();
    }

    @Override
    public ArrayList<Customer> getWaitingCustomers() {
        return super.getWaitingCustomers();
    }

    // advert method
    // If adverted estate matches with the waiting users preferences
    // user will be notified
    public void advert(Estate estate) {
        Iterator parser = _waitingCustomers.iterator();
        while (parser.hasNext()) {

            Customer tempCustomer = (Customer) parser.next();

            if (tempCustomer.getPreference1() != null) {
                if (tempCustomer.getPreference1().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference1().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference1().getPrice() - 50000 <= estate.getPrice()
                        || estate.getPrice() <= tempCustomer.getPreference1().getPrice() + 50000)
                        && (Objects.equals(tempCustomer.getPreference1().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference1().getForRent(), estate.getForRent()))) {
                    Notify(estate);
                }
            }
            if (tempCustomer.getPreference2() != null) {
                if (tempCustomer.getPreference2().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference2().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference2().getPrice() - 50000 <= estate.getPrice()
                        || estate.getPrice() <= tempCustomer.getPreference2().getPrice() + 50000)
                        && (Objects.equals(tempCustomer.getPreference2().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference2().getForRent(), estate.getForRent()))) {
                    Notify(estate);
                }
            }
            if (tempCustomer.getPreference3() != null) {
                if (tempCustomer.getPreference3().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference3().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference3().getPrice() - 50000 <= estate.getPrice()
                        || estate.getPrice() <= tempCustomer.getPreference3().getPrice() + 50000)
                        && (Objects.equals(tempCustomer.getPreference3().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference3().getForRent(), estate.getForRent()))) {
                    Notify(estate);
                }
            }
        }
    }
}
