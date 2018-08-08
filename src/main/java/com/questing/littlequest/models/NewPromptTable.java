package com.questing.littlequest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "newprompttable")
public class NewPromptTable {

    @Id
    @GeneratedValue
    @SequenceGenerator(name="prompt-id-generator")

    public Long prompt_id;
    public Long story_id;
    public String prompt_text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "story_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private NewStoryTable newStoryTable;

    public NewPromptTable() {
    }

    public NewPromptTable(Long story_id, String prompt_text) {
        this.story_id = story_id;
        this.prompt_text = prompt_text;
    }

    public String toString() {
        return this.prompt_text;
    }
}