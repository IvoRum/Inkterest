package com.ink.persstence.aggregation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Artist {
    @Id
    private Long id;
    @OneToMany
    private Set<Post> post;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
