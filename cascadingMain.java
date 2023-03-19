package com.cas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class cascadingMain 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital1=new Hospital();
		hospital1.setName("Narayana");
		hospital1.setWebsite("www.narayana.com");
		hospital1.setNodoctors(10);
		
		Hospital hospital2=new Hospital();
		hospital2.setName("vasavi");
		hospital2.setWebsite("www.vasavi.com");
		hospital2.setNodoctors(20);
		
		Branch branch1=new Branch();
		branch1.setName("Basavanagudi");
		branch1.setLocation("Banglore");
		branch1.setPhno(77889992);
		
		Branch branch2=new Branch();
		branch2.setName("Gachiboli");
		branch2.setLocation("Hyderabad");
		branch2.setPhno(88889992);
		
		Branch branch3=new Branch();
		branch3.setName("Tambaram");
		branch3.setLocation("chennai");
		branch3.setPhno(66889992);
		
		Branch branch4=new Branch();
		branch4.setName("kurnool");
		branch4.setLocation("Andhra");
		branch4.setPhno(99889992);
		
		List<Branch>list1=new ArrayList<Branch>();
		list1.add(branch1);
		list1.add(branch2);
		
		List<Branch>list2=new ArrayList<Branch>();
		list2.add(branch3);
		list2.add(branch4);
		
//		List<Branch>list3=new ArrayList<Branch>();
//		list3.add(branch1);
//		list3.add(branch4);
//		
//		List<Branch>list4=new ArrayList<Branch>();
//		list4.add(branch4);
//		list4.add(branch1);
//		
		hospital1.setBranch(list1);
		hospital2.setBranch(list2);
		
		branch1.setHospital(hospital1);
		branch2.setHospital(hospital2);
		branch3.setHospital(hospital1);
		branch4.setHospital(hospital2);
		
		entityTransaction.begin();
		entityManager.persist(hospital1);
		entityManager.persist(hospital2);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityManager.persist(branch4);
		entityTransaction.commit();
		
	}
}
