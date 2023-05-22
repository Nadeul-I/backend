package com.ssafy.region.model.service;

import java.util.List;

import com.ssafy.region.model.GugunDto;
import com.ssafy.region.model.RegionDto;
import com.ssafy.region.model.SearchDto;
import com.ssafy.region.model.SidoDto;

public interface RegionService {

	List<RegionDto> searchList(SearchDto searchDto);

	List<RegionDto> getHotPlaceList();

	List<SidoDto> getSidoList();

	List<GugunDto> getGugunList(int sido);

}
