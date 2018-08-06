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
    public Long root_choice;
    public Long user_id;

    public Stories() {
    }

    public Stories(String title, Long root_choice, Long user_id) {
        this.title = title;
        this.root_choice = root_choice;
        this.user_id = user_id;
    }

    public String toString() {
        return this.title;
    }
}
