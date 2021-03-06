    package se311project;

import java.io.Serializable;
import java.time.LocalDate;
// Abstract Product class of the Factory pattern
// For rent and for sale implemented seperately
// Customer may want to rent or sale

abstract class Estate implements Serializable {

    abstract public Location getLocation();

    abstract public void setLocation(Location _location);

    abstract public Boolean getForSale();

    abstract public void setForSale(Boolean _forSale);

    abstract public Boolean getForRent();

    abstract public void setForRent(Boolean _forRent);

    abstract public Long getPrice();

    abstract public void setPrice(Long _price);

    abstract public LocalDate getDate();

    abstract public void setDate(LocalDate _date);

}
