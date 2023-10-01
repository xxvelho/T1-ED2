package armazenamento;

public class Dados<T extends Comparable<T>> implements Comparable <Dados<T>>{//Estrutura generica que estara contida no array
	private T value;

	public Dados(T chave) {
		this.value = chave;
	}

	public T getValue() {
		return value;
	}

	@Override
	public int compareTo(Dados<T> other) {
		return this.value.compareTo(other.getValue());
	}

	@Override
	public String toString() {
		return "" + value;
	}
}