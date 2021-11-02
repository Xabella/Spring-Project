package com.practice.project.model;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "status")
public class StatusModel {
    @Id
    @GeneratedValue
    private long status_id;

    @NotBlank
    private String status_name;

    public StatusModel() {
    }

    public StatusModel(long status_id, String status_name) {
        this.status_id = status_id;
        this.status_name = status_name;
    }

    public long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(long status_id) {
        this.status_id = status_id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}
