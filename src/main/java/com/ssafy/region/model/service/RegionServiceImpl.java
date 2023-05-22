package com.ssafy.region.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.region.model.GugunDto;
import com.ssafy.region.model.RegionDto;
import com.ssafy.region.model.SearchDto;
import com.ssafy.region.model.SidoDto;
import com.ssafy.region.model.mapper.RegionMapper;

@Service
public class RegionServiceImpl implements RegionService {

	private RegionMapper regionMapper;
	public RegionServiceImpl(RegionMapper regionMapper) {
		this.regionMapper = regionMapper;
	}
	
	@Override
	public List<RegionDto> searchList(SearchDto searchDto) {
		// TODO Auto-generated method stub
		return regionMapper.searchList(searchDto);
	}
	@Override
	public List<RegionDto> getHotPlaceList() {
		// TODO Auto-generated method stub
		return regionMapper.getHotPlaceList();
	}

	@Override
	public List<SidoDto> getSidoList() {
		// TODO Auto-generated method stub
		return regionMapper.getSidoList();
	}

	@Override
	public List<GugunDto> getGugunList(int sido) {
		// TODO Auto-generated method stub
		return regionMapper.getGugunList(sido);
	}

}
