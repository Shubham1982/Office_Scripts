import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UpdateDeliveryScheduleRemarkDescription {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/RCA Sheet.xlsx - Overall RCA.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String order_id = data[0];
                String remark = data[1];
                String description = data[2];

                String query1 = generateQuery(order_id, remark, description);

                System.out.println(query1);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total rows processed: " + count);
    }

    public static String generateQuery(String order_id, String remark, String description) {
        return "UPDATE delivery_schedules SET remarks = '"+ remark +"', description = '"+ description + "', last_modified_date = NOW(), last_modified_by = 'backend_s' " +
                "WHERE retailer_sales_order_id = " +  order_id + ";";
    }
//    update delivery_schedules set remarks =  '', description = '', last_modified_by = 'backend_s', last_modified_date = now() where retailer_sales_order_id = ;
}
