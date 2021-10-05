package FractionalKnapsack;

import java.util.Arrays;
import java.util.Comparator;

public class FrationalKnapsack {
	public static void main(String[] args) {
		int[] value = { 60, 40, 100, 120 };
		int[] weight = { 10, 40, 20, 30 };
		int capacity = 50;
		double maxValue = getMaxValue(value, weight, capacity);
		System.out.println("The maximum profit possible = " + maxValue);
	}

	private static double getMaxValue(int[] value, int[] weight, int capacity) {
		// TODO Auto-generated method stub
		Item[] items = new Item[weight.length];
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item(value[i], weight[i], i);
		}
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				// sort in descending order
				return o2.cost.compareTo(o1.cost);
			}

		});
		double totalValue = 0d;
		for(Item item : items)
		{
			int currentWeight = (int) item.weight;
			int currentValue = (int) item.value;
			if(capacity - currentWeight>=0)
			{
				capacity = capacity - currentWeight;
				totalValue+=currentValue;
			}else
			{
				double fraction = (double) capacity/(double)currentWeight;
				totalValue += currentValue*fraction;
				break;
			}
		}
		return totalValue;
	}

	static class Item {
		Double cost;
		double value, weight, index;

		public Item(int value, int weight, int index) {
			this.value = value;
			this.weight = weight;
			this.index = index;
			this.cost = Double.valueOf(value / weight);
		}
	}
}
