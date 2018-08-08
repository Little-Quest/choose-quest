package com.questing.littlequest.models;

import javax.persistence.*;

@Entity
@Table(name = "newprompttable")
public class NewPromptTable {

    @Id
    @GeneratedValue
    @SequenceGenerator(name="prompt-id-generator")

    public Long prompt_id;
    public String prompt_text;

    public NewPromptTable() {
    }

    public NewPromptTable(String prompt_text) {
        this.prompt_text = prompt_text;
    }

    public String toString() {
        return this.prompt_text;
    }
}