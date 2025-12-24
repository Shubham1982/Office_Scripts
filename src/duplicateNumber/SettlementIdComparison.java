package duplicateNumber;

import java.util.*;

public class SettlementIdComparison {
    public static void main(String[] args) {
        // First list (all settlement IDs with duplicates)
        List<String> allSettlements = Arrays.asList(
                "setl_LfDuUvP7ztxujR","setl_LfDuc5phP4O6Tx","setl_LfDt60TcDNNuZZ","setl_LfDsmF5aRz7UWz","setl_LfDsmNt4Yzp0zt","setl_LfDsmF5aRz7UWz","setl_LfDuUvP7ztxujR",
                "setl_LfDvDE782Lbk87","setl_LfDt60TcDNNuZZ","setl_LfDsweXdwJnNNV","setl_LfDuc8rRr0HnMc","setl_LfDuc5phP4O6Tx","setl_LfDuUvP7ztxujR",
                "setl_LfDv6PVwbRNHJG","setl_LfDvM6uqYLALTt","setl_LfDsmNt4Yzp0zt","setl_LfDvM6uqYLALTt","setl_LfDuUvP7ztxujR","setl_LfDvDE782Lbk87","setl_LfDuUvP7ztxujR",
                "setl_LfDvDE782Lbk87","setl_LfDvq0e0LqVWGa","setl_LfDv97wdzlJpFq","setl_LfDt60TcDNNuZZ","setl_LfDt60TcDNNuZZ","setl_LfDuRqkwGY8GJA","setl_LfDuc8rRr0HnMc",
                "setl_LfDuluZ232TdBD","setl_LfDuUvP7ztxujR","setl_LfDtYA6St2qlCE","setl_LfDuUvP7ztxujR","setl_LfDvDE782Lbk87","setl_LfDt60TcDNNuZZ","setl_LfDuUvP7ztxujR",
                "setl_LfDuc5phP4O6Tx","setl_LfDspjAI7K8fr1","setl_LfDt60TcDNNuZZ","setl_LfDvM6uqYLALTt","setl_LfDtrWHJ7NRMMV","setl_LfDsmNt4Yzp0zt","setl_LfDt60TcDNNuZZ",
                "setl_LfDtmyzdvw8zKy","setl_LfDuRcL8VWFEU5","setl_LfDt60TcDNNuZZ","setl_LfDuUvP7ztxujR","setl_LfDt60TcDNNuZZ","setl_LfDvM6uqYLALTt","setl_LfDt60TcDNNuZZ",
                "setl_Ln8YevzYg788GJ","setl_LnX7OsV72CUxX7","setl_Lrt2MnsCQrT7yB","setl_LrsxUQFNLM5nc1","setl_Lsg0e5sg38ymKI","setl_Lsg0e5sg38ymKI","setl_Lt4aLjgrpMusaY",
                "setl_LvRqTgPxLQpoA6","setl_Lyc1CZRlNqSU4O","setl_M2xwHSj1WzRqNL","setl_M7iKOe28ZwfbQO","setl_MA5WQTVC2kPB7U","setl_MA5dMcEVvrDE9a","setl_MAU7h3gy5HNHXw",
                "setl_MDeNry7NbDSwbG","setl_MDeQMcsORbUdmS","setl_MInFCkJCbrtDn6","setl_MInGux9QkDXdsw","setl_MJBtxCdqTVCZCh","setl_MJBwkGbusli7gb","setl_MJBqDcIC34ZFMg",
                "setl_MJyr0YojccBU7i","setl_MKNXBvaHsaN2Qk","setl_MKNO32KixFhocF","setl_MLYz2zgv5iGYlM","setl_MUGk2VyWkINBvm","setl_Mb01cHbbqjm9NK","setl_Mb01cHbbqjm9NK",
                "setl_Mb02i9xtWvEYvU","setl_MazzPuO88ejmPe","setl_Mb02UeGwgp5IfG","setl_N4HMSHOzIe9O0c","setl_N6egrlAbQkHSUe","setl_NExphBYRjpd76w","setl_NExnQTmn3zUsBI",
                "setl_NExs98lzaW5VbD","setl_NHjZlgdsPIVjjN","setl_NHjWRkXS1HR2Cs","setl_NHjYRH3n8FaVmN","setl_NHjWRkXS1HR2Cs","setl_NHjWRkXS1HR2Cs","setl_NJJfWUQEOQ9Gcu",
                "setl_NLIK4qLE2S7nvh","setl_NQpoO0gQInQtkA","setl_NQpqxf3Ll2k7Kb","setl_NsXHHTlfCYBDmC","setl_O5zTWnsD3d4Ljt","setl_OVJc0Rl6GJRBCU","setl_OVJkT77swsUov9",
                "setl_OW6c0HYOU6kBi0","setl_OW6c0HYOU6kBi0","setl_OWV9cpgr55V2iM","setl_OWVHHFeF7t1fhb","setl_OYsTOwSndGZXoO","setl_OZGsmSQDwaLnbM","setl_Oar3XkWFWVwLK7",
                "setl_Oar3XkWFWVwLK7","setl_Oc2hWCalkpQYdV","setl_OcR9RuRgLkAYf1","setl_OcRDTK6lxaJxDw","setl_OcR9HriyMFaGIT","setl_OfbRqkHtr53afC","setl_OhBZ9W7jXaASSX",
                "setl_OhBfaITaEDnp7z","setl_OhaEaO1DiJIykF","setl_Oha80rOlyNkcfc","setl_OiNCO8VlL2d6wo","setl_OjxYQHkJkOGdlq","setl_OjxYQHkJkOGdlq","setl_OjxMGd0hZCGUwH",
                "setl_OjxYQHkJkOGdlq","setl_PC3FIVusxHNL37","setl_PSHHyw7sulgjFV","setl_QCBCvo8xo77J9R"
        );

        // Second list (subset of settlement IDs)
        List<String> processedSettlements = Arrays.asList(
                "setl_LfDsmF5aRz7UWz","setl_LfDsmNt4Yzp0zt","setl_LfDspjAI7K8fr1","setl_LfDsweXdwJnNNV","setl_LfDt60TcDNNuZZ","setl_LfDtmyzdvw8zKy","setl_LfDtrWHJ7NRMMV","setl_LfDtYA6St2qlCE",
                "setl_LfDuc5phP4O6Tx","setl_LfDuc8rRr0HnMc","setl_LfDuluZ232TdBD","setl_LfDuRcL8VWFEU5","setl_LfDuRqkwGY8GJA","setl_LfDuUvP7ztxujR","setl_LfDv6PVwbRNHJG","setl_LfDv97wdzlJpFq",
                "setl_LfDvDE782Lbk87","setl_LfDvM6uqYLALTt","setl_LfDvq0e0LqVWGa","setl_Ln8YevzYg788GJ","setl_LnX7OsV72CUxX7","setl_LrsxUQFNLM5nc1","setl_Lrt2MnsCQrT7yB","setl_Lsg0e5sg38ymKI",
                "setl_Lt4aLjgrpMusaY","setl_LvRqTgPxLQpoA6","setl_Lyc1CZRlNqSU4O","setl_M2xwHSj1WzRqNL","setl_M7iKOe28ZwfbQO","setl_MA5dMcEVvrDE9a","setl_MA5WQTVC2kPB7U","setl_MAU7h3gy5HNHXw",
                "setl_MazzPuO88ejmPe","setl_Mb01cHbbqjm9NK","setl_Mb02i9xtWvEYvU","setl_Mb02UeGwgp5IfG","setl_MDeNry7NbDSwbG","setl_MDeQMcsORbUdmS","setl_MInFCkJCbrtDn6","setl_MInGux9QkDXdsw",
                "setl_MJBqDcIC34ZFMg","setl_MJBtxCdqTVCZCh","setl_MJBwkGbusli7gb","setl_MJyr0YojccBU7i","setl_MKNO32KixFhocF","setl_MKNXBvaHsaN2Qk","setl_MLYz2zgv5iGYlM","setl_MUGk2VyWkINBvm",
                "setl_N4HMSHOzIe9O0c","setl_N6egrlAbQkHSUe","setl_NExnQTmn3zUsBI","setl_NExphBYRjpd76w","setl_NExs98lzaW5VbD","setl_NHjWRkXS1HR2Cs","setl_NHjYRH3n8FaVmN","setl_NHjZlgdsPIVjjN",
                "setl_NJJfWUQEOQ9Gcu","setl_NLIK4qLE2S7nvh","setl_NQpoO0gQInQtkA","setl_NQpqxf3Ll2k7Kb","setl_NsXHHTlfCYBDmC","setl_O5zTWnsD3d4Ljt","setl_Oar3XkWFWVwLK7","setl_Oc2hWCalkpQYdV",
                "setl_OcR9HriyMFaGIT","setl_OcR9RuRgLkAYf1","setl_OcRDTK6lxaJxDw","setl_OfbRqkHtr53afC","setl_Oha80rOlyNkcfc","setl_OhaEaO1DiJIykF","setl_OhBfaITaEDnp7z","setl_OhBZ9W7jXaASSX",
                "setl_OiNCO8VlL2d6wo","setl_OjxMGd0hZCGUwH","setl_OjxYQHkJkOGdlq","setl_OVJc0Rl6GJRBCU","setl_OVJkT77swsUov9","setl_OW6c0HYOU6kBi0","setl_OWV9cpgr55V2iM","setl_OWVHHFeF7t1fhb",
                "setl_OYsTOwSndGZXoO","setl_OZGsmSQDwaLnbM","setl_PC3FIVusxHNL37","setl_PSHHyw7sulgjFV","setl_QCBCvo8xo77J9R"
        );

        // Use sets to remove duplicates automatically
        Set<String> allSet = new HashSet<>(allSettlements);
        Set<String> processedSet = new HashSet<>(processedSettlements);

        // Find difference
        allSet.removeAll(processedSet);

        // Print result
        System.out.println("Unique settlement IDs not in second list:");
        allSet.forEach(System.out::println);
    }
}
