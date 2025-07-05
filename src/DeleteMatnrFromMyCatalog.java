import java.io.BufferedReader;
import java.io.FileReader;

public class DeleteMatnrFromMyCatalog {

    public static void main(String[] args) {
        String line = "";
        try {
            int i = 0;
            String path = "/home/lt-444/Downloads/Products_commission_mismatch (9).xlsx - Sheet1.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedReader br1 = new BufferedReader(new FileReader(path));
            BufferedReader br2 = new BufferedReader(new FileReader(path));
            BufferedReader br3 = new BufferedReader(new FileReader(path));
            BufferedReader br4 = new BufferedReader(new FileReader(path));
            br.readLine();
            br1.readLine();
            br2.readLine();
            br3.readLine();
            br4.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product set status = 0, last_modified_date = now(), last_modified_by = 'backend_s' where matnr = '" + data[0]  +"' and enterprise_id = "+ data[2] +";");

            }

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product_price set is_active = 0, last_modified_date = now(), last_modified_by = 'backend_s' where matnr = '" + data[0] + "' and werks = '" + data[1] +"' and enterprise_id = "+ data[2] +" and is_active = true;");

            }

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product_commission set is_deleted = 1, last_modified_date = now(), last_modified_by = 'backend_s' where matnr = '" + data[0] + "' and plant = '" + data[1] +"' and enterprise_id = "+ data[2] +" and is_deleted is false;");

            }

            while ((line = br3.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product_inventory set status = 0, closing_qty = 0, last_modified_date = now(), last_modified_by = 'backend_s' where product_code = '" + data[0] + "' and depot_code = '" + data[1] +"' and enterprise_id = "+ data[2] +" and status is true;");

            }
            while ((line = br4.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product set status = 0, last_modified_date = now(), last_modified_by = 'backend_s' where product_code = '" + data[0]  +"' and enterprise_id = "+ data[2] +";");
            }
        } catch (Exception e) {

        }
    }
}