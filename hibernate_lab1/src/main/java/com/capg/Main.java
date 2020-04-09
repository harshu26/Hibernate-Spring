package com.capg;
import javax.persistence.*;

public class Main {
	EntityManagerFactory emf;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.execute();
	}
	
	public void execute() {
		emf = Persistence.createEntityManagerFactory("author-mgt");
        Author author = insertAuthor();
        int id = author.getAuthorId();
        Author found = findAuthorById(id);
        print(found);
	}
	
	void print(Author author) {
		System.out.println("Details obtained are:"+author.getAuthorId()+" "+author.getFirstName()+" "+author.getMiddleName()+" "+author.getLastName());
	}
	
	Author findAuthorById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Author author = em.find(Author.class, id);
        transaction.commit();
        em.close();
        return author;
    }
	
	 Author updateAuthor(Author author){
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction transaction = em.getTransaction();
	        transaction.begin();
	        author=em.merge(author);
	        transaction.commit();
	        em.close();
	        return author;
	    }
	 
	 void delete(int id){
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction transaction = em.getTransaction();
	        transaction.begin();
	        Author author=em.find(Author.class,id);
	        em.remove(author);
	        transaction.commit();
	        em.close();
	        System.out.println("Author removed with id="+id);
	    }
	 
	 Author insertAuthor() {
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction transaction = em.getTransaction();
	        transaction.begin();
	        Author author = new Author();
	        author.setFirstName("Harsh");
	        author.setMiddleName("h");
	        author.setLastName("Shrivastava");
	        author.setPhoneNo(12345678);
	        em.persist(author);
	        transaction.commit();
	        System.out.println("Author added, withd id=" + author.getAuthorId());
	        em.close();
	        return author;
	 }
	 
	 

}
