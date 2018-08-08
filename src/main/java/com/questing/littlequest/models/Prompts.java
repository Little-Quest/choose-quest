package com.questing.littlequest.models;

import javax.persistence.*;

@Entity
@Table(name = "prompts")
public class Prompts {

    @Id
    @GeneratedValue
    @SequenceGenerator(name="prompt-id-generator")

    public Long prompt_id;
    public Long story_id;
    public String prompt_text;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "story_id", nullable = false)
    private Stories newStoryTable;

    public Prompts() {
    }

    public Prompts(Long story_id, String prompt_text) {
        this.story_id = story_id;
        this.prompt_text = prompt_text;
    }

    public String toString() {
        return this.prompt_text;
    }
}