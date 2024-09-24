package laeconBD;

public class Libro {

	private int id;
	private String titulo;
	private int paginas;
	private Autor autor;
	private Editorial editorial;
	
	public Libro(int id, String titulo, int paginas, Autor autor, Editorial editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.paginas = paginas;
		this.autor = autor;
		this.editorial = editorial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor.getNombre() + ", editorial=" + editorial.getNombre() + "]";
	}
	
	
	
	
}
