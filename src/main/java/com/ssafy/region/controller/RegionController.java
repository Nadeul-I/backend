package com.ssafy.region.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.controller.BoardController;
import com.ssafy.region.model.GugunDto;
import com.ssafy.region.model.RegionDto;
import com.ssafy.region.model.SearchDto;
import com.ssafy.region.model.SidoDto;
import com.ssafy.region.model.service.RegionService;

@RestController
@RequestMapping("/region")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class RegionController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    
    private RegionService regionService;
    
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }
    
    @RequestMapping(value="/search/{sidoCode}/{gugunCode}/{category}/{keyword}/", method=RequestMethod.GET, headers= {"Content-type=application/json"})
    public @ResponseBody ResponseEntity<List<RegionDto>> searchList(@PathVariable int sidoCode, @PathVariable int gugunCode, @PathVariable int category, @PathVariable String keyword){
        logger.info("관광지 검색");
        return new ResponseEntity<List<RegionDto>>(regionService.searchList(new SearchDto(sidoCode, gugunCode, category, keyword)), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<SidoDto>> getSido() {
        logger.info("sido호출");
        return new ResponseEntity<List<SidoDto>>(regionService.getSidoList(), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/search/{sido}")
    public ResponseEntity<List<GugunDto>> getGugun(@PathVariable int sido) {
        logger.info("sido - gugun 호출");
        return new ResponseEntity<List<GugunDto>>(regionService.getGugunList(sido), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/hotplace")
    public ResponseEntity<List<RegionDto>> getHotPlaceList(){
        logger.info("home - hotplace list 호출");
        return new ResponseEntity<List<RegionDto>>(regionService.getHotPlaceList(), HttpStatus.ACCEPTED);
    }
}
