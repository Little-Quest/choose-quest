package com.questing.littlequest.models;

import javax.persistence.*;

@Entity
@Table(name = "play")
public class Play {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="play-generator")

    public Long play_id;
    public Long user_id;
    public Long choice_id;
    public Long story_id;

    public Play() {
    }

    public Play(Long user_id, Long choice_id, Long story_id) {
        this.user_id = user_id;
        this.choice_id = choice_id;
        this.story_id = story_id;
    }
}
