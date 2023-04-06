package entidades;

public class Folha {
	private String nomeFuncionario;
	private int mes;
	private int ano;
	private int numHorasTrabalhadas;
	private float valorHora;

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getAno() {
		return ano;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getMes() {
		return mes;
	}
	public void setNumHorasTrabalhadas(int numHorasTrabalhadas) {
		this.numHorasTrabalhadas = numHorasTrabalhadas;
	}
	
	public int getNumHorasTrabalhadas() {
		return numHorasTrabalhadas;
	}
	
	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}
	
	public float getValorHora() {
		return valorHora;
	}
}
