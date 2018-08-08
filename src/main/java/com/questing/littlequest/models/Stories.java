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

    public Stories(Long prompt_id, String title) {
        this.prompt_id = prompt_id;
        this.title = title;
    }

    public String toString() {
        return this.title + " has prompt ID of " + this.prompt_id;

    }
}

