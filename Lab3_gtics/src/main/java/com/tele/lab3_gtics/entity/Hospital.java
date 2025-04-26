package com.tele.lab3_gtics.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctores;

    @OneToMany(mappedBy = "hospital")
    private List<Paciente> pacientes;

}
