package com.tele.lab3_gtics.controller;

import com.tele.lab3_gtics.entity.*;
import com.tele.lab3_gtics.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctores")
public class DoctorController {
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public DoctorController(DoctorRepository doctorRepository,
                            PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public String listarDoctores(Model model) {
        model.addAttribute("listaDoctores", doctorRepository.findAll());
        return "doctor/list";
    }

    @GetMapping("/proximascitas/{id}")
    public String listarProximasCitas(@PathVariable("id") Integer id, Model model) {
        List<Paciente> listaPacientes = pacienteRepository.encontrarProximasCitasByDoctorId(id);
        model.addAttribute("listaPacientes", listaPacientes);
        return "doctor/proxcita";
    }
}
