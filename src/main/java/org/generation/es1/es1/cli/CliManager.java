package org.generation.es1.es1.cli;

import java.util.List;
import java.util.Scanner;

import org.generation.es1.es1.db.entity.Ruolo;
import org.generation.es1.es1.db.entity.SubReddit;
import org.generation.es1.es1.db.entity.Utente;
import org.generation.es1.es1.db.service.RuoloService;
import org.generation.es1.es1.db.service.SubRedditService;
import org.generation.es1.es1.db.service.UtenteService;

public class CliManager {

    private Scanner sc;

    private RuoloService ruoloService;
    private UtenteService utenteService;
    private SubRedditService subRedditService;

    public CliManager(UtenteService utenteService, RuoloService ruoloService, SubRedditService subRedditService) {

        sc = new Scanner(System.in);

        this.utenteService = utenteService;
        this.ruoloService = ruoloService;
        this.subRedditService = subRedditService;

        printOptions();
    }

    private void printOptions() {

        System.out.println("");
        System.out.println("Operazioni");
        System.out.println("1. Leggi tutta la tabella");
        System.out.println("2. Inserisci nuovo record");
        System.out.println("3. Modifica record");
        System.out.println("4. Elimina record");
        System.out.println("5. Esci");
        System.out.println("");

        String strValue = sc.nextLine();
        int value = Integer.parseInt(strValue);

        switch (value) {
            case 1:
                readAll();
                break;

            case 2:
                insert();
                break;

            case 3:
                edit();
                break;

            case 4:
                delete();
                break;

            case 5:
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions();

    }

    private void readAll() {

        List<Utente> utenti = utenteService.findAll();
        System.out.println("Utenti");
        System.out.println(utenti);
        printSeparator();
    }

    private void insert() {

        Utente u = new Utente();

        save(u);
    }

    private void edit() {

        System.out.println("edit id");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u == null) {

            System.out.println("Utente non trovato");
            return;

        }

        save(u);
    }

    private void delete() {

        System.out.println("delete id");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u != null) {
            utenteService.delete(u);
            System.out.println("Utente " + strId + " eliminato");

        } else  
            System.out.println("Utente non trovato");
    }

    public void printSeparator() {
        System.out.println("-----------------------------");
    }

    private void save(Utente utente) {
        boolean isInsert = (utente.getId() == null);

        System.out.println("nome" + (isInsert
                ? ""
                : " (" + utente.getNome() + ")"));
        String nome = sc.nextLine();
        utente.setNome(nome);

        System.out.println("cognome" + (isInsert
                ? ""
                : " (" + utente.getCognome() + ")"));
        String cognome = sc.nextLine();
        utente.setCognome(cognome);

        System.out.println("username" + (isInsert
                ? ""
                : " (" + utente.getUsername() + ")"));
        String username = sc.nextLine();
        utente.setUsername(username);

        System.out.println("password" + (isInsert
                ? ""
                : " (" + utente.getPassword() + ")"));
        String password = sc.nextLine();
        utente.setPassword(password);

        System.out.println("credito" + (isInsert
                ? ""
                : " (" + utente.getCredito() + ")"));
        String strCredito = sc.nextLine();
        int credito = Integer.parseInt(strCredito);
        utente.setCredito(credito);

        List<Ruolo> ruoli = ruoloService.findAll();
        if (ruoli.size() > 0) {
            System.out.println("ruoli");
            ruoli.stream()
                    .map(p -> p.getId() + ". " + p.getNome() + " - " + p.getDescrizione())
                    .forEach(System.out::println);
            printSeparator();
            String ruoloIdStr = (utente.getRuolo() == null) ? "nessun ruolo" : "" + utente.getRuolo().getId();
            System.out.println("Ruolo id" + (isInsert
                    ? ""
                    : "(" + ruoloIdStr + ")"));
            String strRuoloId = sc.nextLine();
            Long ruoloId = Long.parseLong(strRuoloId);
            Ruolo ruolo = ruoloService.findById(ruoloId);
            utente.setRuolo(ruolo);
        } else
            System.out.println("Non ci sono ruoli disponibili");

            String hasSubreddit = "s";
            List<SubReddit> subReddits = subRedditService.findAll();
            while (hasSubreddit.equals("s")) {
                
                System.out.println("Ha un subreddit? (s/n)");
                hasSubreddit=sc.nextLine();

                if (!hasSubreddit.equals("s")) {
                    
                    utenteService.save(utente);
                    return;
                }

                System.out.println("subreddits");
                subReddits.stream()
                            .map(s -> s.getId() + ". " + s.getNome() + " " + s.getDescrizione())
                            .forEach(System.out::println);
                printSeparator();
                System.out.println("subreddit id");
                String strSubredditId = sc.nextLine();
                Long SubRedditId = Long.parseLong(strSubredditId);
                SubReddit subReddit = subRedditService.findById(SubRedditId);
                utente.addSubreddit(subReddit);
            }

    }

}
