public class Comparacion implements Comparable<Comparacion>{
	private int valor;
	public Comparacion(int num) {
		this.valor= num;
	}



	public int compareTo(Comparacion comparable) {
		if(valor>comparable.getValor()){
			return 0;
		}else{
			return 1;
		}
	}



	public int getValor() {
		return valor;
	}



	public void setValor(int valor) {
		this.valor = valor;
	}
	
}