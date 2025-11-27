
public class FeesNotPaidException extends Exception {
	public String toString(){
		return"Fees not paid (total fees paid=0)";
	}
}
