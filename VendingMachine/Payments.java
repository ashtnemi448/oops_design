package VendingMachine;

public class Payments {

	public int makePayment(int totalPrice, PaymentTypes paymentType) {
		if(paymentType == PaymentTypes.CARD){
			return payVaicard(totalPrice);
		} else {
			return validateCash(totalPrice);
		}
	}

	private int validateCash(int totalPrice) {
		return 1;
	}

	private int payVaicard(int totalPrice) {
		return 1;
	}
	
}
