public class Cow extends Mammal implements Speaker{
	
	public double metabolizeAccumulatedCalories() {
		setCaloriesAccumulator(0);
		setWeight(getCaloriesConsumed()/500);
		return getWeight();
	}
	
	public String speak() {
		String s = "moo";
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
