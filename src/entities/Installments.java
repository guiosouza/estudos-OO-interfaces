package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installments {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	private Date dueDate;
	private Double amount;
	
	public Installments() {
		
	}
	
	public Installments(Date dueDate, Double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
	}
}
