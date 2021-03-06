package edu.dat076.yep.models;

import javax.persistence.*;

/**
 * Class for representing a user.
 *
 * Created by marcus on 2016-02-18.
 */
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    protected User() {}

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
