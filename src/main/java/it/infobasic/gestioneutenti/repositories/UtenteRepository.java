package it.infobasic.gestioneutenti.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.infobasic.gestioneutenti.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Optional<Utente> findByUsername(String username);
}
