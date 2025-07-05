import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppOrderIds {
    public static void main(String[] args) {
        String inputFilePath = "/home/lt-444/Downloads/uplecommerce_delivery_schedules.csv";
        String outputFilePath = "/home/lt-444/Downloads/Untitled spreadsheet - Sheet1.csv";

        Set<String> appOrderIdsToRemove = new HashSet<>(Arrays.asList(
                "560565","560656","562201","564388","567865","567974","567975","569527","573181","574718","574721","574726","574770","574875","575131","575617","575618","575706","575708","575797","575799","575800","575806","575951","576019","576715","576717","576720","576722","576723","576742","576743","576746","577016","577017","577859","577917","577926","577927","577944","578042","578045"));

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String header = reader.readLine();
            writer.write(header);
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (!appOrderIdsToRemove.contains(columns[0])) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Filtered CSV file saved as " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
