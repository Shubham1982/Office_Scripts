import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;
        import java.util.HashSet;

public class TestFile1 {
    public static void main(String[] args) {
        String csvFilePath = "/home/shubhamgore/Downloads/MisMatched.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header line
            br.readLine();

            Map<String, Set<String>> plantPincodeRange = new HashMap<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String plant = data[2];
                String pinCodeFrom = data[0];
                String pinCodeTo = data[1];

                String rangeKey = pinCodeFrom + "-" + pinCodeTo;

                plantPincodeRange.computeIfAbsent(plant, k -> new HashSet<>()).add(rangeKey);
            }

            // Generate SQL queries
            for (String plant : plantPincodeRange.keySet()) {
                Set<String> pinCodeRanges = plantPincodeRange.get(plant);
                for (String range : pinCodeRanges) {
                    String[] rangeParts = range.split("-");
                    String pinCodeFrom = rangeParts[0];
                    String pinCodeTo = rangeParts[1];

                    StringBuilder query = new StringBuilder("UPDATE pin_code_fa_mapping SET is_active = false, ");
                    query.append("last_modified_by = 'backend_s', last_modified_date = now() ");
                    query.append("WHERE plant = '").append(plant).append("' AND is_active = true ");
                    query.append("AND pin_code_from = ").append(pinCodeFrom).append(" AND pin_code_to = ").append(pinCodeTo).append(";");

                    // Print generated query
                    System.out.println(query.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
