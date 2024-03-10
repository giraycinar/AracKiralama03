package com.giray.service;

import com.giray.dto.request.CreateUserRequestDto;
import com.giray.entity.User;
import com.giray.exception.ErrorType;
import com.giray.exception.UserManagerException;
import com.giray.mapper.UserMapper;
import com.giray.repository.UserRepository;
import com.giray.utility.enums.EStatus;
import com.giray.utility.ServiceManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService extends ServiceManager<User,String> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }



//    public UserService(MongoRepository<User, String> repository, UserRepository userRepository) {
//        super(repository);
//        this.userRepository = userRepository;
//    }



    public User createUser(CreateUserRequestDto dto) {
        return save(UserMapper.INSTANCE.fromCreateRequestToUser(dto));

    }


    public Boolean activateStatus(Long authId) {
        Optional<User> optionalUserProfile = userRepository.findByAuthId(authId);
        if(optionalUserProfile.isPresent()){
            optionalUserProfile.get().setStatus(EStatus.ACTIVE);
            update(optionalUserProfile.get());
            return true;
        } else {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
    }





}
