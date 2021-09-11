package com.devsuperior.dsvendas.service;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccesDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;


@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page <Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SalesSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccesDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
