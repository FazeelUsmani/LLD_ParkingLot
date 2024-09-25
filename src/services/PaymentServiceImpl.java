package services;

import interfaces.PaymentService;
import paymentMethods.Cash;
import paymentMethods.CreditCard;
import paymentMethods.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void acceptCash(int amount) {
        PaymentMethod cash = new Cash();
        cash.initiatePayment(amount);
    }

    @Override
    public void acceptCreditCard(int amount, String cardNumber, int cvv) {
        PaymentMethod creditCard = new CreditCard(cardNumber, cvv);
        creditCard.initiatePayment(amount);
    }
}
