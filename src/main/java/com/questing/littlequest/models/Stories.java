package com.questing.littlequest.models;

import javax.persistence.*;

    @Entity
    @Table(name = "stories")
public class Stories {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="story-id-generator")

    public Long story_id;
    public Long prompt_id;
    public String title;

    public Stories() {
    }

    public Stories(Long story_id, String title) {
        this.title = title;
        this.story_id = story_id;
    }

    public String toString() {
        return this.title;
    }
}

