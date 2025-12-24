import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FreeMembershipCode {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/Free Prime For a Month - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String retailerIDs = data[0];

                String query = generateQuery(retailerIDs);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String retailerIDs) {

        return "(1,"+retailerIDs+", 0, '2025-08-18 17:30:00', '2025-08-18 17:30:00', '2025-09-17 17:30:00', 0, 0, 0, 0, 0, 0, NULL, NULL, 0, 'Free prime', Now(), 'backend_s', Now(), 0, 0, 7),";
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
    }
}
