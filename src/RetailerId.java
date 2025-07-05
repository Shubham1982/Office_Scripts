import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RetailerId {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/RetailerSheet.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String retailerId = data[0];
                String query = generateQuery(retailerId);
                System.out.println(query);
                count++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String retailerId) {
        return "("+retailerId+",2,'Rupifi Overdue',true,now(),'backend_s',now(),'backend_s','Ridhima Puri'),";
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
    }
}
