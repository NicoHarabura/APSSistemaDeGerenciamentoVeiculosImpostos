package entities;

public class Picape extends Automotor {

	protected String cabine;
	
	public Picape() {
		super();
	}

	public Picape(Integer anoDeFabricacao, String modelo, String marca, Double precoDeMercado, String placa,
			String cabine) {
		super(anoDeFabricacao, modelo, marca, precoDeMercado, placa);
		this.cabine = cabine;
	}

	public String getCabine() {
		return cabine;
	}

	public void setCabine(String cabine) {
		this.cabine = cabine;
	}
	
	@Override
	public Double calcularImposto() {
		int aux = 2019 - anoDeFabricacao;
		if (aux > 20){
			return 0.00;
		} else if (cabine.equalsIgnoreCase("simples")){
			return precoDeMercado * 2.00/100;
		} else { 
			return precoDeMercado * 4.00/100;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nTipo de cabine: " + cabine;
	}
	
}
