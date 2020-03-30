package service;

import model.BathDetails;
import model.HouseDetails;
import model.RoomDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellPropertyService {
    public void getHouseDetailsFromUser(Scanner scanner, HouseDetails houseDetails){
        System.out.print("Enter no of rooms:");
        houseDetails.setNoOfRooms(scanner.nextInt());
        System.out.print("Enter the square feet of the house:");
        houseDetails.setSqFtOfHouse(scanner.nextInt());
        System.out.print("Is lawn present:");
        houseDetails.setLawnPresent(scanner.nextBoolean());
        System.out.print("Is basement finished(Say True or False):");
        houseDetails.setBasementFinished(scanner.nextBoolean());
        System.out.print("Enter the no of floors in the house:");
        houseDetails.setNoOfFloor(scanner.nextInt());
        System.out.print("Enter the garage size in terms of car:");
        houseDetails.setGarageSize(scanner.nextInt());
        System.out.print("Enter no of baths:");
        houseDetails.setNoOfBath(scanner.nextInt());
        System.out.print("Enter the door no:");
        houseDetails.setDoorNo(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the street name:");
        houseDetails.setStreet(scanner.nextLine());
        System.out.print("Enter the city name:");
        houseDetails.setCity(scanner.nextLine());
        System.out.print("Enter the state name:");
        houseDetails.setState(scanner.nextLine());
        System.out.print("Enter the zip code:");
        houseDetails.setZipCode(scanner.nextInt());
        System.out.print("Is patio present:");
        houseDetails.setPatioPresent(scanner.nextBoolean());
        System.out.print("Is house fully furnished:");
        houseDetails.setFurnished(scanner.nextBoolean());
        getRoomDetailsFromUser(scanner, houseDetails);
        getBathDetailsFromUser(scanner, houseDetails);
    }

    private void getRoomDetailsFromUser(Scanner scanner, HouseDetails houseDetails){
        List<RoomDetails> rooms =  new ArrayList<>();
        for(int i = 0; i < houseDetails.getNoOfRooms(); i++){
            RoomDetails roomDetails = new RoomDetails();
            scanner.nextLine();
            System.out.print("Enter the room type of room" + (i+1) + ":");
            roomDetails.setRoomType(scanner.nextLine());
            System.out.print("Enter the square feet of room" + (i+1) + ":");
            roomDetails.setRoomSqFt(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Enter the floor type of room" + (i+1) + ":");
            roomDetails.setFloorType(scanner.nextLine());
            System.out.print("Enter the floor no of room" + (i+1) + ":");
            roomDetails.setFloorNoWhereRoomLocated(scanner.nextInt());
            rooms.add(roomDetails);
        }
        houseDetails.setRooms(rooms);
    }

    private void getBathDetailsFromUser(Scanner scanner, HouseDetails houseDetails){
        List<BathDetails> baths = new ArrayList<>();
        scanner.nextLine();
        for(int i = 0; i < houseDetails.getNoOfBath(); i++){
            BathDetails bathDetails = new BathDetails();
            System.out.print("Enter the type of bath for bath" + (i+1) + ":");
            bathDetails.setBathType(scanner.nextLine());
            System.out.print("Enter the size of bath for bath" + (i+1) + ":");
            bathDetails.setBathSize(scanner.nextLine());
            baths.add(bathDetails);
        }
        houseDetails.setBaths(baths);
    }
}
