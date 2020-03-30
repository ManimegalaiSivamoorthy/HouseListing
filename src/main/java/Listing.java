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
        System.out.print("choose one of the option given below:" + "\n" + "1.Buy" + "\n" + "2.Sell" +"\n" + "3.View existing property details" + "\n");
        System.out.print("Enter your option:");
        Scanner scanner = new Scanner(System.in);
        chooseOption = scanner.nextInt();
        HouseDetails houseDetails = new HouseDetails();
        SellPropertyService sellPropertyService = new SellPropertyService();
        switch (chooseOption) {
            case 1:
                sellPropertyService.processSellProperty();
                break;
            case 3:
                sellPropertyService.readAFile(sellPropertyService.getInputFromUserToReadExistingProperty());
                break;
            default:
                System.out.print("This feature is under construction. Please come back soon.");
                break;
        }

    }

}
