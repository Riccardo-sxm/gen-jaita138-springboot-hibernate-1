package org.generation.es1.es1;

import java.util.List;

import org.generation.es1.es1.cli.CliManager;
import org.generation.es1.es1.db.entity.Utente;
import org.generation.es1.es1.db.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Es1Application implements CommandLineRunner {

	@Autowired
	private UtenteService utenteService;

	public static void main(String[] args) {
		SpringApplication.run(Es1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		new CliManager(utenteService);
		
	}

	private void test1() {

		System.out.println("Hello, World!");
		System.out.println("-------------------------");

		Utente u1 =new Utente();
		u1.setNome("nome2");
		u1.setCognome("cognome2");
		u1.setUsername("username2");
		u1.setPassword("psw2");
		u1.setCredito(15000);

		System.out.println("u1 prima del salvataggio");
		System.out.println(u1);
		
		utenteService.save(u1);

		System.out.println("u1 dopo il salvataggio");
		System.out.println(u1);
		System.out.println("-------------------------");

		List<Utente> utenti = utenteService.findAll();

		System.out.println("Lista utenti");
		System.out.println(utenti);
		System.out.println("-------------------------");

		System.out.println("-------------------------");
		System.out.println("The End");

	}

}
