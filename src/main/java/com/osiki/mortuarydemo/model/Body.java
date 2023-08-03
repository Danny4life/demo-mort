package com.osiki.mortuarydemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "body")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String fileNumber;
    private String causeOfDeath;

    public Body() {

    }

    public Body(Long id, String fileNumber, String causeOfDeath) {
        this.id = id;
        this.fileNumber = fileNumber;
        this.causeOfDeath = causeOfDeath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }
}
