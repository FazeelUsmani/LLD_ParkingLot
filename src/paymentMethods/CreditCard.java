package paymentMethods;

public class CreditCard extends PaymentMethod {
    private String cardNumber;
    private int cvv;

    public CreditCard(String cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Making CC payment of INR " + amount);
        return true;
    }
}
