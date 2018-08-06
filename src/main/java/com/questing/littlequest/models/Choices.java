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
    public Long choice_a_id;
    public Long choice_b_id;
    public Long text_id;

    public Choices() {
    }

    public Choices(Long story_id, Long previous_choice_id, Long choice_a_id, Long choice_b_id, Long text_id) {
        this.story_id = story_id;
        this.previous_choice_id = previous_choice_id;
        this.choice_a_id = choice_a_id;
        this.choice_b_id = choice_b_id;
        this.text_id = text_id;
    }
}
