package ChangeProductNameScript;

//Product-Service product table

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Product {
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
                String product_name = data[1];

                String query = generateQuery(id,product_name);
                System.out.println(query);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public static String generateQuery(String id, String product_name) {

        return "update product set  product_name = '"+product_name+"',last_modified_by = 'backend_s', last_modified_date = now() where catalog_id ="+id+";";
    }
}


