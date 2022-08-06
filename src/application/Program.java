package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installments;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

/* 
-------------------------------------------------------------------------
PROBLEMA:

	Fazer um programa para ler uma quantia e a duração em meses de um
	empréstimo. Informar o valor a ser pago depois de decorrido o prazo do
	empréstimo, conforme regras de juros do Brasil. A regra de cálculo de
	juros do Brasil é juro composto padrão de 2% ao mês.
-------------------------------------------------------------------------

EXEMPLO:



 */

public class Program {

	public static void main(String[] args) throws ParseException {

		/*
		 * - PEQUENO TESTE - /* OnlinePaymentService ps = new PaypalService(); /*
		 * System.out.println(ps.interest(200, 3));
		 */

		OnlinePaymentService ps = new PaypalService();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		System.out.print("Enter number of installments: ");
		int N = sc.nextInt();

		ContractService cs = new ContractService(new PaypalService());

		cs.processContract(contract, N);

		System.out.println("Installments:");
		for (Installments it : contract.getInstallments()) {
			System.out.println(it);
		}

		sc.close();

	}
}
