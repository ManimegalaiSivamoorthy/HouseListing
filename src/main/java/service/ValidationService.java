package service;

import model.HouseDetails;
import model.RoomDetails;

import java.util.ArrayList;
import java.util.List;

public class ValidationService {
    public void validateHouseDetails(HouseDetails houseDetails){
        List <String> errorMessages = new ArrayList<>();
        if(houseDetails.getNoOfRooms() <= 0){
            //System.out.print("The room count cannot be zero");
            errorMessages.add("Room count cannot be zero");
        }
        if(houseDetails.getSqFtOfHouse() <= 0){
            errorMessages.add("Square feet of house cannot be zero");
        }
        if(houseDetails.getNoOfFloor() <= 0){
            errorMessages.add("Floor no ccannot be zero");
        }
        if(houseDetails.getNoOfBath() <= 0){
            errorMessages.add("No of bath must be greater than zero");
        }
        if(houseDetails.getGarageSize() < 0){
            errorMessages.add("size of garage cannot be negative");
        }
        if(!(houseDetails.getZipCode() >= 10000 && houseDetails.getZipCode() <= 99999)){
            errorMessages.add("zipcode should be a five digit number");
        }
        if(houseDetails.getRooms().size() > 0){
            for(int i = 0; i < houseDetails.getRooms().size(); i++){
                String roomType = houseDetails.getRooms().get(i).getRoomType();
               if(!(roomType.equalsIgnoreCase("Master Bedroom") ||  roomType.equalsIgnoreCase
                       ("Living Room") || roomType.equalsIgnoreCase("Family Room"))){
                   errorMessages.add("Entered room type for room " + (i+1) + " is incorrect");
                }
               String floortype = houseDetails.getRooms().get(i).getFloorType();
               if(!(floortype.equalsIgnoreCase("carpet") || floortype.equalsIgnoreCase("hard floor"))){
                   errorMessages.add("Entered floor type for room " + (i+1) + " is incorrect");
                }
               Integer sqftofRoom = houseDetails.getRooms().get(i).getRoomSqFt();
               if(sqftofRoom <= 0){
                   errorMessages.add("Square feet of room " + (i+1) + "cannot be zero");
               }
               Integer floorWhereRoomLocated = houseDetails.getRooms().get(i).getFloorNoWhereRoomLocated();
               if(floorWhereRoomLocated <= 0){
                   errorMessages.add("Room location is incorrect");
               }
            }
        }
        if(houseDetails.getBaths().size() > 0){
            for(int i = 0; i < houseDetails.getBaths().size(); i++){
                String bathType = houseDetails.getBaths().get(i).getBathType();
                if(!(bathType.equalsIgnoreCase("Bath tub") || bathType.equalsIgnoreCase("walk in bath tub "))){
                    errorMessages.add("Entered bath type " + (i+1) + "is incorrect");
                }
                String bathsize = houseDetails.getBaths().get(i).getBathSize();
                if(!(bathsize.equalsIgnoreCase("full") || bathsize.equalsIgnoreCase("half") ||
                        bathsize.equalsIgnoreCase("three quater bath"))){
                            errorMessages.add("Entered bath size" + (i+1) + "is incorrect");
                }
            }
        }
        System.out.print(errorMessages);
    }
}
