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

import com.wave.keeper.wave_keeper.dto.RightsDto;
import com.wave.keeper.wave_keeper.service.RightsService;


@RestController
@CrossOrigin("*")
@RequestMapping("/rights")
public class RightController {

    @Autowired
    private RightsService rightsService;
   
    @GetMapping("/{id}")
    public RightsDto getRightsByIdRights(@RequestParam Long id) {
        return rightsService.getRights(id);
    }
    
    @PutMapping("/{id}")
    public RightsDto updateRights(@PathVariable Long id, @RequestBody RightsDto rights) {
        return rightsService.updateRight(id, rights);
        }

    @GetMapping("/all")
    public List<RightsDto> getAllRightses() {
        return rightsService.getAllRights();
    }

    @DeleteMapping("/{id}")
    public void deleteRights(@PathVariable Long id) {
        rightsService.deleteRight(id);
    }   


    @PostMapping
    public RightsDto saveRights(@RequestBody RightsDto rights) {
       return rightsService.saveRight(rights);
    }

    
}
