package service;

import model.BathDetails;
import model.HouseDetails;
import model.RoomDetails;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellPropertyService {
    Logger logger = Logger.getLogger(SellPropertyService.class);
    public void processSellProperty() {
        HouseDetails houseDetails = new HouseDetails();
        getHouseDetailsFromUser(houseDetails);
        String fileName = houseDetails.getDoorNo() + "_" + houseDetails.getStreet() + "_" + houseDetails.getCity() + "_"
                + houseDetails.getState() + ".txt";
        try {
            writeToFile(descriptionOfHouse(houseDetails), fileName );
        } catch (IOException exception) {
            logger.info("Exception Caught while working on file: "+ exception );
        }

    }

    public void writeToFile(String fileContent, String filename) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("houses\\" + filename));
        bufferedWriter.write(fileContent);
        bufferedWriter.close();
    }

    public void getHouseDetailsFromUser(HouseDetails houseDetails){
        Scanner scanner = new Scanner(System.in);
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

    public String descriptionOfHouse(HouseDetails houseDetails){
        String houseDescription;
        String lawnDetails;
        String basementDetails;
        String patioDetails;
        String houseFurnished;
        String finalRoomDescription = "";
        String finalBathDescription = "";

        if(houseDetails.getLawnPresent()){
            lawnDetails = "The house has a nice lawn.";
        }else{
            lawnDetails = "The house does not have a lawn. \n";
        }
        if(houseDetails.getBasementFinished()){
            basementDetails = "The house has finished basement. \n";
        }else{
            basementDetails = "The house does not have finished basement. \n";
        }
        if(houseDetails.getPatioPresent()){
            patioDetails = "The house has nice patio. \n";
        }else{
            patioDetails = "The house does not have patio. \n";
        }
        if(houseDetails.getFurnished()){
            houseFurnished = "The house is fully furnished. \n";
        }else{
            houseFurnished = "The house is not fully furnished. \n";
        }

        if (houseDetails.getRooms().size() > 0) {
            finalRoomDescription = "Room Details: \n";
            List<RoomDetails> rooms = houseDetails.getRooms();
            for (int i = 0; i < rooms.size(); i++) {
                String roomDescription;
                RoomDetails room = rooms.get(i);
                roomDescription = "\tRoom " + (i + 1) + " is " + room.getRoomType() + ", room's floor type is " + room.getFloorType()
                        + ", room is " + room.getRoomSqFt() + " square feet" + ", room is located at " + room.getFloorNoWhereRoomLocated()
                        + " floor." + "\n";
                finalRoomDescription = finalRoomDescription + roomDescription;
            }
        }

        if(houseDetails.getBaths().size() > 0){
            finalBathDescription = "Bath Details: \n";
            List<BathDetails> baths = houseDetails.getBaths();
            for(int i = 0 ; i < baths.size(); i++){
                String bathDescription;
                BathDetails bath = baths.get(i);
                bathDescription = "\tBath " + (i + 1) + " is " + bath.getBathSize() + " and has " + bath.getBathType() + "." + "\n";
                finalBathDescription = finalBathDescription + bathDescription;
            }
        }

        houseDescription = "The house comprises of "+ houseDetails.getNoOfRooms() + " rooms." + "\n" + "The house is " +
                houseDetails.getSqFtOfHouse() + " Square feet." + "\n" + "The house has a " + houseDetails.getGarageSize()
                + " car garage. \n" + "It has " + houseDetails.getNoOfBath() + " baths" + "\n" + "Its a "+ houseDetails.getNoOfFloor()
                + " level house. \n" + lawnDetails + basementDetails + patioDetails + houseFurnished + "Property is located at "
                + houseDetails.getDoorNo() + ", " + houseDetails.getStreet() + ", " + houseDetails.getCity() + ", " +
                houseDetails.getState() + "-" + houseDetails.getZipCode() + ". \n" + finalRoomDescription + finalBathDescription;

        System.out.print(houseDescription);
        return houseDescription;
    }

    public String getInputFromUserToReadExistingProperty(){
        Integer doorNo;
        String streetName;
        String cityName;
        String stateName;
        Integer zipCode;
        System.out.print("Enter the door no the property:");
        Scanner scanner = new Scanner(System.in);
        doorNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Street name where the property is located:");
        streetName = scanner.nextLine();
        System.out.print("Enter the city name where the property is located:");
        cityName = scanner.nextLine();
        System.out.print("Enter the state name where the property is located:");
        stateName = scanner.nextLine();
        System.out.print("Enter the zipcode of the preoperty:");
        zipCode = scanner.nextInt();
        return doorNo + "_" + streetName + "_" + cityName + "_"+ stateName + ".txt";
    }

    public void readAFile(String searchFileName){
        File file = new File("houses\\"+ searchFileName);
        if(file.exists()){
            ReadTheContentOfFile(file);
        }else{

            System.out.print("no such property is available in the listing. Sorry for inconvenience.");
        }
    }

    public void ReadTheContentOfFile(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> houseContent = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                houseContent.add(line);
            }
            System.out.print(houseContent);
        }
        catch (Exception exception){
            System.out.print("Exception caught");
        }

    }
}
