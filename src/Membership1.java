import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Membership1 {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/Prime Exclusion __ 18th June __ Hardy - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String plant_code = data[0];
                String product_id = data[1];
                String matnr = data[2];
//            String product_name = data[0];
//            String product_id = data[1];
//            String matnr = data[2];
//            String plant_code = data[3];
                String query = generateQuery(product_id, plant_code);
                System.out.println(query);
                count++;

            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
        System.out.println("Total queries :"+ count*3);
    }

    public static String generateQuery(String product_id, String plant_code) {

        return "(1,3,'{\"productId\":" + product_id + ",\"werks\":\"" + plant_code + "\"}',3,true,now(),'backend_s',now()),\n" +
                "(2,3,'{\"productId\":" + product_id + ",\"werks\":\"" + plant_code + "\"}',3,true,now(),'backend_s',now()),\n" +
                "(3,3,'{\"productId\":" + product_id + ",\"werks\":\"" + plant_code + "\"}',3,true,now(),'backend_s',now()),";
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
    }
}
