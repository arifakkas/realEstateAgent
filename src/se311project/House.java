package se311project;

import java.time.LocalDate;
// House is a concrete child of the estate

public class House extends Estate {

    private Location _location;
    private Boolean _forSale;
    private Boolean _forRent;
    private Long _price;
    private LocalDate _date;

    public House(Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) {
        this._location = location;
        this._forSale = forSale;
        this._forRent = forRent;
        this._price = price;
        this._date = date;
    }

    @Override
    public Location getLocation() {
        return this._location;
    }

    @Override
    public void setLocation(Location _location) {
        this._location = _location;
    }

    @Override
    public Boolean getForSale() {
        return this._forSale;
    }

    @Override
    public void setForSale(Boolean _forSale) {
        this._forSale = _forSale;
    }

    @Override
    public Boolean getForRent() {
        return this._forRent;
    }

    @Override
    public void setForRent(Boolean _forRent) {
        this._forRent = _forRent;
    }

    @Override
    public Long getPrice() {
        return this._price;
    }

    @Override
    public void setPrice(Long _price) {
        this._price = _price;
    }

    @Override
    public LocalDate getDate() {
        return this._date;
    }

    @Override
    public void setDate(LocalDate _date) {
        this._date = _date;
    }

}
