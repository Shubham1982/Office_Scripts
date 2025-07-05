import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFilePath = "/home/shubhamgore/Downloads/Orders.csv";
        String outputFilePath = "/home/shubhamgore/Downloads/Updated_Orders.csv";
        String[] appOrderIds = {"order1", "order2", "order3"}; // Replace with actual app order IDs

        try {
            // Read the CSV file
            List<String[]> data = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    data.add(line.split(","));
                }
            }

            // Get today's date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Calendar calendar = Calendar.getInstance();

            // Calculate tomorrow's date
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            String tomorrowDate = dateFormat.format(calendar.getTime());

            // Reset calendar to today
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            String currentTime = timeFormat.format(calendar.getTime());

            // Update the columns with the required values
            for (int i = 1; i < data.size(); i++) {  // Skip header row
                String appOrderId = data.get(i)[0]; // Assuming 'App Order ID' is the first column
                if (Arrays.asList(appOrderIds).contains(appOrderId)) {
                    data.get(i)[1] = tomorrowDate;  // Assuming 'Delivery Date' is the second column
                    data.get(i)[2] = currentTime;   // Assuming 'Delivery Time' is the third column
                    data.get(i)[3] = "9373651636";  // Assuming 'Delivery Partner Mobile' is the fourth column
                    data.get(i)[4] = "done";        // Assuming 'Remarks' is the fifth column
                    data.get(i)[5] = "done";        // Assuming 'Description' is the sixth column
                }
            }

            // Write the updated data back to the CSV file
            try (PrintWriter pw = new PrintWriter(new FileWriter(outputFilePath))) {
                for (String[] row : data) {
                    pw.println(String.join(",", row));
                }
            }

            System.out.println("CSV file updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
