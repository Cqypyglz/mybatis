package com.li.test;

import com.li.dao.IRoleDao;
import com.li.domain.Role;
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

public class RoleTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession session;
    IRoleDao roleDao;
    @Before
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
         in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        factory=new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        session = factory.openSession();
        //4.获取dao的代理对象
        roleDao=session.getMapper(IRoleDao.class);
    }
    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    /**
     * 查询所有
     * @throws Exception
     */
   @Test
    public void testFindAll() {
       List<Role> roleList = roleDao.findAll();
       roleList.forEach(role -> {
           System.out.println("----------");
           System.out.println(role);
           System.out.println(role.getUsers());
       });
   }

}
