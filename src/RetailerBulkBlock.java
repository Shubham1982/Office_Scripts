import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RetailerBulkBlock {

    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/Point block retailer Nov 17 - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String retailerID = data[0];

                String query1 = generateQuery(retailerID);
                System.out.println(query1);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total rows processed: " + count);
    }

    public static String generateQuery(String retailerID){
        return "("+ retailerID +", 1,'As per Mona request',true,now(),'backend_s',now(),'backend_s','Mona Bohra'),";
    }
//    update delivery_schedules set lr_number =  '', description = '', last_modified_by = 'backend_s', last_modified_date = now() where retailer_sales_order_id = ;
}
