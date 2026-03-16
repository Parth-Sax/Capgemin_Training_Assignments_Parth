package com.capgi.repository;

import com.capgi.entity.Panda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PandaRepository extends JpaRepository<Panda,Integer> {
}
