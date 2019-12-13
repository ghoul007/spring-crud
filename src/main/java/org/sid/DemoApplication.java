package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRespository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df =  new SimpleDateFormat("dd/MM/yyy");
 
		contactRespository.save(new Contact("ahmed", "ghoul", df.parse("26/03/1999"), "ahmed@gmail.com",255111,"ahmed.png"));
		contactRespository.save(new Contact("khaled", "khaled", df.parse("25/03/1999"), "test@gmail.com",255111,"ahmed.png"));
		contactRespository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}

}
