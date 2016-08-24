package me.mushen.athena.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-23
 */
public class Bakeshop {
    @JsonProperty("name")
    private String shopName;
    @JsonProperty("address")
    private String address;

    private List<Bread> breads;

    @JsonCreator
    public Bakeshop(@JsonProperty("name") String shopName,
                    @JsonProperty("address") String address) {
        this.shopName = shopName;
        this.address = address;
        this.breads = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Bakeshop{" +
                "shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                ", breads=" + breads +
                '}';
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Bread> getBreads() {
        return breads;
    }

    public void setBreads(List<Bread> breads) {
        this.breads = breads;
    }

    public void addBread(Bread bread){
        breads.add(bread);
    }
}
