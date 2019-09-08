import java.util.Arrays;
public class Farm{

	private Animal [] animals;
	private String farmName;
	private int numAnimals;
	
	public Farm() {
		animals = new Animal[10];
		farmName = "";
		numAnimals = 0;
		
	}
	
	public Farm(String farmName) {
		animals = new Animal[10];
	    this.farmName = farmName;
	    numAnimals = 0;
	}
	
	public Farm(int maxAnimals) {
		animals = new Animal[maxAnimals];
	    farmName = "";
	    numAnimals = 0;
	}
	
	public Farm(String farmName, int maxAnimals) {
		if(maxAnimals < 0) {
			maxAnimals = 0;
		}
		animals = new Animal[maxAnimals];
		this.farmName = farmName;
		numAnimals = 0;
	}
	
	public void addAnimal(Animal a) {
		 if(numAnimals >= animals.length) { 
			 resizeArray();
	   }
		 animals[numAnimals++] = a; 
	}
	
	public void resizeArray() {
	      if (animals.length == 0) {
	         animals = Arrays.copyOf(animals, 2);
	      }else {
	    	 animals = Arrays.copyOf(animals, animals.length * 2);
	      }
	      
	   }
	
	public String getFarmName() {
		return farmName;
	}
	
	public void setFarmName(String name) {
		farmName = name;
	}
	
	public Animal getAnimal(int index) {
		if(index < 0 || index >= numAnimals) {
			return null;
		}
		return animals[index];
	}
	
	public int getNumAnimals() {
		return numAnimals;
	}
	
	public Animal getFirstAnimal() {
		return animals[0];
	}
	
	public Animal getLastAnimal() {
		return animals[numAnimals-1];
	}
	
	public Animal [] getAnimals() {
		return animals;
	}
	
	public void printAllDetails() {
		String s1 = String.format("FarmName: %20s | Number of Animals: %4d | Farm Size: %4d\n", farmName, numAnimals, animals.length);
		System.out.println(s1);
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] != null) {
				animals[i].printDetails();	
			}
		}
	}
	
	public Animal removeAnimal(int index) {
		 if(index < 0 || index >= numAnimals) {
			 return null;
		 }
	      Animal[] tempArray = new Animal[animals.length];
	      int tempVal = 0;
	      Animal indexedAnimal = animals[index];
	      for(int i = 0; i<numAnimals; i++) {
	         if(i != index){
	            tempArray[tempVal] = animals[i];
	            tempVal++;
	         }
	      }
	      tempArray[animals.length - 1] = null;
	      animals = tempArray;
	      numAnimals -= 1;
	      return indexedAnimal;
	}
	
	public void removeAllAnimals() {
		numAnimals = 0;
	}
	
	public double getTotalWeightOfAllAnimals() {
		double totalWeight = 0;
		for(int i = 0; i < animals.length; i++) {
			totalWeight += animals[i].getWeight();
		}
		return totalWeight;
	}
	
	public double getAverageWeightOfAllAnimals() {
		return getTotalWeightOfAllAnimals()/numAnimals;	
	}
	
	public int getNumberOfAnimalsAboveWeight(double weight) {
		int animalsAboveWeight = 0;
		for(int i = 0; i < animals.length; i++) {
			if(animals[i].getWeight() > weight) {
				animalsAboveWeight++;
			}		
		}
		return animalsAboveWeight;
	}
	
	public int getNumberOfAnimalsBelowWeight(double weight) {
		int animalsBelowWeight = 0;
		for(int i = 0; i < animals.length; i++) {
			if(animals[i].getWeight() < weight) {
				animalsBelowWeight++;
			}		
		}
		return animalsBelowWeight;
	}
	
	public void increaseWeightOfAllAnimals() {
		for(int i = 0; i < animals.length; i++) {
			animals[i].gainWeight();
		}
	}
	
	public void increaseWeightOfAllAnimals(double weight) {
		for(int i = 0; i < animals.length; i++) {
			animals[i].gainWeight(weight);
		}
	}
	

	
}
