package com.questing.littlequest.models;


import javax.persistence.*;

@Entity
    @Table(name = "choices")
public class Choices {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="choice-id-generator")

    public Long choice_id;
    public Long story_id;
    public Long prompt_id;
    public String choice_a_text;
    public String choice_b_text;



//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prompt_id", nullable = false)
    private Prompts newPromptTable;

    public Choices() {
    }

    public Choices(Long story_id, Long prompt_id, String choice_a_text, String choice_b_text) {
        this.story_id = story_id;
        this.prompt_id = prompt_id;
        this.choice_a_text = choice_a_text;
        this.choice_b_text = choice_b_text;
    }

    public String toString() {
        String choices = "Choice A: " + this.choice_a_text + "\n" +
                "Choice B: " + this.choice_b_text;
        return choices;
    }
}
