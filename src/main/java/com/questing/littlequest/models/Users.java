package com.questing.littlequest.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    @SequenceGenerator(name = "users-generator")
    public Long user_id;
    public String username;
    public String passhash;

    //required default constructor
    public Users() {
    }

    public Users(String username, String passhash) {
        this.username = username;
        this.passhash = passhash;
    }

    public String toString() {
        return this.username;
    }

}
