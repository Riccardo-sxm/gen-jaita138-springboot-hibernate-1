package org.generation.es1.es1;

import java.util.List;

import org.generation.es1.es1.cli.CliManager;
import org.generation.es1.es1.db.entity.Utente;
import org.generation.es1.es1.db.service.RuoloService;
import org.generation.es1.es1.db.service.SubRedditService;
import org.generation.es1.es1.db.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Es1Application implements CommandLineRunner {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RuoloService ruoloService;

	@Autowired
	private SubRedditService subRedditService;

	public static void main(String[] args) {
		SpringApplication.run(Es1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//test1();
		new CliManager(utenteService, ruoloService, subRedditService);
		
	}

	private void test1() {

		System.out.println("Hello, World!");
		printSeparator();

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
		printSeparator();

		List<Utente> utenti = utenteService.findAll();

		System.out.println("Lista utenti");
		System.out.println(utenti);
		printSeparator();

		Utente u2 = utenteService.findById(1L);

		System.out.println("Utente con id 1");
		System.out.println(u2);
		printSeparator();

		utenteService.delete(u2);

		System.out.println("The End");

	}

	public void printSeparator() {
		System.out.println("-----------------------------");
	}



}
