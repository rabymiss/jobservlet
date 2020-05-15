package com.example.servlet.controler;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.JobReturn;
import com.example.servlet.repository.LoginRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class FindJob {

    @RequestMapping("find/job")
    public JobReturn info() {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindJob.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        LoginRepository loginRepository = sqlSession.getMapper(LoginRepository.class);
        List<JobMessage> list = loginRepository.findAll();
        System.out.println(list);
        jobReturn.setData(list);
        return jobReturn;
    }

    @RequestMapping("find/job/byid")
    public JobReturn findjobbyid(@RequestBody JobReturn jobReturn1) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindJob.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        LoginRepository loginRepository = sqlSession.getMapper(LoginRepository.class);
        JobMessage jobMessage=new JobMessage();
        jobMessage.setUsername(jobReturn1.getErrmsg());
        List<JobMessage> list = loginRepository.findjobby(jobMessage);
        System.out.println("找到------------"+list);
        jobReturn.setData(list);
        return jobReturn;
    }
}
