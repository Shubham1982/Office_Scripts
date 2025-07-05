package ChangeProductNameScript;

//Product-Service Catalog table

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Catalog {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }

    public static String generateQuery(String id, String product_name) {

        return "update catalog set product_name = '"+product_name+"', modified_by = 'backend_s', modified_date= now() where id = "+id+";";
    }
}
