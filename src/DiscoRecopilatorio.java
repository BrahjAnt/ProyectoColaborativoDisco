import java.util.Arrays;

public class DiscoRecopilatorio {

	private String titulo;
	private int codigo;
	private Disco[]	disco;
	/**
	 * 
	 */
	public DiscoRecopilatorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param titulo
	 * @param codigo
	 * @param disco
	 */
	public DiscoRecopilatorio(String titulo, int codigo, Disco[] disco) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.disco = disco;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Disco[] getDisco() {
		return disco;
	}
	public void setDisco(Disco[] disco) {
		this.disco = disco;
	}
	@Override
	public String toString() {
		return "DiscoRecopilatorio [titulo=" + titulo + ", codigo=" + codigo + ", disco=" + Arrays.toString(disco)
				+ "]";
	}
	public void show() {
		System.out.println("El titulo del disco es: "+this.titulo);
		System.out.println("El codigo del disco es: "+this.codigo);
		System.out.println("El disco contiene estos discos: ");
		for(int i=0;i<disco.length;i++) {
			System.out.print(1+"-"+this.disco[i]);
			System.out.println();
		}
	}
	
	
}
