package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.repository.RightsRepository;
import com.wave.keeper.wave_keeper.tables.Rights;

@Service
public class RightsService {
    
    private final RightsRepository rightsRepository;

    public RightsService(RightsRepository rightsRepository) {
        this.rightsRepository = rightsRepository;
    }

    public void  deleteRight(Long id) {
        rightsRepository.deleteById(id);
    }

    public Rights getRight(Long id) {
        return rightsRepository.findById(id).orElse(null);
    }

    public Rights saveRight(Rights right) {
        return rightsRepository.save(right);
    }

    public Rights updateRight(Rights right) {
        return rightsRepository.save(right);
    }

    public List<Rights> getAllRights() {
        return rightsRepository.findAll();
    }

}