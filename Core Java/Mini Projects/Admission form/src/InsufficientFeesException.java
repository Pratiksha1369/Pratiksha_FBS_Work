
public class InsufficientFeesException extends Exception {
	public String toString(){
		return"Your Fees paid  < 35% of total fees";
	}
}
