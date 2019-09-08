public class Dog extends Mammal implements Speaker{
	
	private DogToy[] toys;
	private int numDogToys;
	
	public Dog(){
		super();
		toys = new DogToy[10];
		numDogToys = 0;
	}
	 
	public Dog(double tailLength, int numLegs) {
		super(tailLength, numLegs);
		toys = new DogToy[10];
		numDogToys = 0;		
	}
	
	public Dog(String name, int birthYear, double weight, double height, char gender, double tailLength, int numLegs) {
		super(name, birthYear, weight, height, gender, tailLength, numLegs);
		toys = new DogToy[10];
		numDogToys = 0;	
	}
	
	public void addDogToy(String name, int rating) {
		if(numDogToys < toys.length) {
			toys[numDogToys++] = new DogToy(name, rating);
		}else{
			System.out.println("toys has reached capacity of 10");
		}
	}
	
	public String getDogToyAsString(int index) {
		if(index < 0 || index >= toys.length || toys[index] == null) {
			return "invalid index " + index;
		}else{
			return toys[index].toString();
		}
	}
	
	public int getNumDogToys() {
		return numDogToys;
	}
	
	public String getDogToyName(int index) {
		if(index < 0 || index >= toys.length || toys[index] == null) {
			return "invalid index " + index;
		}else{
			return toys[index].dogToyName;	
		}
	}
	
	public int getDogToyRating(int index) {
		if(index < 0 || index >= toys.length || toys[index] == null) {
			return -1;
		}else{
			return toys[index].dogToyRating;
		}
	
	}
	
	public int getHighestDogToyRating() {
		int rating = 0;
		for(int i = 0; i < toys.length; i++) {
			if(toys[i] != null && toys[i].dogToyRating > rating) {
				rating = toys[i].dogToyRating;
			}
		}
		return rating;
	}
	
	public double metabolizeAccumulatedCalories() {
		setCaloriesAccumulator(0);
		setWeight(getCaloriesConsumed()/2000);
		return getWeight();
	}
	
	public String speak() {
		String s = "woof";
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
	
	@Override
	public void printDetails() {
		super.printDetails();
		String s = String.format("Dog: Number of Toys: %4d | Dog Toys:\n", numDogToys, numDogToys);
		System.out.print(s);
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		for(int i = 0; i < toys.length; i++) {
			s += toys[i].toString();
		}return s;
	}

	
	
	public class DogToy{
		
		private String dogToyName;
		private int dogToyRating;
		
		public DogToy(String dogToyName, int dogToyRating) {
			this.dogToyName = dogToyName;
			this.dogToyRating = dogToyRating;
		}
		
		public String toString() {
			String s = String.format("DogToy: Toy Name: %20s | Rating %4d\n", dogToyName, dogToyRating);
			return s;
		}
		
	}
}
