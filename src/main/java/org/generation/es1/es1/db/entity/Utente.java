package org.generation.es1.es1.db.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nome : String : VARCHAR(64)
    //cognome : String : VARCHAR(64)
    //username : String : VARCHAR(128)
    //password : String : VARCHAR(64)
    //credito : Int : Int (il valore deve essere espresso in centesimi di euro)

    @Column(length = 64)
    private String nome;

    @Column(length = 64)
    private String cognome;

    @Column(length = 128)
    private String username;

    @Column(length = 64)
    private String password;

    private int credito;

    @ManyToOne
    private Ruolo ruolo;

    @ManyToMany
    private List<SubReddit> subReddits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public List<SubReddit> getSubReddits() {
        return subReddits;
    }

    public void setSubReddits(List<SubReddit> subReddits) {
        this.subReddits = subReddits;
    }

    public void addSubreddit(SubReddit subReddit) {

        if (this.subReddits == null) 
            
            this.subReddits = new ArrayList<>();

        this.subReddits.add(subReddit);
        
    }

    @Override
    public String toString() {
        return "Utente [\nid=" + id + ",\n nome=" + nome + ",\n cognome=" + cognome + ",\n username=" + username + ",\n password="
                + password + ",\n credito=" + credito + ",\n ruolo=" + ruolo + "]";
    }

    

    

}
