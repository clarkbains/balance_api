package com.clarkbains.roommates;

import com.clarkbains.roommates.models.Database.Repositories.UsersRepository;
import com.clarkbains.roommates.models.Database.User;
import com.clarkbains.roommates.sampleTables.SampleUsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoommatesApplicationTests {
	@Autowired
	UsersRepository a;
	@Before
	public void setup(){
		a.saveAll(SampleUsers.getSampleUsers());
	}
	@Test
	public void testLoads() {
		assert true;
	}

	@Test
	public void checkFind(){
		assert a.findFirstByEmailEquals("me@clarkbains.com")!=null;
		assert a.findFirstByEmailEquals("notme@clarkbains.com")==null;
		for(User u: a.findAll()){
			assert u.equals(a.findFirstByIdEquals(u.getId()));
		}
	}
	@Test
	public void checkHash(){
		assert User.hashPassword("passw0rd").equals("8f0e2f76e22b43e2855189877e7dc1e1e7d98c226c95db247cd1d547928334a9");
	}

	@After
	public void del (){
		a.deleteAll();
	}

}
