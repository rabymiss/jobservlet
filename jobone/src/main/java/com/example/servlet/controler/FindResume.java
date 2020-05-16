package com.example.servlet.controler;

import com.example.servlet.entity.JobReturn;
import com.example.servlet.entity.Resume;
import com.example.servlet.entity.ResumeEntity;
import com.example.servlet.entity.User;
import com.example.servlet.repository.ResumeRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
public class FindResume {
    @RequestMapping("find/mesume/byid")
    public JobReturn findbyid(@RequestBody User user) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
        Resume resume=new Resume();
        resume.setCpnid(user.getUsername());
        List<Resume> list = resumeRepository.findAllby(resume);
        System.out.println("寻找简历---------------"+resume);
        jobReturn.setData(list);
        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }
    @RequestMapping("save/resume")
    public JobReturn saveresume(@RequestBody Resume resume) {
        JobReturn jobReturn = new JobReturn();
        jobReturn.setErrmsg("成功");
        jobReturn.setErrno(200);
        InputStream inputStream = FindResume.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ResumeRepository resumeRepository =sqlSession.getMapper(ResumeRepository.class);
       resumeRepository.save(resume);
        System.out.println("上传简历---------------"+resume);

        sqlSession.commit();
        sqlSession.close();
        return jobReturn;
    }


}
