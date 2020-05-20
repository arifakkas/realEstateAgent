package se311project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

abstract class Advert implements Serializable{
    
    protected ArrayList<Customer> _waitingCustomers = new ArrayList<Customer>();
    protected Estate _estate;
    
    public ArrayList<Customer> getWaitingCustomers() {
        return this._waitingCustomers;
    }
    
    public void setWaitingUsers() throws ClassNotFoundException, IOException{
        _waitingCustomers = fileOperationsHelper.readWaitingUsers();
    }
    
    public void Attach(Customer customer) throws IOException {
        _waitingCustomers.add(customer);
        fileOperationsHelper.saveWaitingUserstoFile(_waitingCustomers);
    }
    
    public Estate getEstate() {
        return this._estate;
    }
    
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
                
            } else if (tempCustomer.getPreference2() != null) {
                if (tempCustomer.getPreference2().getLocation().getCountry().equals(estate.getLocation().getCountry())
                        && tempCustomer.getPreference2().getLocation().getNeighborhood().equals(estate.getLocation().getNeighborhood())
                        && (tempCustomer.getPreference2().getPrice() - 50000 <= estate.getPrice()
                        || estate.getPrice() <= tempCustomer.getPreference2().getPrice() + 50000)
                        && (Objects.equals(tempCustomer.getPreference2().getForSale(), estate.getForSale())
                        || Objects.equals(tempCustomer.getPreference2().getForRent(), estate.getForRent()))) {
                    this._estate = estate;
                    tempCustomer.Update(this);
                }
            } else if (tempCustomer.getPreference3() != null) {
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
