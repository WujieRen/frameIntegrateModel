import com.ssm.demo.model.User;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by renwujie on 2018/05/17 at 16:36
 */
public class TestSSM {
    private SqlSessionTemplate sqlSessionTemplate;

    @Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Test
    public void test() {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        sqlSessionTemplate = factory.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
        //List<User> list =  sqlSessionTemplate.selectList(User.class.getName()+".getUserList");
        //List<User> list =  sqlSessionTemplate.selectList("com.ssm.demo.model.User.getUserList");
        /*基于Mapper接口的方式*/
        List<User> list =  sqlSessionTemplate.selectList("com.ssm.demo.mapper.UserMapper.getUserList");
        System.out.println(list);
    }
}
