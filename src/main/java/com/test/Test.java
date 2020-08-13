package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.People;
import com.pojo.PeopleExampleFactory;
import com.pojo.PeopleFactory;

/**
 * Spring 创建对象的三种方式
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
//		二.IoC
//		1 中文名称:控制反转
//		2.英文名称:(Inversion of Control)
//		3.IoC 是什么?
//			3.1 IoC 完成的事情原先由程序员主动通过new 实例化对象事情,转交给Spring 负责.
//		3.2 控制反转中控制指的是:控制类的对象.
//		3.3 控制反转中反转指的是转交给Spring 负责.
//		3.4 IoC 最大的作用:解耦.
//			3.4.1 程序员不需要管理对象.解除了对象管理和程序员之间的耦合.
		
//		三.Spring 环境搭建
//		1. 导入jar
//			1.1 四个核心包一个日志包(commons-logging)
//		2. 在src 下新建applicationContext.xml
//			2.1 文件名称和路径自定义.
//			2.2 记住Spring 容器ApplicationContext,applicationContext.xml 配置的信息最终存储到了AppliationContext 容器中
//			2.3 spring 配置文件是基于schema
//				2.3.1 schema 文件扩展名.xsd
//				2.3.2 把schema 理解成DTD 的升级版.
//					2.3.2.1 比DTD 具备更好的扩展性.
//					2.3.3 每次引入一个xsd 文件是一个namespace(xmlns)
//			2.4 配置文件中只需要引入基本schema
//				2.4.1 通过<bean/> 创建对象.
//				2.4.2 默认配置文件被加载时创建对象.
//		3. 编写测试方法
//			3.1 getBean(“<bean>标签id值”,返回值类型);如果没有第二个参数,默认是Object
//			3.2 getBeanDefinitionNames(),Spring 容器中目前所有管理的所有对象.
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		以下是三种较常见的 ApplicationContext 实现方式：
//		1、ClassPathXmlApplicationContext：从classpath的XML配置文件中读取上下文，并生成上下文定义。应用程序上下文从程序环境变量中
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		2、FileSystemXmlApplicationContext ：由文件系统中的XML配置文件读取上下文。
//		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
//		3、XmlWebApplicationContext：由Web应用的XML文件读取上下文。
//		4.AnnotationConfigApplicationContext(基于Java配置启动容器)

		
		/*Spring 容器中目前所有管理的所有对象.*/
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		System.out.println("--------------------------------");
		
//		四.Spring 创建对象的三种方式
//		1. 通过构造方法创建
//			1.1 无参构造创建:默认情况.
//			1.2 有参构造创建:需要明确配置
//				1.2.1 需要在类中提供有参构造方法
//				1.2.2 在applicationContext.xml 中设置调用哪个构造方法创建对象
//					1.2.2.1 如果设定的条件匹配多个构造方法执行最后的构造方法
//					1.2.2.2 index : 参数的索引,从0 开始
//					1.2.2.3 name: 参数名
//					1.2.2.4 type:类型(区分开关键字和封装类int 和Integer)
		//1.构造方法
		People bean = ac.getBean("peo",People.class);
		System.out.println(bean);
		People bean1 = ac.getBean("peo1",People.class);
		System.out.println(bean1);
		People bean2 = ac.getBean("peo2",People.class);
		System.out.println(bean2);
		System.out.println("--------------------------------");

//		2. 实例工厂
//			2.1 工厂设计模式:帮助创建类对象.一个工厂可以生产多个对象.
//			2.2 实例工厂:需要先创建工厂,才能生产对象
//			2.3 实现步骤:
//				2.3.1 必须要有一个实例工厂
//				2.3.2 在applicationContext.xml 中配置工厂对象和需要创建的对象
		//工厂模式创建对象
		PeopleFactory factory = new PeopleFactory();
		People createPeople = factory.createPeople("A");
		
		//2.实例工厂
		PeopleExampleFactory peopleShiLiFactory = new PeopleExampleFactory();//以前写法
		People p = peopleShiLiFactory.newInstance();
		System.out.println(p);
		
		People bean3 = ac.getBean("peo3",People.class);//spring里的写法
		System.out.println(bean3);
		System.out.println("--------------------------------");
		
//		3. 静态工厂
//			3.1 不需要创建工厂,快速创建对象.
//			3.2 实现步骤
//				3.2.1 编写一个静态工厂(在方法上添加static)
//				3.2.2 在applicationContext.xml 中
		People bean4 = ac.getBean("peo4",People.class);//spring里的写法
		System.out.println(bean4);
	}
}
