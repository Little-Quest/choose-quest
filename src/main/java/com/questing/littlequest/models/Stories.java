package com.questing.littlequest.models;

import javax.persistence.*;

@Entity
@Table(name = "stories")
public class Stories {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="stories-generator")

    public Long story_id;
    public String title;
    public String root_text;
    public Long user_id;

    public Stories() {
    }

    public Stories(String title, String root_text, Long user_id) {
        this.title = title;
        this.root_text = root_text;
        this.user_id = user_id;
    }

    public String toString() {
        return this.title;
    }
}
