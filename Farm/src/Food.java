public class Food {
	
	private String name;
	private int calories;
	
	public Food(String name, int calories) {
		setName(name);
		setCalories(calories);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name  = name;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		String s = String.format("Food - name: %10s | calories: %4d", name, calories);
		return s;
				
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Food){
			Food otherFood = (Food)obj;
					if(this.name.equalsIgnoreCase(otherFood.name)){
						if(this.calories == otherFood.calories){
						return true;						
						}
					}
				}
				return false;
			}
	

}
