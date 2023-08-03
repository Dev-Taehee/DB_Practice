package mongo.mongopractice.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mongo.mongopractice.user.entity.MongoUser;
import mongo.mongopractice.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String selectUser(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if(userRepository.findByName(name) == null) {
                log.info("[Service] user name: {} not exist!!", name);
                return String.format("user name : %s not exist!!", name);
            }else {
                return objectMapper.writeValueAsString(userRepository.findByName(name));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public void saveUser(String name, int age) {
        MongoUser mongoUser = new MongoUser();
        mongoUser.setName(name);
        mongoUser.setAge(age);

        if(userRepository.findByName(name) != null) {
            log.info("[Service][update] name is already exist!!");
            mongoUser.setId(userRepository.findByName(name).getId());
        } else {
            log.info("[Service][Insert] New name received");
        }

        userRepository.save(mongoUser);
    }

}
