package entities;

public class Carro extends Automotor {

	protected String combustivel;

	public Carro() {
		super();
	}

	public Carro(Integer anoDeFabricacao, String modelo, String marca, Double precoDeMercado, String placa,
			String combustivel) {
		super(anoDeFabricacao, modelo, marca, precoDeMercado, placa);
		this.combustivel = combustivel;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	@Override
	public Double calcularImposto() {
		int aux = 2019 - anoDeFabricacao;
		if (aux > 20) {
			return 0.00;
		} else if (combustivel.equalsIgnoreCase("gasolina") || combustivel.equalsIgnoreCase("diesel")
				|| combustivel.equalsIgnoreCase("flex")) {
			return precoDeMercado * 4.00 / 100;
		} else {
			return precoDeMercado * 3.00 / 100;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nCombustível: " + combustivel;
	}
}
