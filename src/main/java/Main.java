import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger("Main");
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        new Thread( () -> {
            try {
                while(true) {
                    logger.info("Welcome, Enter any Character to add new Deal");
                    bufferedReader.readLine();// start read deal details
                    Deal newDeal = getDealDetails();
                    new DBConnection().addDeal(newDeal);
                }

            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }).start();
        System.out.println();

    }

    private static Deal getDealDetails()  {
        try {
            logger.info("Please, Enter sender country");
            String fromCurrency = bufferedReader.readLine();
            logger.info("Please, Enter receiver country");
            String toCurrency = bufferedReader.readLine();
            logger.info("Please, Enter amount ");
            String amount = bufferedReader.readLine();
            return new Deal(fromCurrency, toCurrency, amount);
        }
        catch (IOException e){
            logger.severe("Error, Customer Added Wrong Deal Data");
            logger.severe(e.getMessage());
            logger.severe(e.toString());
        }
        return null;
    }
}
