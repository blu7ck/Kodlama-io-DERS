package com.blu4ck.demo.dataAccess;


import jakarta.persistence.*;
import lombok.*;


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

}
