package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installments;

public class ContractService {

	// COMPOSIÇÃO DE OBJETOS
	
	
	/* não vamos fazer na forma abaixo:
	 * private PaypalService paymentService = new PaypalService();
	 * -----------------------------------------------------------
	 * EXPLICAÇÃO:
	 * - Se em um futuro tivermos de alterar a forma de pagamento
	 * - Teríamos de abrir essa classe aqui para fazer alterações
	 * - PARA RESOLVER vamos usar a: INVERSÃO DE CONTROLE
	 * - A classe ContractService aqui não será responsável
	 * - Pelo controle de qual instância ela vai precisar para executar
	 * - Um agente externo deve entregar a instância
	 * - Veja abaixo:
	 */
	
	private OnlinePaymentService onlinePaymentService; // interface
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	// processar as parcelas do contrato
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		// exemplo: se Contract = 200 então: basicQuota = 200 (agora) 
		for(int i = 1; i <= months; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			// updatedQuota = 202
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			// fullQuota = 206.04
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installments(dueDate, fullQuota));
		}
	}
	
	// adicionar meses em uma data
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
}
