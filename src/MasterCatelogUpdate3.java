//product upl-ecommerce
import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;

public class MasterCatelogUpdate3 {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/product_dump_test.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String catalog_id = data[1];
                String hsn_code = data[26];
                String product_name = data[13];
                String unit_measurement = data[5];
                String Unit_weight = data[15];
                String parent_brand_id = data[28];
                String parent_brand_name = data[29];
                String sub_brand = data[4];
                String query = generateQuery(catalog_id,hsn_code,product_name,unit_measurement,Unit_weight,parent_brand_name,sub_brand, parent_brand_id);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String catalog_id, String hsn_code, String product_name, String unit_measurement, String Unit_weight,String parent_brand_name, String sub_brand, String parent_brand_id) {

        return "update product set hsn_code = '"+hsn_code+"', product_name = '"+product_name+"', meins = '"+unit_measurement+"', unit_weight = "+Unit_weight+", pack = unit_weight * units_count, parent_brand_id = "+parent_brand_id+",parent_brand_name = '"+parent_brand_name+"', zzbrand = '"+sub_brand+"', last_modified_by = 'backend_s', last_modified_date = now() where catalog_id= "+catalog_id+";";
    }
}
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";

