package com.questing.littlequest.models;

import javax.persistence.*;

    @Entity
    @Table(name = "newstorytable")
public class NewStoryTable {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="prompt-id-generator")

    public Long prompt_id;
    public Long story_id;
    public String title;

    public NewStoryTable() {
    }

    public NewStoryTable(Long story_id, String title) {
        this.title = title;
        this.story_id = story_id;
    }

    public String toString() {
        return this.title;
    }
}

