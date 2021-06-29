package com.example.bukmekerskaya_kontora.entity;

import com.example.bukmekerskaya_kontora.enums.TeamStatus;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "team")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;


}
