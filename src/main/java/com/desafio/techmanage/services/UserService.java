package com.desafio.techmanage.services;

import com.desafio.techmanage.exceptions.business.DataAlreadyRegisteredException;
import com.desafio.techmanage.models.User;
import com.desafio.techmanage.repositories.UserRepository;
import com.desafio.techmanage.vo.UserVO;
import com.desafio.techmanage.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserVO adicionar(UserForm userForm) {

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


}
