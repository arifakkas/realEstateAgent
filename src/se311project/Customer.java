package se311project;

import java.io.IOException;
import java.io.Serializable;

// Customer is the object class of the user
// It is also Concrete observer of the observer pattern
public class Customer implements Observer, Serializable {

    private String _name;
    private String _surname;
    private Long _identityNumber;
    // Customer can register 3 preferences at most
    private Estate _preference1;
    private Estate _preference2;
    private Estate _preference3;
    private Estate _advertEstate1;
    private Estate _advertEstate2;
    private Estate _advertEstate3;
    private Advert _advert;
    private houseAdvert _houseAdvert;
    private landAdvert _landAdvert;
    private storeAdvert _storeAdvert;

    // Regular constructor
    public Customer(String name, String surname, Long identityNumber) throws ClassNotFoundException, IOException {
        this._name = name;
        this._surname = surname;
        this._identityNumber = identityNumber;
        this._preference1 = null;
        this._preference2 = null;
        this._preference3 = null;
        this._advertEstate1 = null;
        this._advertEstate2 = null;
        this._advertEstate3 = null;
        this._houseAdvert = houseAdvert.getHouseAdverter();
        this._landAdvert = landAdvert.getLandAdverter();
        this._storeAdvert = storeAdvert.getStoreAdverter();

    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String _surname) {
        this._surname = _surname;
    }

    public Long getIdentityNumber() {
        return _identityNumber;
    }

    public void setIdentityNumber(Long _identityNumber) {
        this._identityNumber = _identityNumber;
    }

    public Estate getPreference1() {
        return this._preference1;
    }

    public Estate getPreference2() {
        return this._preference2;
    }

    public Estate getPreference3() {
        return this._preference3;
    }

    public void setPreference1(Estate _preference1) {
        this._preference1 = _preference1;
    }

    public void setPreference2(Estate _preference2) {
        this._preference2 = _preference2;
    }

    public void setPreference3(Estate _preference3) {
        this._preference3 = _preference3;
    }

    // Update method of the Observer pattern
    public void Update(Advert advert) {
        _advert = advert;

        if (_advert.getClass().equals(_houseAdvert.getClass())) {

            if (this._advertEstate1 == null) {
                this._advertEstate1 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a house which you can buy in " + _advertEstate1.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate1.getPrice());

            } else if (this._advertEstate2 == null) {
                this._advertEstate2 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a house which you can buy in " + _advertEstate2.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate2.getPrice());

            } else if (this._advertEstate3 == null) {
                this._advertEstate3 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a house which you can buy in " + _advertEstate3.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate3.getPrice());

            }
        } else if (_advert.getClass().equals(_landAdvert.getClass())) {
            if (this._advertEstate1 == null) {
                this._advertEstate1 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a land which you can buy in " + _advertEstate1.getLocation().getCountry()
                        + "->" + _advertEstate1.getLocation().getRegion()
                        + "->" + _advertEstate1.getLocation().getCity()
                        + "->" + _advertEstate1.getLocation().getCounty()
                        + "->" + _advertEstate1.getLocation().getNeighborhood()
                );
                System.out.println("With the price of " + _advertEstate1.getPrice() + "$");

            } else if (this._advertEstate2 == null) {
                this._advertEstate2 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a land which you can buy in " + _advertEstate2.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate2.getPrice());

            } else if (this._advertEstate3 == null) {
                this._advertEstate3 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a land which you can buy in " + _advertEstate3.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate3.getPrice());

            }
        } else if (_advert.getClass().equals(_storeAdvert.getClass())) {
            if (this._advertEstate1 == null) {
                this._advertEstate1 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a store which you can buy in " + _advertEstate1.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate1.getPrice());

            } else if (this._advertEstate2 == null) {
                this._advertEstate2 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a store which you can buy in " + _advertEstate2.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate2.getPrice());

            } else if (this._advertEstate3 == null) {
                this._advertEstate3 = _advert.getEstate();
                System.out.println("\n");
                System.out.println("Dear " + this.getName() + " " + this.getSurname());
                System.out.println("There is a store which you can buy in " + _advertEstate3.getLocation().getCountry());
                System.out.println("With the price of " + _advertEstate3.getPrice());

            }

        }

    }
}
