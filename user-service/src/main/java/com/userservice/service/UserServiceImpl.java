package com.userservice.service;

import com.userservice.models.UserModel;
import com.userservice.repository.UserRepository;
import com.userservice.sorter.UserNameSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> fetchAllUserInfo() {

        List<UserModel> users =  (List<UserModel>)userRepository.findAll();
        return users;
    }

    @Override
    public void createUserInfo(final UserModel userModel) {
        userRepository.save(userModel);
    }

    @Override
    public UserModel findUserByName(final String name){
        return userRepository.findByName(name);
    }

    @Override
    public UserModel findUserByPhn(String phn) {
        return userRepository.findByPhn(phn);
    }

    @Override
    public List<UserModel> sortByName() {
       List<UserModel> users = fetchAllUserInfo();
       users.sort(new UserNameSorter());
       return users;
    }
}
