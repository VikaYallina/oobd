package domain;

import annotation.Column;
import annotation.Entity;

@Entity
public class Person {
    @Column
    private String name;
    @Column
    private String address;

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    public Person(){}

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
}
