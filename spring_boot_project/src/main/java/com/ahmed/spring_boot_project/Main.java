package com.ahmed.spring_boot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
	private static List<Customer> customers;
	static{
		customers = new ArrayList<>();
		Customer alex = new Customer(1, "Alex", "alex@gmail.com", 20);
		Customer jamila = new Customer(1, "jamila", "alex@gmail.com", 21);

		customers.add(alex);
		customers.add(jamila);
	}
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping("api/v1/customers")
	public List<Customer> getCustomers(){
		return customers;
	}

	static class Customer{
		private Integer id; 
		private String name;
		private String email;
		private Integer age;
		

		public Customer() {
		}
		public Customer(Integer id, String name, String email, Integer age) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.age = age;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public boolean equals(Object object) {
			if (this == object) return true;
			if (object == null || getClass() != object.getClass()) return false;
			if (!super.equals(object)) return false;
			Customer customer = (Customer) object;
			return java.util.Objects.equals(id, customer.id) && java.util.Objects.equals(name, customer.name) && java.util.Objects.equals(email, customer.email) && java.util.Objects.equals(age, customer.age);
		}

		public int hashCode() {
			return java.util.Objects.hash(super.hashCode(), id, name, email, age);
		}

		@java.lang.Override
		public java.lang.String toString() {
			return "Customer{" +
					"id=" + id +
					", name='" + name + '\'' +
					", email='" + email + '\'' +
					", age=" + age +
					'}';
		}
	}

}
