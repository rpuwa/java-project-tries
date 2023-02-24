package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.shopify.ShopifySdk;
import com.shopify.model.ShopifyShop;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

		System.out.println("\nNow, let's try to use shopify sdk:\n");
		final ShopifySdk shopifySdk = ShopifySdk.newBuilder().withSubdomain("rpuwazstore.myshopify.com").withAccessToken("shop_P-word").build();
		final ShopifyShop shopifyShop = shopifySdk.getShop();
		System.out.println("id: ");
		System.out.println(shopifyShop.getShop().getId());
		System.out.println("\nname: ");
		System.out.println(shopifyShop.getShop().getName());
		System.out.println("\n");
	}
}
