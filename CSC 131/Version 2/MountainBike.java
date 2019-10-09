
public class MountainBike extends Bicycle {
	public int seatHeight; 
	public MountainBike(int gear, int speed, int seatHeight) {
		super(gear, speed); 
		this.seatHeight = seatHeight;
	}
		
	public void setHeight(int newValue)
	{
		System.out.print("enter new seat height -> ");
		seatHeight = newValue;
	}
	
	public String toString(){
        return (super.toString()+
                "\nseat height is "+seatHeight);
}

}
