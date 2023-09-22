package com.lcwd.orm;

import com.lcwd.orm.entities.*;
import com.lcwd.orm.repositories.CategoryRepo;
import com.lcwd.orm.repositories.ProductRepo;
import com.lcwd.orm.repositories.StudentRepository;
import com.lcwd.orm.services.UserService;
import com.lcwd.orm.services.impl.UserServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class LearnSpringOrmApplication implements CommandLineRunner
{
	@Autowired
	private StudentRepository studentRepository;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
    private UserService userService;

	public static void main(String[] args)
	{
		SpringApplication.run(LearnSpringOrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{

		/*
			User user = new User();
			user.setName("Ankit");
			user.setCity("Delhi");
			user.setAge(34);
			User savedUser = userService.saveUser(user);
			System.out.println(savedUser);

		 */


			// get Single User
			List<User> users = userService.getAllUser();
			logger.info("user size is {} ", users.size());
			logger.info("Users : {} ", users);


		/*
			User user = userService.getUser(2);
			logger.info("Users : {} ", user);
		*/

		/*
			User user = new User();
			user.setName("MS Dhoni");
			user.setCity("Ranchi");
			user.setAge(40);

			User updatedUser = userService.updateUser(user, 1);
			logger.info("updated user details : {} ", updatedUser);
		*/

	//	userService.deleteUser(2);
/*
		Student student = new Student();
		student.setStudentName("Harsh Dubey");
		student.setAbout("I am a Software Engineer");
		student.setStudentId(13);

		Laptop laptop = new Laptop();
		laptop.setModelNumber("14314");
		laptop.setBrand("DELL");
		laptop.setLaptopId(1231);

		// important
		laptop.setStudent(student);

		student.setLaptop(laptop);

		Student save = studentRepository.save(student);

		logger.info("saved student : {}", save.getStudentName());

 */

        /*
			Student student = studentRepository.findById(13).get();
			logger.info("Name is {} ", student.getStudentName());

			Laptop laptop = student.getLaptop();
			logger.info("Laptop {},{}", laptop.getBrand(), laptop.getModelNumber());
        */

		/*
		// One To Many
		Student student = new Student();
		student.setStudentName("Saugata Dey");
		student.setAbout("I am a Software Engineer");
		student.setStudentId(15);

		Address a1 = new Address();
		a1.setAddressId(131);
		a1.setStreet("235/235");
		a1.setCity("Kolkata");
		a1.setCountry("IND");
		a1.setStudent(student);

		Address a2 = new Address();
		a2.setAddressId(133);
		a2.setStreet("421/235");
		a2.setCity("Delhi");
		a2.setCountry("IND");
		a2.setStudent(student);

		List<Address> addressList = new ArrayList<>();
		addressList.add(a1);
		addressList.add(a2);

		student.setAddressList(addressList);

		Student save = studentRepository.save(student);
		logger.info("Student created : with address");



		Product product1 = new Product();
		product1.setpId("pid1");
		product1.setProductName("Iphone 14 max pro");

		Product product2 = new Product();
		product2.setpId("pid2");
		product2.setProductName("Samsung s22 ultra");

		Product product3 = new Product();
		product3.setpId("pid3");
		product3.setProductName("Samsung TV12341");

		Category category1 = new Category();
		category1.setcId("cid1");
		category1.setTitle("Electronics");

		Category category2 = new Category();
		category2.setcId("cid2");
		category2.setTitle("Mobile Phone");

		List<Product> category1Products = category1.getProducts();
		category1Products.add(product1);
		category1Products.add(product2);
		category1Products.add(product3);

		List<Product> category2Products = category2.getProducts();
		category2Products.add(product1);
		category2Products.add(product2);

		categoryRepo.save(category1);
		categoryRepo.save(category2);

		 */

		/*
		Optional<Product> byProductName = productRepo.findByProductName("Iphone 14 max pro");
		System.out.println(byProductName.isPresent());
		System.out.println(byProductName.get().getProductName());

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		List<Product> tra = productRepo.findByProductNameEndingWith("tra");
		tra.forEach(product -> {
			System.out.println(product.getProductName());
		});

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		List<Product> sung = productRepo.findByProductNameContaining("sung");
		sung.forEach(product -> System.out.println(product.getProductName()));

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		List<Product> samsungS22Ultra = productRepo.findByProductNameIn(Arrays.asList("Iphone 14 max pro", "Samsung s22 ultra"));
		samsungS22Ultra.forEach(product -> System.out.println(product.getProductName()));

		 */

		// Native Query
		List<Product> allProductWhileLearningJPA = productRepo.getAllProductWhileLearningJPA();
		allProductWhileLearningJPA.forEach(product -> System.out.println(product.getProductName()));
	}

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;
}
