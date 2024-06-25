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

    
    public Rights updateRight(Long id, Rights rightsDetails) {
        Rights rightsToUpdate = rightsRepository.findById(id).orElse(null);
        rightsToUpdate.setEntidade(rightsDetails.getEntidade());
        rightsToUpdate.setVendedor(rightsDetails.getVendedor());
        rightsToUpdate.setDateStart(rightsDetails.getDateStart());
        rightsToUpdate.setDateOver(rightsDetails.getDateOver());
        return rightsRepository.save(rightsToUpdate);
    }

    public List<Rights> getAllRights() {
        return rightsRepository.findAll();
    }

}