import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestFile {

    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/uplecommerce_partner_delivery_details.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String id = data[1];
                String partner_mobile = data[3];
                String partner_id = data[9];
                String lr_number = data[5];
                String transport_type = data[7];

                String query1 = generateQuery(id,partner_mobile,partner_id,lr_number,transport_type);

                System.out.println(query1);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total rows processed: " + count);
    }

    public static String generateQuery(String id, String partner_mobile, String partner_id, String lr_number, String transport_type) {
        return "UPDATE delivery_schedules SET lr_number = '"+ lr_number +"', partner_mobile = '"+partner_mobile+"', delivery_partners_id = "+partner_id+", transporter_type = '"+transport_type+"', last_modified_date = NOW(), last_modified_by = 'backend_s' " +
                "WHERE id = " +  id + ";";
    }
//    update delivery_schedules set lr_number =  '', description = '', last_modified_by = 'backend_s', last_modified_date = now() where retailer_sales_order_id = ;
}
