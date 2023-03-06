package it.infobasic.gestioneutenti.utils;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.infobasic.gestioneutenti.models.Utente;
import it.infobasic.gestioneutenti.repositories.UtenteRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {
        Utente utente1 = new Utente();
        utente1.setUsername("Pincopallino");
        utente1.setPassword("password");
        utente1.setEmail("pincopallinooo@gmail.com");
        utente1.setDataNascita(LocalDate.of(2002, 9, 13));
        utente1.setDataRegistrazione(LocalDate.now());
        utenteRepository.save(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("Manuele");
        utente2.setPassword("12345678");
        utente2.setEmail("manueeee@gmail.com");
        utente2.setDataNascita(LocalDate.of(2001, 8, 19));
        utente2.setDataRegistrazione(LocalDate.now());
        utenteRepository.save(utente2);
    }
    
}
