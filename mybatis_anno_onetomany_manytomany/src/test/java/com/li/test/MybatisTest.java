package com.li.test;

import com.li.dao.IUserDao;
import com.li.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private InputStream in = null;
    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    private IUserDao userDao = null;

    @Before
    public void init() throws IOException {
        //1.获取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SplSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.生产Sqlsession对象
        sqlSession = factory.openSession();
        //4.创建代理dao对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        in.close();
    }

    /**
     * 查询所有
     */
    @Test
    public void findAllTest(){
        List<User> userList = userDao.findAll();
        userList.forEach(user -> {
            System.out.println("--------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        });
    }

}
