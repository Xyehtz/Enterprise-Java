package ca.sheridancollege.garzonba.week3.beans;

@Data
@Builder
public class Inventory {
    private long itemID;
    private String itemName;
    private int quantity;
}

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Inventory {
//    private long itemId;
//    private String itemName;
//    private int quantity;
//}
