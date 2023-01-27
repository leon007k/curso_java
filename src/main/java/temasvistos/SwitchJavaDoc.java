package temasvistos;

public class SwitchJavaDoc {
	public SwitchJavaDoc(double quantity, String currency) {
		this.quantity = quantity;
		this.currency = currency;
	}
	
	public double quantity;
	public String currency;
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/** 
	 * Descripcion: Funcion que especificando su moneda convierte una cantidad de dinero a dolares
	 * 
	 * @param quantity Cantidad de dinero
	 * @param currency Tipo de moneda: Solo acepta MXN o COP
	 * @return quantity Devuelve la cantidad actualizada en Dolares
	 * */
	public double converToDolar(double quantity, String currency) {
		//MXN COP
		switch(currency) {
			case "MXN":
				quantity *= 0.053;
				break;
			case "COP":
				quantity *= 0.0031;
				break;
			default:
				quantity = 0;
				break;
		}
		// La conversion obtenida, se redondea a dos decimales
		double roundQuantity = Math.round(quantity*100.0)/100.0;
		return roundQuantity;
	}
	
	/**
	 * Description: Funcion que devuelve el mensaje del resultado de la conversion o indica que no se cuenta con esa conversion de moneda
	 *
	 * @param quantity cantidad de dinero que ya fue convertida
	 * @return message Devuelve el valor de la conversion o inexistencia de la moneda a convertir
	 *  */
	public String messageConvertToDolar(double quantity) {
		String message = quantity > 0 ? "tu resultado es: " + quantity : "lo sentimos, no contamos con ese calculo";
		return message;
	}
}
