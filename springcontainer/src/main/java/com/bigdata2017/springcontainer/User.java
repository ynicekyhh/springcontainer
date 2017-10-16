package com.bigdata2017.springcontainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* applicationContext2.xml에 설정된 annotation방법으로 스캐닝을 해서 사용하기 위한 방법 */
@Component
public class User {
	private Long no;
	private String name;
	/* 이렇게 friend에 @Autowired를 붙이면 applicationContext의 모든 user bean객체들이 다 주입받으려 하니 안됨 */
	@Autowired()
	@Qualifier("friend7")
	private Friend friend;
	private List<String> friends;

	/* applicationContext에 Bean을 등록할 때, 기본생성자로 생성을 하니까 반드시 기본 생성자가 있어야함. 그 외의 생성자를 사용하려면 xml설정을 추가로 등록해 줘야 함 */
	public User() {
	}
	
	public User(Long no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}
}
