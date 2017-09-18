package learn.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import learn.spring.mybatis.domain.Festival;
import learn.spring.mybatis.mapper.FestivalMapper;

@Repository
public class FestivalRepository {
	@Autowired
	FestivalMapper festivalMapper;
	
	public Festival getFestival(Long festivalId) {
		return festivalMapper.getFestival(festivalId);
	}
}
