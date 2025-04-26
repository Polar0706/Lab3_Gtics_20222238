package com.tele.lab3_gtics.controller;

import com.tele.lab3_gtics.entity.Doctor;
import com.tele.lab3_gtics.entity.Hospital;
import com.tele.lab3_gtics.entity.Paciente;
import com.tele.lab3_gtics.repository.DoctorRepository;
import com.tele.lab3_gtics.repository.HospitalRepository;
import com.tele.lab3_gtics.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospitales")
public class HospitalController {
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public HospitalController(HospitalRepository hospitalRepository,
                              DoctorRepository doctorRepository,
                              PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public String listarHospitales(Model model) {
        model.addAttribute("listaHospitales", hospitalRepository.findAll());
        return "hospital/list";
    }

    @GetMapping("/doctores/{id}")
    public String listarDoctores(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listaDoctores", doctorRepository.hallarPorHospitalId(id));
        return "hospital/doctores";
    }

    @GetMapping("/pacientes/{id}")
    public String listarPacientes(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listaPacientes", pacienteRepository.hallarPorHospitalId(id));
        return "hospital/pacientes";
    }
}
