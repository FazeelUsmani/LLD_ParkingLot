package paymentMethods;

public class Cash extends PaymentMethod{

    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Making cash payment of INR " + amount);
        return true;
    }
}
