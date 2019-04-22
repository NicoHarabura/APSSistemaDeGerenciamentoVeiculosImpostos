package entities;

public class Moto extends Automotor {

	public Moto() {
		super();
	}
	
	public Moto(Integer anoDeFabricacao, String modelo, String marca, Double precoDeMercado, String placa) {
		super(anoDeFabricacao, modelo, marca, precoDeMercado, placa);
	}
	
	@Override
	public Double calcularImposto() {
		int aux = 2019 - anoDeFabricacao;
		if (aux > 20){
			return 0.00;
		} else {
			return precoDeMercado * 2.00/100; 
		}
	}
}
