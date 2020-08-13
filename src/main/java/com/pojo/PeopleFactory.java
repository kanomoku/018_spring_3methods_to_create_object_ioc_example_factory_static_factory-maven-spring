package com.pojo;

/**
 * 工厂设计模式
 * 
 * @author Administrator
 *
 */
public class PeopleFactory {
	public People createPeople(String which) {
		switch (which) {
		case "A":
			// 处理简单的逻辑
			return new A();
		case "B":
			return new B();
		default:
			return null;
		}
	}
}
