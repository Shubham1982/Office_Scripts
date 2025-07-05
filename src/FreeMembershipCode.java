import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FreeMembershipCode {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/Free prime plan_20th May - Sheet1.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String membership_id = data[0];
                String actor_id = data[1];
                String actor_type = data[2];
                String purchase_date = data[3];
                String start_date = data[4];
                String end_date = data[5];
                String base_price = data[6];
                String gst = data[7];
                String net_price = data[8];
                String discount = data[9];
                String price_unit = data[10];
                String currency = data[11];
                String master_order_id = data[12];
                String master_app_order_id = data[13];
                String purchase_status = data[14];
                String created_by = data[15];
                String created_date = data[16];
                String last_modified_by = data[17];
                String last_modified_date = data[18];
                String convenience_fee = data[19];
                String gst_convenience_fee = data[20];
                String days_to_expiry = data[21];


                String query = generateQuery(membership_id,actor_id,actor_type,purchase_date,start_date,end_date,base_price,gst,net_price,discount,price_unit,currency,master_order_id,master_app_order_id,purchase_status,created_by,created_date,last_modified_by,last_modified_date,convenience_fee,gst_convenience_fee,days_to_expiry);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String membership_id,String actor_id,String actor_type,String purchase_date,String start_date,String end_date,String base_price,String gst,String net_price,String discount,String price_unit,String currency,String master_order_id,String master_app_order_id,String purchase_status,String created_by,String created_date,String last_modified_by,String last_modified_date,String convenience_fee,String gst_convenience_fee,String days_to_expiry) {

        return "(" + membership_id + ", " + actor_id + ", " + actor_type + ", '" + purchase_date + "', '" +
                start_date + "', '" + end_date + "', " + base_price + ", " + gst + ", " + net_price + ", " +
                discount + ", " + price_unit + ", " + currency + ", " + master_order_id + ", " +
                master_app_order_id + ", " + purchase_status + ", '" + created_by + "', " +
                created_date + ", '" + last_modified_by + "', " + last_modified_date + ", " +
                convenience_fee + ", " + gst_convenience_fee + ", " + days_to_expiry + "),";
//        return "UPDATE product_inventory SET minimum_order_qty = "+ final_moq +", last_modified_date = now(), last_modified_by = 'backend_s' WHERE product_code = '" + matnr + "' AND depot_code = '" + werks + "' AND enterprise_id = " + enterprise_id + ";";
    }
}
