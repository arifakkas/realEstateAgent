package se311project;

import java.io.Serializable;
// To be able to save the locations of the estates
// this class has been created and it holds the location.

public class Location implements Serializable {

    private String _country;
    private String _region;
    private String _city;
    private String _county;
    private String _neighborhood;

    public Location(String country, String region, String city,
            String county, String neighborhood) {
        this._country = country;
        this._region = region;
        this._city = city;
        this._county = county;
        this._neighborhood = neighborhood;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String _country) {
        this._country = _country;
    }

    public String getRegion() {
        return _region;
    }

    public void setRegion(String _region) {
        this._region = _region;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String _city) {
        this._city = _city;
    }

    public String getCounty() {
        return _county;
    }

    public void setCounty(String _county) {
        this._county = _county;
    }

    public String getNeighborhood() {
        return _neighborhood;
    }

    public void setNeighborhood(String _neighborhood) {
        this._neighborhood = _neighborhood;
    }

}
