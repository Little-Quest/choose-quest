package com.questing.littlequest.models;


import javax.persistence.*;

@Entity
@Table(name = "storytable-steve")
public class StorySteve {

    @Id
    @GeneratedValue
    @SequenceGenerator(name="story-steve-id-generator")

    public Long steve_story_id;
    public Long text_id;

    public StorySteve(){}

    public StorySteve(Long text_id){
        this.text_id = text_id;
    }


}
