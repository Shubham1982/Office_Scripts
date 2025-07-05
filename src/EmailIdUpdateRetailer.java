import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmailIdUpdateRetailer {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/Email Update sheet aug 26 - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String retailer_id = data[1];
                String email_id = data[0];

                String query = generateQuery(retailer_id,email_id);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String retailer_id, String email_id) {

        return "UPDATE app_user au JOIN retailer r ON au.id = r.app_user_id SET au.email = '"+ email_id +"', au.last_modified_date = now(), au.last_modified_by = 'backend_s' WHERE r.id = "+ retailer_id + ";";

        //UPDATE app_user au
        //JOIN retailer r ON au.id = r.app_user_id
        //SET au.email = 'new_email@example.com'
        //WHERE r.id = 'retailer_id_value';
    }
}
