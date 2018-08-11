package com.questing.littlequest.models;

//Java library for user password encryption
import org.mindrot.jbcrypt.BCrypt;

//Java library for use in table content/model
import javax.persistence.*;

//model for the stories table to be leveraged by the JPA Respository of the same name
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    @SequenceGenerator(name = "user_id-generator")

    //all associated columns from the stories table
    public Long user_id;
    public String username;
    public String passhash;

    //required default constructor
    public Users() {
    }

    //primary constructor for content of data once DB is accessed/populated
    public Users(String username, String passhash) {
        this.username = username;
        this.passhash = passhash;
    }

    //string method to make content of table easy to render
    // in IntellJ console for testing/logging
    public String toString() {
        return "User ID " + this.user_id + " for user " + this.username + " has this passcode: "+ this.passhash;
    }

    //string method to make content of table easy to render
    // in IntellJ console for testing/logging
    //as well as logging in/checking password
    public String getPasshash() {
        return this.passhash;
    }

    //string method to make content of table easy to render
    // in IntellJ console for testing/logging
    //as well as logging in/checking username/creating user
    public String getUsername() {
        return this.username;
    }

    //method to see if the password supplied matches password for
    //user in User Table in application DB
    public boolean checkPassword(String attempt) {
        boolean result = BCrypt.checkpw(attempt, this.passhash);
        return result;
    }

    //method to remove user from User Table
    public void deleteUser(String username) {
        username = null;
    }
}
