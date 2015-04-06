package org.gradle;

import java.net.UnknownHostException;
import java.util.List;

import org.gradle.configuration.MongoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoException;

public class Main {
	public static void main(String[] args) throws UnknownHostException, MongoException {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		MongoTemplate mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");
		 Query query = new Query();
		//		mongoOperation.save(new Person("प्रतीक"));
		List<Person> persons = mongoTemplate.find(query, Person.class);
		
		for (Person person : persons) {
			System.out.println(person.getName());
		}
		
	}
}
