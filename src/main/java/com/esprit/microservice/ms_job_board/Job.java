package com.esprit.microservice.ms_job_board;


import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue
    private  int id;

    @NonNull
    private String service;

    @NonNull
    private boolean etat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
