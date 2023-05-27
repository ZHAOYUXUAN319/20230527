package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Buken;
import com.example.demo.obj.BukenDto;
import com.example.demo.repository.BukenRepository;

@Service
public class BukenService {

	// 物件一覧
	@Autowired
	private BukenRepository bukenRepository;

	public List<BukenDto> searchAll() {
		List<Buken> bukenList = bukenRepository.findAll(Sort.by(Order.asc("propertyId")));
		List<BukenDto> bukenDtoList = new ArrayList<>();

		for (Buken buken : bukenList) {
			BukenDto bukenDto = convertToDto(buken);
			bukenDtoList.add(bukenDto);
		}

		return bukenDtoList;
	}

	private BukenDto convertToDto(Buken buken) {
		Long id = buken.getPropertyId();
		String name = buken.getPropertyName();
		String address = buken.getAddress();
		String propertyType = buken.getPropertyType();
		String propertyArea = buken.getPropertyArea();
		String price = buken.getPrice();
		String syozokuCompanyId = buken.getSyozokuCompanyId();
		String status = buken.getStatus();

		return new BukenDto(id, name, address, propertyType, propertyArea, price, syozokuCompanyId, status);
	}

	// 新規の保存

	public Buken saveBuken(Buken buken) {
		// BukenRepository を使って、DBに保存する
		return bukenRepository.save(buken);
	}
	
	//検索
	
	public List<BukenDto> searchById(Long propertyId) {
	    List<Buken> bukenList;
	    
	    if (propertyId != null) {
	        bukenList = bukenRepository.findByPropertyId(propertyId);
	    } else {
	        bukenList = bukenRepository.findAll(Sort.by(Order.asc("propertyId")));
	    }

	    List<BukenDto> bukenDtoList = new ArrayList<>();
	    for (Buken buken : bukenList) {
	        BukenDto bukenDto = convertToDto(buken);
	        bukenDtoList.add(bukenDto);
	    }

	    return bukenDtoList;
	}
	//削除
	 public void deleteBuken(Long id) {
	        bukenRepository.deleteById(id);
	    }
	 
	 //編集
	 public void updateBuken(BukenDto bukenDto) {
		    Long propertyId = bukenDto.getPropertyId();
		    Optional<Buken> optionalBuken = bukenRepository.findById(propertyId);
		    if (optionalBuken.isPresent()) {
		        Buken buken = optionalBuken.get();
		        // 更新Buken对象的属性
		        buken.setPropertyName(bukenDto.getPropertyName());
		        buken.setAddress(bukenDto.getAddress());
		        buken.setPropertyType(bukenDto.getPropertyType());
		        buken.setPropertyArea(bukenDto.getPropertyArea());
		        buken.setPrice(bukenDto.getPrice());
		        buken.setSyozokuCompanyId(bukenDto.getSyozokuCompanyId());
		        buken.setStatus(bukenDto.getStatus());

		        bukenRepository.save(buken);
		    } else {
		        throw new NotFoundException("Buken not found with ID: " + propertyId);
		    }
		}

	 public BukenDto searchById1(Long propertyId) {
	        Optional<Buken> optionalBuken = bukenRepository.findById(propertyId);
	        if (optionalBuken.isPresent()) {
	            Buken buken = optionalBuken.get();
	            return convertToDto(buken);
	        } else {
	            throw new NotFoundException("Buken not found with ID: " + propertyId);
	        }
	    }
	 
	 
	 public BukenDto getBukenById(Long propertyId) {
		    Optional<Buken> optionalBuken = bukenRepository.findById(propertyId);
		    if (optionalBuken.isPresent()) {
		        Buken buken = optionalBuken.get();
		        return convertToDto(buken);
		    } else {
		        throw new NotFoundException("Buken not found with ID: " + propertyId);
		    }
		}

}
