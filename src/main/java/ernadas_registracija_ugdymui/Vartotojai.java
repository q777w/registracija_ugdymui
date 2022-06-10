package ernadas_registracija_ugdymui;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vartotojai {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String vardas;
	
	private String tipas;
	
	private String el_pastas;
	
	private String slaptazodis;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getTipas() {
		return tipas;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
	}

	public String getEl_pastas() {
		return el_pastas;
	}

	public void setEl_pastas(String el_pastas) {
		this.el_pastas = el_pastas;
	}

	public String getSlaptazodis() {
		return slaptazodis;
	}

	public void setSlaptazodis(String slaptazodis) {
		this.slaptazodis = slaptazodis;
	}
	
	
}
