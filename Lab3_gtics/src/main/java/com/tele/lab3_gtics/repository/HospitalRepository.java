package com.tele.lab3_gtics.repository;

import com.tele.lab3_gtics.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
