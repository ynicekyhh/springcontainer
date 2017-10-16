package com.bigdata2017.springcontainer;

import org.springframework.stereotype.Component;

/* User에서 Friend객체를 @Autowired로 연결해 사용하려면 @Component로 등록해야 한다.
 * 하지만 이 예제에서는 Friend가 applicationContext에서 설정으로 bean객체를 여러 개 등록하니 에러가 발생한다. */
@Component
public class Friend {
	private String name = "aaa";

	public Friend() {
		// TODO Auto-generated constructor stub
	}
	
	public Friend(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
}
