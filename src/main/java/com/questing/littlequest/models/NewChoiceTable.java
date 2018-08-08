package com.questing.littlequest.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
    @Table(name = "newchoicetable")
public class NewChoiceTable {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="choice-id-generator")

    public Long choice_id;
    public Long story_id;
    public Long prompt_id;
    public String choice_a_text;
    public String choice_b_text;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prompt_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private NewPromptTable newPromptTable;

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
