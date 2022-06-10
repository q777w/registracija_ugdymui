package ernadas_registracija_ugdymui;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PagesController {

	@Autowired
	private VartotojaiRepository vartotojai_repository;
	
	@RequestMapping(path="/")	
	public String pradinis() throws IOException {

	
		return "pradinis";

	}
	
	@RequestMapping(path="/registruoti", method={ RequestMethod.GET, RequestMethod.POST })
	public String registruoti(
			@RequestParam(name="vardas", required=false, defaultValue="") String vardas
			, @RequestParam(name="el_pastas", required=false, defaultValue="") String el_pastas
			, @RequestParam(name="slaptazodis", required=false, defaultValue="") String slaptazodis
			, @RequestParam(name="registruotis", required=false, defaultValue="nesiregistruoti") String registruotis
			, Model model
		) throws IOException {
		
		Vartotojai vartotojas = new Vartotojai();
		
		String rezultatas = "";
		
		System.out.println (vardas);
		System.out.println (registruotis);
		
		if ( registruotis.equals( "Registruotis" ) ) {
			
				Optional <Vartotojai> found = vartotojai_repository.findByVardas( vardas );
				
				if ( ! found.isPresent() ) {
					
					vartotojas.setVardas(vardas);
					vartotojas.setEl_pastas(el_pastas);
					vartotojas.setSlaptazodis(slaptazodis);
					vartotojas.setTipas("user");
					vartotojai_repository.save ( vartotojas );
					
					rezultatas = "Registracija sėkminga";
				
				} else {
					
					rezultatas = "Toks varotojas jau yra";
				}
		}
		model.addAttribute("rezultatas", rezultatas );
	
		return "registracija";
	}	
	
	@RequestMapping(path="/registracija", method={ RequestMethod.GET, RequestMethod.POST })
	public String registracija(

		) throws IOException {
	
		return "registracija";
	}		
}

