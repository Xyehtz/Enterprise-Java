package ca.sheridancollege.garzonba.week3;

import ca.sheridancollege.garzonba.week3.beans.Inventory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week3Application {

	public static void main(String[] args) {
		SpringApplication.run(Week3Application.class, args);
		
		Inventory inventory = Inventory.builder().itemId(32L).itemName("Pencil").quantity(5).build();

//		Inventory inv1 = new Inventory();
//		inv1.setItemId(2344L);
//		inv1.setItemName("Car");
//		inv1.setQuantity(3);
//		
//		Inventory inv2 = new Inventory(242L, "Nanobot", 4)
	}

}
