package checkout;

import java.util.HashMap;
import java.util.Map;

public class Checkout {

	private Map<Item, Integer> items = new HashMap<>();

	public Euro getTotal() {
		Euro total = new Euro(0);
		for (Item item : items.keySet()) {
			Integer itemCount = items.get(item);
			long euroCents = item.getPrice().euroCents * itemCount;
			if (itemCount > 1) {
				euroCents = euroCents * 5 / 6;
			}
			total.add(new Euro(euroCents));
		}

		return total;
	}

	public void scan(Item item) {
		if (items.containsKey(item)) {
			items.replace(item, items.get(item) + 1);
		} else {
			items.put(item, 1);
		}
	}

}
