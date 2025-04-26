package com.tele.lab3_gtics.repository;

import com.tele.lab3_gtics.entity.Doctor;
import com.tele.lab3_gtics.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> hallarPorHospitalId(Integer hospitalId);
}
