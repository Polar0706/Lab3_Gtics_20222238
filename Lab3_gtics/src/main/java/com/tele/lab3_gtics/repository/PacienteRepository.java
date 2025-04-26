package com.tele.lab3_gtics.repository;

import com.tele.lab3_gtics.entity.Doctor;
import com.tele.lab3_gtics.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> hallarPorHospitalId(Integer hospitalId);
    @Query("SELECT p FROM Paciente p WHERE p.doctor.id = :doctorId AND p.fechaCita > CURRENT_DATE")
    List<Paciente> encontrarProximasCitasByDoctorId(Integer doctorId);
}

