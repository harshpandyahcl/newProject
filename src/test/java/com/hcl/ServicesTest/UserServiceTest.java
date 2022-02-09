package com.hcl.ServicesTest;

import com.hcl.domain.User;
import com.hcl.repositories.UserRepository;
import com.hcl.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService serviceTest;

    @MockBean
    public UserRepository repositoryTest;

    @Test
    public void FindAllUserTest(){
        long userTestId = 1;
        User test = new User();
        test.setId(userTestId);
        test.setUsername("test@usertest.com");
        test.setFullName("Demo User");
        test.setPassword("password");

        when(repositoryTest.findAll()).thenReturn(Stream
                .of(test).collect(Collectors.toList()));

        Iterable<User> list=serviceTest.findAll();

        for (User u:list) {
            System.out.println(u.getUsername());
        }
    }

}
