package checkout;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

	private List<Item> items = new ArrayList<Item>();

	public Euro getTotal() {
		Euro total = new Euro(0);
		for (Item item : items) {
			total.add(item.getPrice());
		}
		return total;
	}

	public void scan(Item item) {
		this.items.add(item);
	}

}
