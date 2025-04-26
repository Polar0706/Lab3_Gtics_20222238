package com.tele.lab3_gtics.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Integer edad;
    private String genero;
    private String diagnostico;
    private LocalDate fechaCita;
    private Integer numeroHabitacion;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}
