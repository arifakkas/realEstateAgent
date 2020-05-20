package se311project;

import java.time.LocalDate;

class HouseCreator extends EstateCreator {
    private static Location _location;
    private static Boolean _forSale;
    private static Boolean _forRent;
    private static Long _price;
    private static LocalDate _date;

    public HouseCreator(Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) {
        this._location = location;
        this._forSale = forSale;
        this._forRent = forRent;
        this._price = price;
        this._date = date;

    }

    public static House createHouse(Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) {
        return new House(_location, _forSale, _forRent, _price, _date);
    }

}

class LandCreator extends EstateCreator {
    
    private static Location _location;
    private static Boolean _forSale;
    private static Boolean _forRent;
    private static Long _price;
    private static LocalDate _date;

    public LandCreator(Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) {
        this._location = location;
        this._forSale = forSale;
        this._forRent = forRent;
        this._price = price;
        this._date = date;

    }

    public static Land createLand(int estateType, Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) {
        return new Land(_location, _forSale, _forRent, _price, _date);
    }
}

class StoreCreator extends EstateCreator {
    
    private static Location _location;
    private static Boolean _forSale;
    private static Boolean _forRent;
    private static Long _price;
    private static LocalDate _date;

    public StoreCreator(Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) {
        this._location = location;
        this._forSale = forSale;
        this._forRent = forRent;
        this._price = price;
        this._date = date;

    }

    public static Store createStore(Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) {
        return new Store(_location, _forSale, _forRent, _price, _date);
    }
}

public  abstract class EstateCreator {

    static Estate tempEstate=null;

    public static Estate createEstate(int estateType, Location location,
            Boolean forSale, Boolean forRent, Long price, LocalDate date) {
        if (estateType == 0) {
            HouseCreator houseCreator = new HouseCreator(location, forSale, forRent, price, date);
            tempEstate = houseCreator.createHouse(location, forSale, forRent, price, date);
            return tempEstate;
        } else if (estateType == 1) {
            LandCreator landCreator = new LandCreator(location, forSale, forRent, price, date);
            tempEstate = landCreator.createLand(estateType, location, forSale, forRent, price, date);
            return tempEstate;
        } else if (estateType == 2) {
            StoreCreator storeCreator = new StoreCreator(location, forSale, forRent, price, date);
            tempEstate = storeCreator.createStore( location, forSale, forRent, price, date);
            return tempEstate;
        }
        return null;
    }
}
