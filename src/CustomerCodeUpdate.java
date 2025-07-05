import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerCodeUpdate {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/customer_code - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String retailer = data[0];
                String customer_code = data[1];

                String query1 = generateQuery(retailer, customer_code);

                System.out.println(query1);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total rows processed: " + count);
    }

    public static String generateQuery(String retailer, String customer_code) {
        return "update retailer set customer_code = "+ customer_code +", last_modified_date = NOW(), last_modified_by = 'backend_s' " +
                "WHERE id = " +  retailer + ";";
    }
//    update retailer set customer_code = 1112041, last_modified_by = 'backend_s', last_modified_date = now() where id = 2241;
}
