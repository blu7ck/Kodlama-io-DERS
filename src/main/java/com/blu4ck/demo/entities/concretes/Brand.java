package com.blu4ck.demo.entities.concretes;


import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.List;


@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {

    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
