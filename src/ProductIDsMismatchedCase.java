import java.io.BufferedReader;
import java.io.FileReader;

public class ProductIDsMismatchedCase {

    public static void main(String[] args) {
        String line = "";
        String path = "/home/lt-444/Downloads/ProductIDsMismatchedCase_onlyProductIDs.csv";
        try {
            int i = 0;
            BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedReader br1 = new BufferedReader(new FileReader(path));
            BufferedReader br2 = new BufferedReader(new FileReader(path));

            br.readLine();
            br1.readLine();
            br2.readLine();
            System.out.println("product table Queries: ");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product set id = "+data[1]+", last_modified_date = now(), last_modified_by = 'backend_s' where id = " + data[0]  +";");

            }
            System.out.println("product_photo table Queries: ");

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product_photo set product_id = "+data[1]+" where product_id = " + data[0] + ";");

            }
            System.out.println("product_info table Queries: ");

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("update product_info set product_id = "+data[1]+", modified_date = now(), modified_by = 'backend_s' where product_id = "+data[0]+";");

            }


        } catch (Exception e) {

        }
    }
}
