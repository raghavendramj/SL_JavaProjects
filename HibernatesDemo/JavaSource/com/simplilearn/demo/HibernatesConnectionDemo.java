package com.simplilearn.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.modal.Product;

public class HibernatesConnectionDemo {
	public static void main(String[] args) {

		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernates.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		System.out.println("Hibernate Session opened!");

		String hibernateQuery = "select _p from Product _p";
		//from Object{name, price, etc..} -> Product{name, price}
		List<Product> productList = session.createQuery(hibernateQuery, Product.class).getResultList();
		
		List<String> productNames = productList.stream().map(eachProduct -> eachProduct.getName()).collect(Collectors.toList());
		
		System.out.println(" List of prodcuts are.. " + productNames);

		session.close();
		System.out.println("Hibernate Session closed!");
	}
}
