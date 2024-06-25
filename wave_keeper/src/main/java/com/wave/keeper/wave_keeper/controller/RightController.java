package com.wave.keeper.wave_keeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wave.keeper.wave_keeper.service.RightsService;
import com.wave.keeper.wave_keeper.tables.Rights;


@RestController
@CrossOrigin("*")
@RequestMapping("/right")
public class RightController {

    @Autowired
    private RightsService rightsService;
   
    @GetMapping("/{id}")
    public Rights getRightsByIdRights(@RequestParam Long id) {
        return rightsService.getRight(id);
    }
    
    @PutMapping("/{id}")
    public Rights updateRights(@PathVariable Long id, @RequestBody Rights Rights) {
        return rightsService.updateRight(id, Rights);
        }

    @GetMapping("/all")
    public List<Rights> getAllRightses() {
        return rightsService.getAllRights();
    }

    @DeleteMapping("/{id}")
    public void deleteRights(@PathVariable Long id) {
        rightsService.deleteRight(id);
    }   


    @PostMapping
    public Rights saveRights(@RequestBody Rights Rights) {
        return rightsService.saveRight(Rights);
    }

    
}
