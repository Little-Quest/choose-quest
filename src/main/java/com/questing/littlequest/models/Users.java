package com.questing.littlequest.models;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    @SequenceGenerator(name = "user_id-generator")
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
        return "User ID " + this.user_id + " for user " + this.username + " has this passcode: "+ this.passhash;
    }

    public String getPasshash() {
        return this.passhash;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean checkPassword(String attempt) {
        boolean result = BCrypt.checkpw(attempt, this.passhash);
        return result;
    }
}
