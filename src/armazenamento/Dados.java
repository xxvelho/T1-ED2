package armazenamento;

public class Dados<T extends Comparable<T>> implements Comparable <Dados<T>>{//Estrutura generica que estara contida no array
	private T value;

	public Dados(T chave) {
		this.value = chave;
	}

	@Override
	public int compareTo(Dados<T> objeto) {
		if(this.value instanceof String) {
			return((String) this.value).compareTo((String) objeto.getValue());
		} else if (this.value instanceof Integer) {
			return ((Integer) this.value).compareTo((Integer) objeto.getValue());
		} else {
			return ((Double) this.value).compareTo((Double) objeto.getValue());
		}
	}

	@Override
	public String toString() {
		return "Dados{" +
				"value=" + value +
				'}';
	}

	public T getValue() {
		return this.value;
	}


	public Object getValueType() {// Retorna o valor desta estrutura com seu tipo especificado
		if(this.value instanceof Integer) {
			return (Integer)this.value;
		} else if (this.value instanceof Double) {
			return (Double)this.value;
		} else {
			return (String)this.value;
		}
	}
}