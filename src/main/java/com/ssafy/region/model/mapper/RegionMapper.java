package com.ssafy.region.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.region.model.GugunDto;
import com.ssafy.region.model.RegionDto;
import com.ssafy.region.model.SearchDto;
import com.ssafy.region.model.SidoDto;

@Mapper
public interface RegionMapper {
	List<RegionDto> searchList(SearchDto searchDto);

	List<RegionDto> getHotPlaceList();

	List<SidoDto> getSidoList();

	List<GugunDto> getGugunList(int sido);

}
