package checkout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPriceIsZeroForEmptyCart() {
		Checkout checkout = new Checkout();
		Euro price = checkout.getTotal();
		assertEquals(new Euro(0), price);
	}

	@Test
	void testTotalIsZeroForSingleItemWithPriceZero() {
		Checkout checkout = new Checkout();
		checkout.scan(new Item(new Euro(0)));
		Euro price = checkout.getTotal();
		assertEquals(new Euro(0), price);
	}
	
	@Test
	void testTotalIsFiveForSingleItemWithPriceFive() {
		Checkout checkout = new Checkout();
		checkout.scan(new Item(new Euro(5)));
		Euro price = checkout.getTotal();
		assertEquals(new Euro(5), price);
		assertNotEquals(new Euro(3), price);
	}
	
	@Test
	void testTotalIsTenForTwoItemsWithPriceFive() {
		Checkout checkout = new Checkout();
		Item itemA = new Item(new Euro(5));
		checkout.scan(itemA);
		checkout.scan(itemA);
		Euro price = checkout.getTotal();
		assertEquals(new Euro(10), price);
	}
	
	@Test
	void testTotalIsElevenForTwoItemsWithDifferentPrice() {
		Checkout checkout = new Checkout();
		Item itemA = new Item(new Euro(7));
		Item itemB = new Item(new Euro(4));
		checkout.scan(itemA);
		checkout.scan(itemB);
		Euro price = checkout.getTotal();
		assertEquals(new Euro(11), price);
	}

}
