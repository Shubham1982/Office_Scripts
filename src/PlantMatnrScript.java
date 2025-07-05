import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class PlantMatnrScript {
    public static void main(String[] args) {
        String csvFilePath = "/home/lt-444/Downloads/Product_level_Moq - Product_level_Moq.csv";  // Your CSV file path

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the first line (header)
            br.readLine();

            // Map to hold plant codes and associated material numbers
            Map<String, Set<String>> plantMatnrMap = new HashMap<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Check if the line contains at least two columns
                if (data.length < 2) {
                    continue;  // Skip lines with insufficient data
                }

                String plantCode = data[0].trim();  // First column: Plant code
                String matnr = data[1].trim();      // Second column: Material number (matnr)

                // Add matnr to the plantCode key in the map
                plantMatnrMap.computeIfAbsent(plantCode, k -> new HashSet<>()).add(matnr);
            }

            // Generate SQL queries
            for (String plantCode : plantMatnrMap.keySet()) {
                Set<String> matnrSet = plantMatnrMap.get(plantCode);
                StringBuilder query = new StringBuilder("UPDATE product_inventory SET minimum_order_qty = 1, ");
                query.append("last_modified_by = 'backend_s', last_modified_date = now() ");
                query.append("WHERE depot_code = '").append(plantCode).append("' AND is_active = true ");
                query.append("AND product_code IN (");

                // Append material numbers
                for (String matnr : matnrSet) {
                    query.append("'").append(matnr).append("',");
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
