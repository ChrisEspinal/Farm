public class Cat extends Mammal implements Speaker{
	
	public double metabolizeAccumulatedCalories() {
		setCaloriesAccumulator(0);
		setWeight(getCaloriesConsumed()/1000);
		return getWeight();
	}
	
	public String speak() {
		String s = "meow";
		return s;
	}
	
	public String speak(int count) {
		String s = "";
		for(int i = 0; i < count; i++) {
			if (i == count-1) {
				s += speak();
			} else {
				s += speak() + " ";
			}
		}return s;
	}

}
