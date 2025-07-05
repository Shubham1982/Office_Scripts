import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class BlockedQty {
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
                String blocked_qty = data[2];
                String query = generateQuery(werks, matnr,blocked_qty);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String werks, String matnr,String blocked_qty) {

        return "UPDATE product_inventory SET blocked_qty = "+ blocked_qty +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND status is true;";
    }
}
