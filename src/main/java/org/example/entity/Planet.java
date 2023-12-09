package org.example.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> ticketsFrom = new HashSet<>();
    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> ticketsTo = new HashSet<>();


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Ticket> getTicketsFrom() {
        return ticketsFrom;
    }

    public Set<Ticket> getTicketsTo() {
        return ticketsTo;
    }
}
