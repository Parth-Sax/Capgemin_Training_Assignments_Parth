package com.capgi.service.impl;

import com.capgi.entity.Panda;
import com.capgi.repository.PandaRepository;
import com.capgi.service.PandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PandaServiceImpl implements PandaService {

    private final PandaRepository pandaRepository;


    @Override
    public void save(Panda panda) {
        pandaRepository.save(panda);
    }

    @Override
    public void updatePanda(Integer id, Panda panda) {
        Optional<Panda> existing = pandaRepository.findById(id);
        if(existing.isPresent()) {
            Panda panda1 = existing.get();
            panda1.setName(panda.getName());
            panda1.setWeight(panda.getWeight());
            pandaRepository.save(panda1);
        }
    }

    @Override
    public List<Panda> findAll() {
        return pandaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        pandaRepository.deleteById(id);
    }

    @Override
    public Panda findById(Integer id) {
        Optional<Panda> panda = pandaRepository.findById(id);
        if(panda.isEmpty()) {
            System.out.println("No Panda");
        }
        return panda.get();
    }
}
