package com.questing.littlequest.models;

import javax.persistence.*;

@Entity
@Table(name = "content")

public class Content {
    @Id
    @GeneratedValue
    @SequenceGenerator(name="content-generator")

    public Long text_id;
    public String text;

    public Content() {
    }

    public Content(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
