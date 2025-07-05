package DeliveryScheduleUpdate;

public class ExcelFileData {

    final String path = "/home/lt-444/Downloads/DeliverScheduleDump/"  ;

    String delivery_partner_dump =  path + "Delivery_partner.csv";
    String partner_delivery_details_dump = "fdf";
    String delivery_schedules_dump = "fdf";

    public String getDelivery_partner_dump() {
        return delivery_partner_dump;
    }

    public String getPartner_delivery_details_dump() {
        return partner_delivery_details_dump;
    }

    public String getDelivery_schedules_dump() {
        return delivery_schedules_dump;
    }
}
