package com.desafio.techmanage.services;

import com.desafio.techmanage.enums.UserType;
import com.desafio.techmanage.exceptions.business.DataAlreadyRegisteredException;
import com.desafio.techmanage.exceptions.business.DataNotRegisteredException;
import com.desafio.techmanage.models.User;
import com.desafio.techmanage.repositories.UserRepository;
import com.desafio.techmanage.vo.UserVO;
import com.desafio.techmanage.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserVO addUser(UserForm userForm) {

        if (userRepository.findByEmail(userForm.getEmail()).isPresent()) {
            throw new DataAlreadyRegisteredException("email", userForm.getEmail());
        }

        if (userRepository.findByPhone(userForm.getPhone()).isPresent()) {
            throw new DataAlreadyRegisteredException("phone", userForm.getPhone());
        }

        User user = userForm.toModel();

        userRepository.save(user);

        return UserVO.fromModel(user);
    }

    public List<UserVO> findAllUsers(){

        List<UserVO> usersVO = new ArrayList<>();
        List<User> users =  userRepository.findAll();

         for(User user : users) {
            usersVO.add(UserVO.fromModel(user));
         }
         return usersVO;

    }


    public UserVO findUsersById(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new DataNotRegisteredException();
        }
        return UserVO.fromModel(user.get());
    }

    public UserVO updateUsersById(Long id, UserForm userform){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new DataNotRegisteredException();
        }

        User toUpdateUser = user.get();

        toUpdateUser.setPhone(userform.getPhone());
        toUpdateUser.setEmail(userform.getEmail());
        toUpdateUser.setFullName(userform.getFullName());
        toUpdateUser.setUserType(UserType.valueOf(userform.getUserType()));
        toUpdateUser.setBirthDate(userform.getBirthDate());

        userRepository.save(toUpdateUser);

        return UserVO.fromModel(toUpdateUser);
    }

    public void  deleteUsersById(Long id){

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw new DataNotRegisteredException();
        }
        userRepository.deleteById(id);

    }
}
