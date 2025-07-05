import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class PincodePlantDeactivation {
    public static void main(String[] args) {
        String excelFilePath = "/home/lt-444/Downloads/Pincodes deactivation_KA_Kalburgi&Bellary.xlsx - Sheet1.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(excelFilePath))) {
            // Skip the first line (header)
            br.readLine();

            Map<String, Set<Integer>> plantPinCodes = new HashMap<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int pinCode = Integer.parseInt(data[0]);
                String plant = data[1];

                plantPinCodes.computeIfAbsent(plant, k -> new HashSet<>()).add(pinCode);
            }

            // Generate SQL queries
            for (String plant : plantPinCodes.keySet()) {
                Set<Integer> pinCodesSet = plantPinCodes.get(plant);
                StringBuilder query = new StringBuilder("UPDATE pin_code_fa_mapping SET is_active = false, ");
                query.append("last_modified_by = 'backend_s', last_modified_date = now() ");
                query.append("WHERE plant = '").append(plant).append("' AND is_active = true ");
                query.append("AND pin_code_from IN (");

                // Append pin codes
                for (int pinCode : pinCodesSet) {
                    query.append(pinCode).append(",");
                }
                // Remove trailing comma and close parenthesis
                query.deleteCharAt(query.length() - 1);
                query.append(");");

                // Print generated query
                System.out.println(query.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
