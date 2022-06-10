package ernadas_registracija_ugdymui;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UgdymoIstaigos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String pavadinimas;
	
	private String kodas;
	
	private String adresas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getKodas() {
		return kodas;
	}

	public void setKodas(String kodas) {
		this.kodas = kodas;
	}

	public String getAdresas() {
		return adresas;
	}

	public void setAdresas(String adresas) {
		this.adresas = adresas;
	}	
}
