package learn.spring.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import learn.spring.mybatis.domain.Festival;

public interface FestivalMapper {
	@Select(value="select * from festival.festival where id=#{festivalId}")
	Festival getFestival(@Param("festivalId") Long festivalId);

}
