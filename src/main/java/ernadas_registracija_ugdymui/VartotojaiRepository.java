package ernadas_registracija_ugdymui;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VartotojaiRepository extends CrudRepository<Vartotojai, Integer> {

	Optional<Vartotojai> findByVardas(String vardas);

}

