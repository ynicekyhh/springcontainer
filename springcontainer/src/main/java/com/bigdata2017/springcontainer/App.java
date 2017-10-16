package com.bigdata2017.springcontainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/* 08.spring[IoCContainer].ppt파일 참고 */
public class App 
{
    public static void main( String[] args ) {
//    	testBeanFactory();
    	testApplicationContest();
    }
    
    public static void testApplicationContest() {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");

    	//같은 타입의 빈이 1개 이상 생성 된 경우
    	//타입으로 가져오면 예외 발생(어떤 bean을 줘야 할지 spring이 알 수 없으니 에러!!)
    	// 타입으로 가져오기
//    	User user1 = ac.getBean(User.class);
    	
    	// id로 가져오기
    	User user1 = (User) ac.getBean("user");
    	// name으로 가져오기
    	User user2 = (User) ac.getBean("usr");
    	
    	//singleton
    	System.out.println(user1 == user2);
    	
    	//name으로 가져오기
//    	System.out.println(user2.getName());
    	
    	/* conatiner에 User 타입이 2개가 등록되어 있으나, 타입으로 가져온 것이 아니라 id값으로 가져왔으니 가능.
    	 * context에 Bean을 등록할 때마다 자동으로 new 를 해서 등록하니 서로 다른 객체임 */
//    	User user4 = ac.getBean(User.class);
    	User user4 = (User) ac.getBean("user4");
    	System.out.println(user1 == user4);
    	
    	// User(Long, String) 생성된 빈 가져오기
    	User user5 = (User) ac.getBean("user5");
    	System.out.println(user5);
    	
    	User user6 = (User) ac.getBean("user6");
    	System.out.println(user6);
    	
    	// DI
    	User user7 = (User) ac.getBean("user7");
    	System.out.println(user7);
    	
    	// DI2
    	User user8 = (User) ac.getBean("user8");
    	System.out.println(user8);
    }
    
    public static void testBeanFactory() {
    	/* BeanFactory interface를 구현한 놈이 XmlBeanFactory */
    	/* application context를 이용한 클래스를 사용하기를 권장함 */
    	/* ppt의 ClassPathXmlApplicationContext class는 자동으로 classpath의 경로를 변경해 주는 것이고, 
    	 * XmlBeanFactory는 ClassPathResource를 이용해 변경해 줘야 한다. */
    	/* applicationContext에 등록한 bean을 BeanFactory 구현채를 통해 가져올 수 있다. */
    	BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/applicationContext.xml"));
    	
    	// 타입으로 가져오기
    	User user = bf.getBean(User.class);
    	System.out.println(user.getName());
    	
    	// id로 가져오기(applicationContext에 등록된 bean을 id로 가져올 때는 container입장에서 보면 어떤 객체인지 모르니까 캐스팅을 해 줘야 한다.)
    	user = (User) bf.getBean("user");
    	System.out.println(user.getName());
    	
    	// 해당 id의 빈이 존재하지 않는 경우 - exception 발생
    	//user = (User) bf.getBean("usr");
    	//System.out.println(user.getName());
    	
    	/* annotation을 사용할 경우 @Component로 등록된 클래스는 자동으로 id가 소문자로 설정되고, component는 bean에 자동등록된다. */
    	BeanFactory bf2 = new XmlBeanFactory(new ClassPathResource("config/applicationContext2.xml"));
    	user = bf2.getBean(User.class);
    	System.out.println(user.getName());
    	user = (User) bf2.getBean("user");
    	System.out.println(user.getName());
    	
    	/* BeanFactory는 설정되어 있는 녀석들을 모두 container에 만들어 놓고 사용하는 반면,
    	 * applicationContext는 getBean()을 하지 않으면 만들지 않는다.(lazy loading)
    	 * 따라서 applicationContext를 사용하는 것이 성능향상에 좋다. */
    }
}
