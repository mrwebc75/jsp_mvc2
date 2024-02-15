package myBatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisManager {

  /*
   * ▣ MyBatis는 자바 개발자들이 DB를 쉽게 다룰수 있도록 도와주는 ORM 프레임워크
   * 
   * 1. DB쿼리문과 프로그래밍 언어코드를 분리하여 생산성을 높여준다.
   * 
   * 2. 쿼리문을 복잡하게 입력하지 않고, 실제 쿼리문과 유사하게 작성할 수 있다.
   * 
   * 3. 상황에 맞게 동적쿼리 작성이 가능하다.
   * 
   * 4. 적용순서 : 의존성설정 -> MyBatis+DB 설정 -> 매퍼XML 작성
   * 
   */
  // 1. 마이바티즈 설정정보를 가질 객체변수
  private static SqlSessionFactory sqlSessionFactory;

  public static SqlSessionFactory getSqlSessionFactory() {
    if (sqlSessionFactory == null) {
      new MyBatisManager();
    }
    return sqlSessionFactory;
  }

  // 싱글톤 처리
  private MyBatisManager() {

    String resource = "myBatis/mybatis-config.xml";// 설정파일

    InputStream inputStream = null;

    try {
      inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
