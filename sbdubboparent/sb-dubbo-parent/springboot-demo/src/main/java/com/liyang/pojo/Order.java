package com.liyang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String oid;
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return oid+","+name+","+address;
    }
}

