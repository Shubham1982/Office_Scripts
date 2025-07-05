import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class MOQWithState {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/MOQ_Update_20_05.xlsx - Sheet1.csv";
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
                String enterprise_id = data[2];
                String final_moq = data[3];
                String query = generateQuery(final_moq, matnr,werks,enterprise_id);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String final_moq, String matnr, String werks, String enterprise_id) {

        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
    }
}
