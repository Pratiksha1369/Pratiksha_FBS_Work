abstract class Payment {
    private int paymentId;
    private double amount;
    private String payerName;
    private String status;

    // DEFAULT CONSTRUCTOR
    Payment() {
        this.paymentId = 0;
        this.amount = 0.0;
        this.payerName = "Not Given";
        this.status = "PENDING";
    }

    // PARAMETERIZED CONSTRUCTOR
    Payment(int paymentId, double amount, String payerName) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.payerName = payerName;
        this.status = "PENDING";
    }

    // GETTERS & SETTERS
    int getPaymentId() { return paymentId; }
    void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    double getAmount() { return amount; }
    void setAmount(double amount) { this.amount = amount; }

    String getPayerName() { return payerName; }
    void setPayerName(String payerName) { this.payerName = payerName; }

     String getStatus() { return status; }
     void setStatus(String status) { this.status = status; }

    // FINAL TEMPLATE METHOD (DO NOT OVERRIDE)
    public final void process() {
        if (validate()) {
            deductAmount();
            sendNotification();
            status = "SUCCESS";
        } else {
            status = "FAILED";
        }
    }

    // ABSTRACT METHODS
    abstract boolean validate();
    abstract void deductAmount();
    abstract void sendNotification();

    // PRINT SUMMARY
    public void printSummary() {
        System.out.println(this.toString());
    }

    // TOSTRING
    public String toString() {
        return "Payment ID: " + paymentId +
               "\nPayer Name: " + payerName +
               "\nAmount: " + amount +
               "\nStatus: " + status ;
    }
}


class CardPayment extends Payment {
    private String cardNumber;
    private String cvv;

    // DEFAULT CONSTRUCTOR
    CardPayment() {
        super();
        this.cardNumber = "0000000000000000";
        this.cvv = "000";
    }

    // PARAMETERIZED CONSTRUCTOR
    CardPayment(int paymentId, double amount, String payerName, String cardNumber, String cvv) {
        super(paymentId, amount, payerName);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    // GETTERS & SETTERS
    String getCardNumber() {
		return cardNumber;
	}

	void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	String getCvv() {
		return cvv;
	}

	void setCvv(String cvv) {
		this.cvv = cvv;
	}
     
     

    // VALIDATE
    @Override
    boolean validate() {
        return cardNumber.length() == 16 && cvv.length() == 3 && getAmount() > 0;
    }

	@Override
    void deductAmount() {
        System.out.println("Deducting Rs. " + getAmount() + " from Card " + cardNumber);
    }

    @Override
    void sendNotification() {
        System.out.println("Card Payment Notification Sent!");
    }

    // TOSTRING
    public String toString() {
        return super.toString() +
               "\nCard Number: " + cardNumber +
               "\nCVV: " + cvv ;
    }
}


class UPIPayment extends Payment {
    private String upiId;

    // DEFAULT CONSTRUCTOR
    UPIPayment() {
        super();
        this.upiId = "unknown@upi";
    }

    // PARAMETERIZED CONSTRUCTOR
    UPIPayment(int paymentId, double amount, String payerName, String upiId) {
        super(paymentId, amount, payerName);
        this.upiId = upiId;
    }

    // GETTERS & SETTERS
     String getUpiId() { return upiId; }
     void setUpiId(String upiId) { this.upiId = upiId; }

    // VALIDATE
    @Override
    boolean validate() {
        return upiId.contains("@") && getAmount() >= 1 && getAmount() <= 100000;
    }

    @Override
    void deductAmount() {
        System.out.println("Deducting Rs. " + getAmount() + " from UPI: " + upiId);
    }

    @Override
    void sendNotification() {
        System.out.println("UPI Payment Notification Sent!");
    }

    // TOSTRING
    public String toString() {
        return super.toString() + "\nUPI ID: " + upiId;
    }
}

public class PaymentMain {
    public static void main(String[] args) {

        Payment p1 = new CardPayment(1, 5000, "Rahul", "123456789", "123");
        p1.process();
        p1.printSummary();

        Payment p2 = new UPIPayment(2, 2200, "Aarav", "aarav@upi");
        p2.process();
        p2.printSummary();

        CardPayment p3 = new CardPayment();
        p3.setAmount(3000);
        p3.setPayerName("Default User");
        p3.setCardNumber("9999888877776666");
        p3.setCvv("456");
        p3.process();
        p3.printSummary();

    }
}


