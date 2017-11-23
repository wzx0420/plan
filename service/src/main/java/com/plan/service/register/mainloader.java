package com.plan.service.register;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注册服务启动
 * @author wing
 *
 */
public class mainloader {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-application-context.xml");
		ctx.refresh();
		ctx.start();
		Scanner scan = new Scanner(System.in);
		System.out.println("service started");
		Boolean wait = true;
		while (wait) {
			String result = scan.nextLine();
			while (!result.equals("stop")) {
				System.out.println("service continue");
				result = scan.nextLine();
			}
			System.out.println("are you sure stop services?");
			result = scan.nextLine();
			if (!result.equals("y")) {
				System.out.println("service continue");
				continue;
			}
			wait = false;
		}
		System.out.println("service end");
		ctx.close();
		scan.close();
	}
}
