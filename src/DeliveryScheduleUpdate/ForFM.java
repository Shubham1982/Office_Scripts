package DeliveryScheduleUpdate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForFM {
    public static void main(String[] args) {
        ExcelFileData file = new ExcelFileData();
        String line = "";

        try {
            Map<String, Integer> partnersIdMap = new HashMap<>();
            partnersIdMap = getMapFromCSV(file.getDelivery_partner_dump(), 1, 0);

            System.out.println(partnersIdMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Map<String, Integer> getMapFromCSV(final String filePath, int col1, int col2) throws IOException {

        Map<String, Integer> resultMap = new HashMap<>();
        try {
            String line = "";
            BufferedReader br1 = new BufferedReader(new FileReader(filePath));
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                resultMap.put(data[col1],Integer.valueOf(data[col2]));
            }
        } catch (Exception e) {

        }
        return resultMap;
    }
}
