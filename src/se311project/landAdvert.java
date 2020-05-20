package se311project;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class landAdvert extends Advert implements Serializable{
    
    private static landAdvert _landAdvert;
    private landAdvert(){}
    
    public static landAdvert getLandAdverter() {

        if (_landAdvert == null) {

           _landAdvert = new landAdvert();

        }
        return _landAdvert;
    }

    protected Estate _estate;
    
    public void setEstate(Estate estate){
        this._estate = estate;
    }

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
            } else if (tempCustomer.getPreference2() != null) {
                if (tempCustomer.getPreference2().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference2().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference2().getPrice() - 50000 <= estate.getPrice()
                        || estate.getPrice() <= tempCustomer.getPreference2().getPrice() + 50000)
                        && (Objects.equals(tempCustomer.getPreference2().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference2().getForRent(), estate.getForRent()))) {
                    Notify(estate);
                }
            } else if (tempCustomer.getPreference3() != null) {
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
