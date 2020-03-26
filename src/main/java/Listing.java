import Properties.BathDetails;
import Properties.HouseDetails;
import Properties.RoomDetails;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Listing {
    static Logger logger = Logger.getLogger(Listing.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Integer chooseOption;
        System.out.print("choose one of the option given below:" + "\n" + "1.Buy" + "\n" + "2.Sell" +"\n");
        System.out.print("Enter your option:");
        Scanner s = new Scanner(System.in);
        chooseOption = s.nextInt();
        HouseDetails houseDetails = new HouseDetails();
        if(chooseOption == 1){
            getHouseDetailsFromUser(s, houseDetails);
        }else {
            System.out.print("This feature is under construction. Please come back soon.");
        }
    }
    public static void getHouseDetailsFromUser(Scanner s, HouseDetails houseDetails){
        System.out.print("Enter no of rooms:");
        houseDetails.setNoOfRooms(s.nextInt());
        System.out.print("Enter the square feet of the house:");
        houseDetails.setSqFtOfHouse(s.nextInt());
        System.out.print("Is lawn present:");
        houseDetails.setLawnPresent(s.nextBoolean());
        System.out.print("Is basement finished(Say True or False):");
        houseDetails.setBasementFinished(s.nextBoolean());
        System.out.print("Enter the no of floors in the house:");
        houseDetails.setNoOfFloor(s.nextInt());
        System.out.print("Enter the garage size in terms of car:");
        houseDetails.setGarageSize(s.nextInt());
        System.out.print("Enter no of baths:");
        houseDetails.setNoOfBath(s.nextInt());
        System.out.print("Enter the door no:");
        houseDetails.setDoorNo(s.nextInt());
        s.nextLine();
        System.out.print("Enter the street name:");
        houseDetails.setStreet(s.nextLine());
        System.out.print("Enter the city name:");
        houseDetails.setCity(s.nextLine());
        System.out.print("Enter the state name:");
        houseDetails.setState(s.nextLine());
        System.out.print("Enter the zip code:");
        houseDetails.setZipCode(s.nextInt());
        System.out.print("Is patio present:");
        houseDetails.setPatioPresent(s.nextBoolean());
        System.out.print("Is house fully furnished:");
        houseDetails.setFurnished(s.nextBoolean());
        getRoomDetailsFromUser(s, houseDetails);
        getBathDetailsFromUser(s, houseDetails);
    }

    public static void getRoomDetailsFromUser(Scanner s, HouseDetails houseDetails){
       List<RoomDetails> rooms =  new ArrayList<>();
        for(int i = 0; i < houseDetails.getNoOfRooms(); i++){
            RoomDetails roomDetails = new RoomDetails();
            s.nextLine();
            System.out.print("Enter the room type of room" + (i+1) + ":");
            roomDetails.setRoomType(s.nextLine());
            System.out.print("Enter the square feet of room" + (i+1) + ":");
            roomDetails.setRoomSqFt(s.nextInt());
            s.nextLine();
            System.out.print("Enter the floor type of room" + (i+1) + ":");
            roomDetails.setFloorType(s.nextLine());
            System.out.print("Enter the floor no of room" + (i+1) + ":");
            roomDetails.setFloorNoWhereRoomLocated(s.nextInt());
            s.nextLine();
            rooms.add(roomDetails);
        }
        houseDetails.setRooms(rooms);
    }

    public static void getBathDetailsFromUser(Scanner s, HouseDetails houseDetails){
        List<BathDetails> baths = new ArrayList<>();
        for(int i = 0; i < houseDetails.getNoOfBath(); i++){
            BathDetails bathDetails = new BathDetails();
            System.out.print("Enter the type of bath for bath" + (i+1) + ":");
            bathDetails.setBathType(s.nextLine());
            System.out.print("Enter the size of bath for bath" + (i+1) + ":");
            bathDetails.setBathSize(s.nextLine());
            baths.add(bathDetails);
        }
        houseDetails.setBaths(baths);
    }
}
