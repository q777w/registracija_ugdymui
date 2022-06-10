package ernadas_registracija_ugdymui;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@Autowired
	private UgdymoIstaigosRepository ugdymo_istaigos_repository;	

	@RequestMapping(path="/admin")	
	public String admin() throws IOException {

	
		return "admin";

	}	
	
	@RequestMapping(path="/admin-ugdymo-istaigos")	
	public String ugdymoIstaigos(Model model) throws IOException {
		
		model.addAttribute("ugdymo_istaigos", ugdymo_istaigos_repository.findAll());		
		
		return "ugdymo_istaigos";
	}
	
	@RequestMapping(path="/admin-ugdymo-istaigos-tvarkyti")	
	public String ugdymoIstaiguTvarkymas(

		@RequestParam(name="id", required=false, defaultValue="0") Integer id 
		, @RequestParam(name="pavadinimas", required=false, defaultValue="") String pavadinimas
		, @RequestParam(name="kodas", required=false, defaultValue="") String kodas
		, @RequestParam(name="adresas", required=false, defaultValue="") String adresas
		, @RequestParam(name="prideti", required=false, defaultValue="neprideti") String prideti
		, Model model) throws IOException {
	
		 UgdymoIstaigos ugdymo_istaigos = new UgdymoIstaigos();
	
			if ( prideti.equals( "prideti" ) ) {
		
				if (id > 0) {
			
					Optional <UgdymoIstaigos> found = ugdymo_istaigos_repository.findById( id );
			
					if ( found.isPresent() ) {
				
						ugdymo_istaigos = found.get();
						ugdymo_istaigos.setId(id);
					}
			
				}
		
				ugdymo_istaigos.setPavadinimas(pavadinimas);
				ugdymo_istaigos.setAdresas(adresas);
				ugdymo_istaigos.setKodas(kodas);
	
				ugdymo_istaigos_repository.save ( ugdymo_istaigos );
		}
	
		model.addAttribute("ugdymo_istaigos", ugdymo_istaigos_repository.findAll());		
	
		return "redirect:admin-ugdymo-istaigos";
	}	
	
}
