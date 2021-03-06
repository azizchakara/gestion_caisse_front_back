package app.neotech.gestion.de.caisse.responses;

public class ProductResponse {

	private String nomProduit;
	private double quantité;
	private double prix;
	private double stock;
	private String codeBar;
	
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public double getQuantité() {
		return quantité;
	}
	public void setQuantité(double quantité) {
		this.quantité = quantité;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public String getCodeBar() {
		return codeBar;
	}
	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}
	
	
}
