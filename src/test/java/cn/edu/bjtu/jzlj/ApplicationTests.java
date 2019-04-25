package cn.edu.bjtu.jzlj;


import cn.edu.bjtu.jzlj.domain.CarCarryInfo;
import cn.edu.bjtu.jzlj.service.CarCarryInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//	@Autowired
//	DataSource dataSource;

//	@Test
//	public void contextLoads() throws SQLException {
//		System.out.println(dataSource.getClass());
//
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		connection.close();
//	}

    @Autowired
    CarCarryInfoService carCarryInfoService;

    @Test
    public void list() {
        List<CarCarryInfo> carCarryInfos = carCarryInfoService.selectList(null);
        System.out.println(carCarryInfos);
        ;
    }

//	@Autowired
//	private JwtPayload audience;
//
//	@Test
//	public void test(){
//		System.out.println(audience);
//	}
}
