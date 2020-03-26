import model.BathDetails;
import model.HouseDetails;
import model.RoomDetails;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import service.SellPropertyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Listing {
    static Logger logger = Logger.getLogger(Listing.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        processListing();
    }

    private static void processListing(){
        Integer chooseOption;
        System.out.print("choose one of the option given below:" + "\n" + "1.Buy" + "\n" + "2.Sell" +"\n");
        System.out.print("Enter your option:");
        Scanner scanner = new Scanner(System.in);
        chooseOption = scanner.nextInt();
        HouseDetails houseDetails = new HouseDetails();
        if(chooseOption == 1){
            SellPropertyService sellPropertyService = new SellPropertyService();
            sellPropertyService.getHouseDetailsFromUser(scanner, houseDetails);
        }else {
            System.out.print("This feature is under construction. Please come back soon.");
        }
    }

}
