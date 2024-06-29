package com.wave.keeper.wave_keeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wave.keeper.wave_keeper.dto.RightsDto;
import com.wave.keeper.wave_keeper.repository.RightsRepository;
import com.wave.keeper.wave_keeper.tables.Rights;

@Service
public class RightsService {
    
    private final RightsRepository rightsRepository;

    public RightsService(RightsRepository rightsRepository) {
        this.rightsRepository = rightsRepository;
    }

    public void  deleteRight(Long id) {
        Rights rightsDb = rightsRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Direitos não encontrados para ID: " + id));
        rightsRepository.delete(rightsDb);
    }

    public RightsDto getRights(Long id) {
        Rights rights = rightsRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Direitos não encontrados para ID: " + id));
        return new RightsDto(rights.getId(), rights.getEntidade(), rights.getVendedor(), rights.getDateStart(), rights.getDateOver(),rights.getPrice());
    }

    public RightsDto saveRight(RightsDto right) {
        Rights rights = new Rights();
        rights.setEntidade(right.entidade());
        rights.setVendedor(right.vendedor());
        rights.setDateStart(right.dateStart());
        rights.setDateOver(right.dateOver());
        rights.setPrice(right.price());
        Rights rightsDb = rightsRepository.save(rights);
        return new RightsDto(rightsDb.getId(), rightsDb.getEntidade(), rightsDb.getVendedor(), rightsDb.getDateStart(), rightsDb.getDateOver(), rightsDb.getPrice());
    }

    
    public RightsDto updateRight(Long id, RightsDto rightsDetails) {
        Rights rights = rightsRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Direitos não encontrados para ID: " + id));
        rights.setEntidade(rightsDetails.entidade());
        rights.setVendedor(rightsDetails.vendedor());
        rights.setDateStart(rightsDetails.dateStart());
        rights.setDateOver(rightsDetails.dateOver());
        rights.setPrice(rightsDetails.price());
        Rights rightsDb = rightsRepository.save(rights);
        return new RightsDto(rightsDb.getId(), rightsDb.getEntidade(), rightsDb.getVendedor(), rightsDb.getDateStart(), rightsDb.getDateOver(), rightsDb.getPrice());
    }

    public List<RightsDto> getAllRights() {
        return rightsRepository.findAll().stream()
        .map(rights -> new RightsDto(rights.getId(), rights.getEntidade(), rights.getVendedor(), rights.getDateStart(), rights.getDateOver(), rights.getPrice())).toList();
    }

}