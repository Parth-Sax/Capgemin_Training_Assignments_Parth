package com.capgi.controller;

import com.capgi.entity.Panda;
import com.capgi.service.PandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panda")
@RequiredArgsConstructor
public class PandaController {

    private final PandaService pandaService;

    @PostMapping("/save")
    public String savePanda(@RequestBody Panda panda){
        pandaService.save(panda);
        return "Panda saved in DB!!!";
    }

    @PutMapping("/update/{id}")
    public String updatePanda(@PathVariable Integer id, @RequestBody Panda panda) {
        pandaService.updatePanda(id, panda);
        return "Panda updated";
    }

    @GetMapping("/findAll")
    public List<Panda> findAll() {
        return pandaService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        pandaService.deleteById(id);
        return "panda with id : " + id + " is deleted";
    }

    @GetMapping("/findById/{id}")
    public Panda findById (@PathVariable Integer id) {
        return pandaService.findById(id);
    }
}
