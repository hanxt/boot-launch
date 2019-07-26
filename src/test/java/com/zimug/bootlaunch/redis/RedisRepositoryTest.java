package com.zimug.bootlaunch.redis;

import com.zimug.bootlaunch.dao.PersonRepository;
import com.zimug.bootlaunch.model.Address;
import com.zimug.bootlaunch.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void test(){

        Person rand = new Person("kobe", "byrant");
        rand.setAddress(new Address("luosanji", "USA"));
        personRepository.save(rand);
        Optional<Person> op = personRepository.findById(rand.getId());
        Person p2 = op.get();
        personRepository.count();
        //personRepository.delete(rand);

    }

    @Test
    public void testDelete(){


        personRepository.deleteById("24bda079-619f-438e-a8c8-cfc3f1aab487");

    }

}