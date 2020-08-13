package com.pojo;

/**
 * 静态工厂
 * @author Administrator
 *
 */
public class PeopleStaticFactory {
	public  static People newInstance() {
		return new People(1,"测试",34);
	}

}
