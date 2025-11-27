
class AdmissionForm {
	String studentName;
	int age;
	double percentage;
	double courseFees;
	double feesPaid;

	AdmissionForm(String studentName, int age, double percentage, double courseFees, double feesPaid) {
		super();
		this.studentName = studentName;
		this.age = age;
		this.percentage = percentage;
		this.courseFees = courseFees;
		this.feesPaid = feesPaid;
	}

//	EmptyNameException → Name is empty or contains only spaces.
//
//	UnderageException → Age < 17.
//
//	InvalidPercentageException → Percentage < 0 or > 100.
//
//	NotFitForAdmissionException → Percentage < 35.
//
//	FeesNotPaidException → Fees paid = 0.
//
//	InsufficientFeesException → Fees paid < 30% of courseFees
	public void validateForm() throws EmptyNameException, UnderageException, InvalidPercentageException,
			NotFitForAdmissionException, FeesNotPaidException, InsufficientFeesException {
		if (this.studentName == null) {
			throw new EmptyNameException();
		} else if (this.age < 17) {
			throw new UnderageException();
		} else if (this.percentage < 0 && this.percentage > 100) {
			throw new InvalidPercentageException();
		} else if (this.percentage < 35) {
			throw new NotFitForAdmissionException();
		} else if (this.feesPaid == 0) {
			throw new FeesNotPaidException();
		} else if (this.courseFees < 0.3 * courseFees) {
			throw new InsufficientFeesException();
		} else {
			System.out.println("You pass all the criteria \nCongratulations!!! You are eligible for the admission");
		}

	}
}

class TestAdmission {
	public static void main(String[] args) {
		AdmissionForm a1 = new AdmissionForm("Levi", 20, 87, 38000, 35000);
		try {
			a1.validateForm();
		} catch (EmptyNameException e) {

			System.out.println(e);
		} catch (UnderageException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InvalidPercentageException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (NotFitForAdmissionException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (FeesNotPaidException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InsufficientFeesException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
