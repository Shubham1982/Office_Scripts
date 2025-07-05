import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class RetailerLineOrderItem {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/Blocked_qty - Sheet1.csv";
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

        return "select (target_quantity * pack) as mul,matnr,werks from retailer_sales_order_line_item  where werks = '"+ werks +"' and matnr = '"+ matnr + "' and order_line_item_status in ('Pending','Paid','Placed') and prebooking_status != 'PREBOOK';";
    }
}
