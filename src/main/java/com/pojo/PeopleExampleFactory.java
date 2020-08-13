package com.pojo;

/**
 * 实例工厂
 * @author Administrator
 *
 */
public class PeopleExampleFactory {
	public People newInstance() {
		return new People(1,"测试",34);
	}

}
