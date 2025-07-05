//Product-Service Catalog table
package CatalogUpdate;

//Product service - catelog
import DeliveryScheduleUpdate.ForFM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CatalogTableUpdate {
    public static void main(String[] args) {
        String catagory_code_csv  = "/home/lt-444/Downloads/Old D/MasterCatalogUpdate/uplecommerce_product_category.csv";

        String csvFile = "/home/lt-444/Downloads/Old D/MasterCatalogUpdate/Testing file csv - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            Map<String, Integer> product_validation = new HashMap<>();
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            //getting catagory code
            ForFM file = new ForFM();
            product_validation  = file.getMapFromCSV(catagory_code_csv,1,0);

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

                Integer category_id = product_validation.get(category_code);
                if( category_id == null){
                    throw new Exception("category id should not null");
                }

                String query = generateQuery(id,hsn_code,product_name,measurement_unit,central_tax,state_tax,integrated_tax,category_id,parent_brand_name,
                        sub_brand,material_group_code);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }

    public static String generateQuery(String id, String hsn_code, String product_name, String measurement_unit, String central_tax, String state_tax, String integrated_tax,
                                       int category_id, String parent_brand_name, String sub_brand, String material_group_code) {

        return "update catalog set hsn_code = '"+hsn_code+"', product_name = '"+product_name+"', category_id = "+category_id+", measurement_unit = '"+measurement_unit+"', material_group_code = '"+material_group_code+"', integrated_tax = "+integrated_tax+", central_tax = "+central_tax+", state_tax = "+state_tax+",parent_brand_id = (select id from parent_brand where brand_name = '"+parent_brand_name+"' limit 1), parent_brand_name = '"+parent_brand_name+"', sub_brand = '"+sub_brand+"', modified_by = 'backend_s', modified_date= now() where id = "+id+";";
    }
}
