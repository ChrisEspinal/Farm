public abstract class Animal implements Eater{
		
	private String name;
	private int birthYear;
	private double weight;
	private char gender;
	private double height;
	private int caloriesConsumed = 0;
	private int caloriesAccumulator = 0;
	
	public Animal() {
		name = "";
		birthYear = 1900;
		weight = 0.0;
		gender = 'u';
	}
	
	public Animal(String name, int birthYear, double weight, char gender) {
		setName(name);
		setBirthYear(birthYear);
		setWeight(weight);
		setGender(gender);
	}
	
	public Animal(String name, int birthYear, double weight, double height, char gender) {
		setName(name);
		setBirthYear(birthYear);
		setWeight(weight);
		setHeight(height);
		setGender(gender);		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		if(weight >= 0) {
			this.weight = weight;
		}else{
			this.weight = -1;	
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		if(height >= 0) {
			this.height = height;
		}else{
			this.height = -1;
		}
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		if(gender == 'm' || gender == 'f'){
			this.gender = gender;
		}else{
			this.gender = 'u';
		}
	} 
	
	public int getCaloriesConsumed() {
		return caloriesConsumed;
	}
	
	public void setCaloriesConsumed(int caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}
	
	public int getCaloriesAccumulator() {
		return caloriesAccumulator;
	}
	
	public void setCaloriesAccumulator(int caloriesAccumulator) {
		this.caloriesAccumulator = caloriesAccumulator;
	}
	
	public void eat(Food food) {
		caloriesConsumed += food.getCalories();
		caloriesAccumulator += food.getCalories();
	}
	
	public void eat(Food[] foods) {
		for(int i = 0; i < foods.length; i++) {
			caloriesConsumed += foods[i].getCalories();
			caloriesAccumulator += foods[i].getCalories(); 
		}
	}
	
	public abstract double metabolizeAccumulatedCalories();
	
	public int calculateAge(int currentYear) {
		if(currentYear < birthYear) {
			return -1;
		} 
		int age = currentYear - birthYear;
		return age; 
	}

	
	public boolean isMale() {
		if(gender == 'm') {
			return true;
		}
		return false;
	}
	
	public boolean isFemale() {
		if(gender == 'f') {
			return true;
		}
		return false;
	}

	public void printDetails() {
		String s = String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f |  Height: %10.2f | Gender: %c\\n", name, birthYear, weight, height, gender);
		System.out.print(s);
	}
	
	public void gainWeight() {
		weight +=1;
	}
	
	public void gainWeight(double weight) {
		if(this.weight + weight >= 0) {
			this.weight += weight;	
		}
	}
	
	public void loseWeight() {
		if(weight >=1) {
			weight -=1;
		}
			
	}
		
	public void loseWeight(double weight) {
		if (this.weight - weight >= 0) {
			this.weight -= weight;
		}
		
	}
	
	public double calculateBMI() {
		double BMI = weight/(height*height) * 703;
		return BMI;
	}
	
	@Override
	public String toString(){
		String s = String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c\n", name, birthYear, weight, height, gender);
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Animal){
			Animal otherAnimal = (Animal)obj;
			if(this.birthYear == otherAnimal.birthYear){
				if(this.gender == otherAnimal.gender){
					if(this.name.equalsIgnoreCase(otherAnimal.name)){
						if(Math.abs(this.weight - otherAnimal.weight) < .5 && Math.abs(this.height - otherAnimal.height) < .5 ){
						return true;						
						}
					}
				}
			}
		}
		return false;
	}
	
}
