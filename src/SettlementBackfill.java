import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SettlementBackfill {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Output Files/OutputFile.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String transfer_id = data[0];
                String settlement_id = data[1];

                String query1 = generateQuery(transfer_id, settlement_id);

                System.out.println(query1);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total rows processed: " + count);
    }

    public static String generateQuery(String transfer_id, String settlement_id) {
        return "UPDATE payment_transfers_info SET settlement_id = '"+ settlement_id + "', last_modified_date = NOW(), last_modified_by = 'backend_s' " +
                "WHERE transfer_id = '" +  transfer_id + "';";
    }
//    update delivery_schedules set remarks =  '', description = '', last_modified_by = 'backend_s', last_modified_date = now() where retailer_sales_order_id = ;
}

