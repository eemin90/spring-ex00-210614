package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleRestController {

	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	// p361
	@GetMapping(value="/getSample", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	// p363
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		
		List<SampleVO> list = new ArrayList<>();
		
		for (int i = 1; i < 10; i++) {
			list.add(new SampleVO(i, i + "First", i + " Last"));
		}
		
		return list;
		
//		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + " Last")).collect(Collectors.toList()); 
	}
	
	// p364
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap() {
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
}
