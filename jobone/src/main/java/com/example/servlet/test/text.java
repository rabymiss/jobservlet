package com.example.servlet.test;

import com.example.servlet.entity.CpnMsgEn;
import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.MessageAll;
import com.example.servlet.entity.User;
import com.example.servlet.repository.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class text {


    public static void main(String[] args) {


//        //加载
        InputStream inputStream = text.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

  LoginRepository loginRepository=sqlSession.getMapper(LoginRepository.class);
  JobMessage jobMessage=new JobMessage();
  jobMessage.setUsername("17781140502");
        List<JobMessage>list=loginRepository.findjobby(jobMessage);
        System.out.println("Soudao-----------"+list);
        sqlSession.commit();
        sqlSession.close();
//加入Messageall
//        for (int i=0;i<30;i++){
//            MessageAll messageAll=new MessageAll();
//         messageAll.setCondition3("comndition1"+i);
//         messageAll.setConditionOne("comndition2"+i);
//         messageAll.setConditionTwo("comndition3"+i);
//         messageAll.setCpnAddress("address"+i);
//         messageAll.setGood1("good1"+i);
//         messageAll.setGood2("good2"+i);
//         messageAll.setGood3("good3"+i);
//         messageAll.setGood4("good4"+i);
//         messageAll.setDizhi("dizhi"+i);
//         messageAll.setCpnImage("img"+i);
//         messageAll.setWorkAddress("chengdu"+i);
//         messageAll.setId(i);
//         messageAll.setJobName("job"+i);
//         messageAll.setCpnName("xiaomi"+i);
//         messageAll.setJobPay("500"+i);
//         messageAll.getDizhi();
//         messageAll.setWorkContent("content"+i);
//         messageAll.setWorkContentShow("show"+i);
//          jobMessageAll.sava(messageAll);
//        //    System.out.println(jobMessage1);
//         sqlSession.commit();
//        //
//        }
//        sqlSession.close();
//User user=new User( "xiangming","123456");
//userRepository.save(user);
//sqlSession.commit();
//sqlSession.close();


//查询全部
//       List<JobMessage> list=loginRepository.findAll();
//   for (JobMessage jobMessage:list)
//   {
//       System.out.println(jobMessage);
//   }
//        User user=new User("17781140502","77");
//
//        Long a    =  userRepository.findUser(user.getUsername(),user.getPassword());
//
//     System.out.println(a);
//
//        sqlSession.commit();
//        sqlSession.close();

//        List<All1>list=jobMessageAll.findAll();
//        System.out.println(list);
//        sqlSession.commit();
//        sqlSession.close();



        //查询resume
//        List<ResumeEntity> list=resumeRepository.findAll();
//        System.out.println(list);

    }

}


