package it.infobasic.gestioneutenti.services;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.infobasic.gestioneutenti.models.Utente;
import it.infobasic.gestioneutenti.repositories.UtenteRepository;

@Service
public class UtenteService {
    
    @Autowired
    private UtenteRepository utenteRepository;

    public Optional<Utente> findById(Long id) {
		return utenteRepository.findById(id);
	}

	public Optional<Utente> findByUsername(String username) {
		return utenteRepository.findByUsername(username);
	}

	public Page<Utente> findAll(Pageable pageable) {
		return utenteRepository.findAll(pageable);
	}

	public Utente save(Utente utente) {
        Utente newUtente = new Utente();
        newUtente.setUsername(utente.getUsername());
        newUtente.setPassword(utente.getPassword());
        newUtente.setEmail(utente.getEmail());
        newUtente.setDataNascita(utente.getDataNascita());
        if (utente.getDataRegistrazione() == null) {
            newUtente.setDataRegistrazione(LocalDate.now());   
        }
		return utenteRepository.save(newUtente);
	}

	public Utente update(Long id, Utente utente) {
		Optional<Utente> utenteResult = utenteRepository.findById(id);

		if (utenteResult.isPresent()) {
			Utente utenteUpdate = utenteResult.get();
			utenteUpdate.setUsername(utente.getUsername());
			utenteUpdate.setEmail(utente.getEmail());
			utenteUpdate.setPassword(utente.getPassword());
			utenteRepository.save(utenteUpdate);
			return utenteUpdate;
		} else {
			throw new GenericJDBCException("Utente non trovato.", null);
		}

	}

	public void delete(Long id) {
		utenteRepository.deleteById(id);
	}
}
