package com.questing.littlequest.models;

//Java library for use in table content/model
import javax.persistence.*;

//model for the prompt table to be leveraged by the JPA Respository of the same name
@Entity
@Table(name = "prompts")
public class Prompts {

    @Id
    @GeneratedValue
    @SequenceGenerator(name="prompt-id-generator")

    //all associated columns from the prompts table
    public Long prompt_id;
    public Long story_id;
    public String prompt_text;

    //SQL relationships from the prompt table to the story table
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "story_id", nullable = false, insertable = false, updatable = false)
    private Stories stories;

    //required default empty constructor, used when data isn't yet populated/DB isn't yet accessed
    //during compiling
    public Prompts() {
    }

    //primary constructor for content of data once DB is accessed/populated
    public Prompts(Long story_id, String prompt_text) {
        this.story_id = story_id;
        this.prompt_text = prompt_text;
    }

    //string method to make content of table easy to render via Thymeleaf templates using Springboot MVC
    public String toString() {
        return this.prompt_text;
    }
}