package com.questing.littlequest.models;

//Java library for use in table content/model
import javax.persistence.*;

    //model for the stories table to be leveraged by the JPA Respository of the same name
    @Entity
    @Table(name = "stories")
public class Stories {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="story-id-generator")

    //all associated columns from the stories table
    public Long story_id;
    public Long prompt_id;
    public String title;

    //required default empty constructor, used when data isn't yet populated/DB isn't yet accessed
    //during compiling
    public Stories() {
    }

    //primary constructor for content of data once DB is accessed/populated
    public Stories(Long prompt_id, String title) {
        this.prompt_id = prompt_id;
        this.title = title;
    }

    //string method to make content of table easy to render via Thymeleaf templates using Springboot MVC
    public String toString() {
    return this.title + " has prompt ID of " + this.prompt_id;
    }
}

