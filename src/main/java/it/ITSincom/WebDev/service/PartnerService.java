package it.ITSincom.WebDev.service;

import it.ITSincom.WebDev.persistance.model.Partner;
import it.ITSincom.WebDev.persistance.repository.PartnerRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    public List<Partner> getPartnersByName(String name) {
        return partnerRepository.findByName(name);
    }
}