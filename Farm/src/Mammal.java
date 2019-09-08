public abstract class Mammal extends Animal {
	
	private double tailLength;
	private int numLegs;
	
	public Mammal() {
		super();
		tailLength = 0;
		numLegs = 0;
	}
	
	public Mammal(double tailLength, int numLegs) {
		super();
		setTailLength(tailLength);
		setNumLegs(numLegs);
	}
	
	public Mammal(String name, int birthYear, double weight, double height, char gender, double tailLength, int numLegs) {
		super(name, birthYear, weight, height, gender);
		setTailLength(tailLength);
		setNumLegs(numLegs);	
	}
	
	public void setTailLength(double tailLength) {
		if(tailLength >= 0) {
			this.tailLength = tailLength;
		}else{
			this.tailLength = -1;	
		}
	}
	
	public double getTailLength() {
		return tailLength;
	}
	
	public void setNumLegs(int numLegs) {
		if(numLegs >= 0) {
			this.numLegs = numLegs;
		}else{
			this.numLegs = -1;	
		}
	}
	
	public int getNumLegs() {
		return numLegs;
	}
	
	@Override
	public void printDetails() {
		super.printDetails();
		String s = String.format("Mammal: Tail Length: %10.2f | Number of Legs: %4d\n", tailLength, numLegs);
		System.out.print(s);
	}
	
	@Override
	public String toString(){
		String s = super.toString();
		s += String.format("Mammal: Tail Length: %10.2f | Number of Legs: %4d\n", tailLength, numLegs);
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Mammal){
			if(super.equals(obj)){
				Mammal otherMammal = (Mammal)obj;
					if(this.numLegs == otherMammal.numLegs){
						if(Math.abs(this.tailLength - otherMammal.tailLength) < .1){
						return true;						
						}
					}
				}
			}
			return false;
		}
	
	
}
