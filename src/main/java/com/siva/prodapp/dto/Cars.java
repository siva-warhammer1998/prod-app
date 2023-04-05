package com.siva.prodapp.dto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "usedcarsdataset")
public class Cars {

    @Id
    private String id;

    @Field("Name of car")
    private String name;

    @Field("Company name")
    private String companyName;

    @Field("Year")
    private String year;

    @Field("Price")
    private String price;

    @Field("Kms driven")
    private String kmsDriven;

    @Field("Fuel_type")
    private String fuelType;

    public Cars() {
    }

    public Cars(String name, String companyName, String year, String price, String kmsDriven, String fuelType) {
        this.name = name;
        this.companyName = companyName;
        this.year = year;
        this.price = price;
        this.kmsDriven = kmsDriven;
        this.fuelType = fuelType;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(String kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // toString() method
    @Override
    public String toString() {
        return "UsedCar{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", kmsDriven='" + kmsDriven + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}

