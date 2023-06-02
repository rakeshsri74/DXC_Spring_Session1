package com.dxc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dxc.bo.Triangle;

public class Drawing {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		Triangle t = (Triangle)ctx.getBean("triangle");
		t.draw();

	}

}
