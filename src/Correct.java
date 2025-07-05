import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Correct {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/MOQ - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String werks = data[0];
                String matnr = data[1];
                String query = generateQuery(werks, matnr);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String werks, String matnr) {

        return "select minimum_order_qty, product_code, depot_code, last_modified_date, last_modified_by from product_inventory WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND status is true;";
    }
}
