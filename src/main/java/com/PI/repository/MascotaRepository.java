package com.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PI.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
