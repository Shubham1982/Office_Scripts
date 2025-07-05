import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BulkMOV {




    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/Depot MOQs.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String plant_code = data[1];
                String mov = data[3];
                String query = generateQuery(plant_code,mov);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String plant_code, String mov) {

        return "UPDATE plant SET minimum_order_value = "+ mov +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE plant_code    = '" + plant_code + "';";
    }
}
