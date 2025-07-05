//Product-Service product table
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MasterCatelogUpdate1 {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/Final sheet.xlsx - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String id = data[0];
                String hsn_code = data[1];
                String product_name = data[2];
                String unit_measurement = data[3];
                String Unit_weight = data[4];
                String parent_brand_name = data[5];
                String sub_brand = data[6];
                String query = generateQuery(id,hsn_code,product_name,unit_measurement,Unit_weight,parent_brand_name,sub_brand);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String id, String hsn_code, String product_name, String unit_measurement, String Unit_weight,String parent_brand_name, String sub_brand) {

        return "update product set hsn_code = '"+hsn_code+"', product_name = '"+product_name+"', measurement_unit = '"+unit_measurement+"', unit_weight = "+Unit_weight+", carton_size = unit_weight * units_count, parent_brand_id= (select id from parent_brand where brand_name = '"+parent_brand_name+"' limit 1), parent_brand_name = '"+parent_brand_name+"', product_brand_name = '"+sub_brand+"',last_modified_by = 'backend_s', last_modified_date = now() where catalog_id ="+id+";";
    }
}
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
