
public class BevShopDriverApp {

	public static void main(String[] args) {
		final Day today = Day.WEDNESDAY;
		final int time = 9;
		
		BevShop b = new BevShop();
		Customer c = new Customer("Praharsh", 21);
		
		System.out.println("New order");
		b.startNewOrder(time, today, c.getName(), c.getAge());
		System.out.println(b.getCurrentOrder().toString());
		
		System.out.println("Adding alcohol...");
		b.processAlcoholOrder("drink1", Size.LARGE);
		
		System.out.println("Adding alcohol...");
		b.processAlcoholOrder("drink2", Size.LARGE);
		
		System.out.println("Adding alcohol...");
		b.processAlcoholOrder("drink3", Size.MEDIUM);
		
		System.out.println("Adding alcohol...");
		b.processAlcoholOrder("drink4", Size.SMALL);
		
		
		System.out.printf("\nAdding a %s to order...\n", Type.COFFEE);
		b.processCoffeeOrder("decaf", Size.SMALL, false, false);
		
		System.out.printf("\nAdding a %s to order...\n", Type.SMOOTHIE);
		b.processSmoothieOrder("banana", Size.LARGE, 30, true);
		
		System.out.println(b.getCurrentOrder().toString());
		System.out.printf("\nTotal : $%.2f", b.getCurrentOrder().calcOrderTotal());
	}

}