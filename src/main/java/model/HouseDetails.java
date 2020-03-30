package model;

import java.util.List;

public class HouseDetails {
    Integer noOfRooms;
    Integer sqFtOfHouse;
    Boolean isLawnPresent;
    Boolean isBasementFinished;
    Integer noOfFloor;
    Integer noOfBath;
    Integer garageSize;
    Integer doorNo;
    String street;
    String city;
    String state;
    Integer zipCode;
    Boolean isPatioPresent;
    Boolean isFurnished;
    List<RoomDetails> rooms;
    List<BathDetails> baths;

    public Integer getNoOfRooms(){
        return noOfRooms;
    }
    public void setNoOfRooms(Integer noOfRooms){
        this.noOfRooms = noOfRooms;
    }
    public Integer getSqFtOfHouse(){
        return sqFtOfHouse;
    }
    public void setSqFtOfHouse(Integer sqFtOfHouse){
        this.sqFtOfHouse = sqFtOfHouse;
    }
    public Boolean getLawnPresent(){
        return isLawnPresent;
    }
    public void setLawnPresent(Boolean lawnPresent){
        isLawnPresent =lawnPresent;
    }
    public Boolean getBasementFinished(){
        return isBasementFinished;
    }
    public void setBasementFinished(Boolean basementFinished){
        isBasementFinished = basementFinished;
    }
    public Integer getNoOfFloor(){
        return noOfFloor;
    }
    public void setNoOfFloor(Integer noOfFloor){
        this.noOfFloor = noOfFloor;
    }
    public Integer getNoOfBath(){
        return noOfBath;
    }
    public void setNoOfBath(Integer noOfBath){
        this.noOfBath = noOfBath;
    }
    public Integer getGarageSize(){
        return garageSize;
    }
    public void setGarageSize(Integer garageSize){
        this.garageSize = garageSize;
    }
    public Integer getDoorNo(){
        return doorNo;
    }
    public void setDoorNo(Integer doorNo){
        this.doorNo = doorNo;
    }
    public String getStreet(){
        return street;
    }
    public void setStreet(String Street){
        this.street = street;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getState(){
       return state;
    }
    public void setState(String state){
        this.state = state;
    }
    public Integer getZipCode(){
        return zipCode;
    }
    public void setZipCode(Integer zipCode){
        this.zipCode = zipCode;
    }
    public Boolean getPatioPresent(){
        return isPatioPresent;
    }
    public void setPatioPresent(Boolean patioPresent){
        isPatioPresent = patioPresent;
    }
    public Boolean getFurnished(){
        return isFurnished;
    }
    public void setFurnished(Boolean furnished){
        isFurnished = furnished;
    }
    public List getRooms(){
        return rooms;
    }
    public void setRooms(List rooms){
        this.rooms = rooms;
    }
    public List getBaths(){
        return baths;
    }
    public void setBaths(List<BathDetails> baths){
        this.baths = baths;
    }
}
