
public class Ebook extends Livro{
	public Ebook(Autor autor) {
		super(autor);
	}

	@Override
	public boolean aplicaDescontoDe(double porcentagem) {
		if (porcentagem > 0.15) {
		return false;
		}
		double desconto = this.getValor() * porcentagem;
		this.setValor(getValor()- desconto);
		return true;
		}
	
	private String waterMark;
	
	public String getWaterMark() {
		return waterMark;
	}
	public void setWaterMark(String waterMark) {
		this.waterMark = waterMark;
	}
}
