package services;

// os serviços de pagamento tem que implementar essa interface
// é um contrato
public interface OnlinePaymentService {

	double paymentFee(double amount);
	double interest(double amount, int months);
	
}
