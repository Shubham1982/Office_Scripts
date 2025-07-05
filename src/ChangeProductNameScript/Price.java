package ChangeProductNameScript;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Price {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/__select___from_prod_id_in___796_119530_.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String id = data[0];
                String measurement_unit = data[1];

                String query = generateQuery(id,measurement_unit);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String id, String measurement_unit) {

        return "update product_inventory pi join product p on pi.product_code = p.product_code and pi.enterprise_id = p.enterprise_id set  pi.measurement_unit='"+measurement_unit+"', pi.last_modified_by = 'backend_s', pi.last_modified_date = now()\n" +
                "where p.catalog_id = "+id+";";
    }
}
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
