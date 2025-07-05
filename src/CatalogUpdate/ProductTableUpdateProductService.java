//Product-Service product table
package CatalogUpdate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductTableUpdateProductService {
    public static void main(String[] args) {
        String csvFile = "/home/lt-444/Downloads/Old D/MasterCatalogUpdate/Testing file csv - Sheet1.csv";
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
                String measurement_unit = data[3];
                String central_tax = data[4];
                String state_tax = data[5];
                String integrated_tax = data[6];
                String category_code = data[7];
                String parent_brand_name = data[8];
                String sub_brand = data[9];
                String material_group_code = data[10];

                String query = generateQuery(id,hsn_code,product_name,measurement_unit,central_tax,state_tax,integrated_tax,category_code,parent_brand_name,
                        sub_brand,material_group_code);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String id, String hsn_code, String product_name, String measurement_unit, String central_tax, String state_tax,
                                       String integrated_tax, String category_code, String parent_brand_name, String sub_brand, String material_group_code) {

        return "update product set hsn_code = '"+hsn_code+"', product_name = '"+product_name+"', measurement_unit = '"+measurement_unit+"', central_tax = "+central_tax+", state_tax= "+state_tax+
                ", integrated_tax = "+integrated_tax+", category_code = '"+ category_code+"', category_name= '"+material_group_code+"', parent_brand_id= (select id from parent_brand where brand_name = '"+parent_brand_name+ "' limit 1), parent_brand_name = '"+parent_brand_name+"', product_brand_name = '"+sub_brand+"',last_modified_by = 'backend_s', last_modified_date = now() where catalog_id ="+id+";";
    }
}


