package org.generation.es1.es1.db.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ruolo {

    // nome : String : VARCHAR
    // descrizione : String : VARCHAR

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String descrizione;

    @OneToMany(mappedBy = "ruolo")
    private List<Utente> utenti;

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Ruolo [\nid=" + id + ",\n nome=" + nome + ",\n descrizione=" + descrizione + "]";
    }

    

}
