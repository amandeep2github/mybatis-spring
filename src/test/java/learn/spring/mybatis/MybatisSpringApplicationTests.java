package learn.spring.mybatis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import learn.spring.mybatis.domain.Festival;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:/jdbc.properties")
@SqlConfig(dataSource="dataSource")
@Sql("file:./src/test/resources/scripts/cleanup/schema.festival.sql")
@Sql("file:./src/test/resources/scripts/schema/schema.festival.sql")
@Sql("file:./src/test/resources/scripts/schema/table.festival.sql")
@Sql("file:./src/test/resources/scripts/data/insert.festival.sql")
public class MybatisSpringApplicationTests {
	
	@Autowired
	FestivalRepository festivalRepo;

	@Test
	public void contextLoads() {
		Festival festival = festivalRepo.getFestival(1l);
		assertEquals("Tech Week", festival.getName());
	}

}
