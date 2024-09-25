package interfaces;

public interface PaymentService {

    void acceptCash(int amount);
    void acceptCreditCard(int amount, String cardNumber, int cvv);
}
