package ecs.sample.backend.app.web;

//import ecs.sample.backend.app.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import ecs.sample.backend.app.model.entity.*;
import ecs.sample.backend.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/api/v1")
@Transactional
@Service
public class BackendRestController {
	
	@Autowired
    UserRepository userRepository;
	
    @GetMapping("/users")
    public List<User> getUsers(){
    	// select
        return userRepository.findAll();
    }
    
    @PostMapping("/users")
    public List<User> PostUsers(){
    	// delete
    	userRepository.deleteAll();
    	
    	// save
    	User user1 = User.builder()
    			.userId(0)
    			.userName("Sho")
    			.build();
        
    	User user2 = User.builder()
    			.userId(1)
    			.userName("Ken")
    			.build();
    	userRepository.saveAll(Arrays.asList(new User[]{user1, user2}));
    	
    	// response
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }
}
