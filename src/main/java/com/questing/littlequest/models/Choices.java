package com.questing.littlequest.models;

import javax.persistence.*;

@Entity
@Table(name = "story_choices")
public class Choices {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="choices-generator")

    public Long choice_id;
    public Long story_id;
    public Long previous_choice_id;
    public String choice_a_text;
    public String choice_b_text;
    public Long text_id;

    public Choices() {
    }

    public Choices(Long story_id, Long previous_choice_id, String choice_a_text, String choice_b_text, Long text_id) {
        this.story_id = story_id;
        this.previous_choice_id = previous_choice_id;
        this.choice_a_text = choice_a_text;
        this.choice_b_text = choice_b_text;
        this.text_id = text_id;
    }
}
