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

public class DeliveryScheduleUpdateByNewLogic {
    public static void main(String[] args) {
        String line = "";
        String insert = "insert into partner_delivery_details (delivery_schedules_id, delivery_mile_id, partner_mobile, retailer_sales_order_id, lr_number,delivery_partners_id, transporter_type, is_deleted, created_by, last_modified_by) values";
        int i = 0, j = 0;
        try {

            String basicPath = "/home/lt-444/Downloads/Old D/DeliveryScheduleUpdate/";
            BufferedReader br1 = new BufferedReader(new FileReader(basicPath+"Sheet - Sheet1.csv"));
            BufferedReader br2 = new BufferedReader(new FileReader(basicPath +"Sheet - Sheet1.csv"));

            Map<Integer, String> partnersIdMap = new HashMap<>();
            Map<Integer, String> deliveryMilesMap = new HashMap<>();
            Map<Integer, String> deliverySchdelesMap = new HashMap<>();
            String basicFilepath = "/home/lt-444/Downloads/Old D/DeliveryScheduleUpdate/";

            partnersIdMap = getMapFromCSV(basicFilepath+"delivery_partners_mobiles.csv", 0, 1);
            deliveryMilesMap = getMapFromCSV(basicFilepath+"partner_delivery_details.csv", 4, 1);
            deliverySchdelesMap = getMapFromCSV(basicFilepath+"delivery_schedules.csv", 0, 5);
//            System.out.println("insert into partner_delivery_details (delivery_schedules_id, delivery_mile_id, partner_mobile, retailer_sales_order_id, lr_number, transporter_name,delivery_partners_id, transporter_type, is_deleted, created_by, last_modified_by) values");
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");

//                System.out.println("update delivery_schedules set remarks = '" + data[2] + "', description = '"+ data[3] + "', last_modified_by='backend', last_modified_date=now() where retailer_sales_order_id =" + data[0] + ";");

                if(partnersIdMap.values().contains(data[1]) && data[6].equals("LM")) {

                    System.out.println("update delivery_schedules set lr_number = '" + data[4] + "', delivery_partners_id = " + getKeyByValue(partnersIdMap,data[1]) + ", transporter_type = '" + data[2]
                            + "', partner_mobile ='" + data[1] + "', last_modified_by='backend_s', last_modified_date=now(), delivery_mile_id = 3 where retailer_sales_order_id =" + data[0] + ";");
                }


//                System.out.println("(" +data[0] + ", 3, '"+ data[3]+ "', "+ data[5] + ", '" + data[13] + "', '"+ data[14]+ "', "+ data[6] +", '" + data[15] + "', 0, 'backend', 'backend'),");
                i++;
            }

            while ((line = br2.readLine()) != null) {
                if (j == 0) {
                    j++;
                    continue;
                }
                String[] data = line.split(",");
                if(deliveryMilesMap.containsKey(Integer.parseInt(data[0]))) {
                    System.out.println("update partner_delivery_details set lr_number = '" + data[4] + "', delivery_partners_id = " + getKeyByValue(partnersIdMap,data[1]) + ", transporter_type = '" + data[2]
                            + "', partner_mobile ='" + data[1] + "', last_modified_by='backend_s', last_modified_date=now() where retailer_sales_order_id =" + data[0] + " and delivery_mile_id = 3 and is_deleted is false;");
                    j++;
                } else {
//                    System.out.println("insert into partner_delivery_details (delivery_schedules_id, delivery_mile_id, partner_mobile, retailer_sales_order_id, lr_number,delivery_partners_id, transporter_type, is_deleted, created_by, last_modified_by) values");
                    insert += "(" +getKeyByValue(deliverySchdelesMap,data[0]) + ", 3, '"+ data[1]+ "', "+ data[0] + ", '" + data[4] +"', "+ getKeyByValue(partnersIdMap,data[1]) +", '" + data[2] + "', 0, 'backend_s', 'backend_s'),\n";
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(insert);
            System.out.println("Count:" + i);
            System.out.println("Count2:" + j);
        }
    }

    public static Map<Integer, String> getMapFromCSV(final String filePath, int col1, int col2) throws IOException {

        Map<Integer, String> resultMap = null;
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            resultMap = lines.map(line -> line.split(","))
                    .collect(Collectors.toMap(line -> Integer.parseInt(line[col1]), line -> line[col2]));

            lines.close();


        } catch (Exception e) {

        }
        return resultMap;
    }

    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
