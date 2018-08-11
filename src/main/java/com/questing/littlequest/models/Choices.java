package com.questing.littlequest.models;

//Java library for use in table content/model
import javax.persistence.*;

//model for the story choices table to be leveraged by the JPA Respository of the same name
@Entity
    @Table(name = "choices")
public class Choices {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="choice-id-generator")

    //all associated columns from the story choices table
    public Long choice_id;
    public Long story_id;
    public Long prompt_id;
    public String choice_a_text;
    public String choice_b_text;
    public Long choice_a_id;
    public Long choice_b_id;

    //SQL relationships from the story choices table to the prompt table
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prompt_id", nullable = false, insertable = false, updatable = false)
    private Prompts prompts;

    //required default empty constructor, used when data isn't yet populated/DB isn't yet accessed
    //during compiling
    public Choices() {
    }

    //primary constructor for content of data once DB is accessed/populated
    public Choices(Long story_id, Long prompt_id, String choice_a_text, String choice_b_text, Long choice_a_id, Long choice_b_id) {
        this.story_id = story_id;
        this.prompt_id = prompt_id;
        this.choice_a_text = choice_a_text;
        this.choice_b_text = choice_b_text;
        this.choice_a_id = choice_a_id;
        this.choice_b_id = choice_b_id;
    }

    //string method to make content of table easy to render via Thymeleaf templates using Springboot MVC
    public String toString() {
        String choices = "Choice A: " + this.choice_a_text + "\n" +
                "Choice B: " + this.choice_b_text;
        return choices;
    }
}
