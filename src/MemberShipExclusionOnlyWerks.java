import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MemberShipExclusionOnlyWerks {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/werks_exclusion_prime_may16  - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));


            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);


                String plant_code = data[0];
                String query = generateQuery(plant_code);
                System.out.println(query);
                count++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String plant_code) {

        return "(1,2,'{\"werks\":\""+plant_code+"\"}',3,true,now(),'backend_s',now()),\n"+
                "(2,2,'{\"werks\":\""+plant_code+"\"}',3,true,now(),'backend_s',now()),\n"+
                "(3,2,'{\"werks\":\""+plant_code+"\"}',3,true,now(),'backend_s',now()),";
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
    }
}
