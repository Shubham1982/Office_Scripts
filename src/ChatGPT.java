import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChatGPT {
    public static void main(String[] args) {
        String csvFile = "/home/shubhamgore/Downloads/Copy of Missing Reg Number - South Details.csv";
        String line;
        String cvsSplitBy = ",";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String enterprise_id = data[1];
                String mobile_no = data[2];

                String query1 = generateQuery(enterprise_id, mobile_no);

                System.out.println(query1);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total rows processed: " + count);
    }

    public static String generateQuery(String enterprise_id, String mobile_no) {
        return "UPDATE enterprise SET reg_number = '"+ mobile_no +"', last_modified_date = NOW(), last_modified_by = 'backend_s' " +
                "WHERE id = " +  enterprise_id + ";";
    }
//    update enterprise set reg_number = '34343', last_modified_by = 'backend_s', last_modified_date = now() where id = 4000;
}
