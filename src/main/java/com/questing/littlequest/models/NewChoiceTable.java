package com.questing.littlequest.models;


import javax.persistence.*;

    @Entity
    @Table(name = "choicetable-new")
public class NewChoiceTable {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="choice-id-generator")

    public Long choice_id;
    public Long story_id;
    public Long prompt_id;
    public String choice_a_text;
    public String choice_b_text;

    public NewChoiceTable() {
    }

    public NewChoiceTable(Long story_id, Long prompt_id, String choice_a_text, String choice_b_text) {
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
