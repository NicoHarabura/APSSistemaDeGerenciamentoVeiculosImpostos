package entities;

public class Automotor {

	protected Integer anoDeFabricacao;
	protected String modelo;
	protected String marca;
	protected Double precoDeMercado;
	protected String placa;

	public Automotor(Integer anoDeFabricacao, String modelo, String marca, Double precoDeMercado, String placa) {
		this.anoDeFabricacao = anoDeFabricacao;
		this.modelo = modelo;
		this.marca = marca;
		this.precoDeMercado = precoDeMercado;
		this.placa = placa;
	}

	public Automotor() {

	}

	public Integer getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public Double getPrecoDeMercado() {
		return precoDeMercado;
	}

	public void setPrecoDeMercado(Double precoDeMercado) {
		this.precoDeMercado = precoDeMercado;
	}

	public String getPlaca() {
		return placa;
	}
	
	public Double calcularImposto() { 
		return 0.00;
	}
	
	public String toString(){
		return "\nAno de fabricação: " + anoDeFabricacao
				+ "\nModelo: " + modelo
				+ "\nMarca: " + marca
				+ "\nValor de mercado: R$" + String.format("%.2f", precoDeMercado)
				+ "\nPlaca: " + placa;
	}

}
