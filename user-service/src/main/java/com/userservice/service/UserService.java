package com.userservice.service;

import com.userservice.models.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> fetchAllUserInfo();
    void createUserInfo(final UserModel data);

    UserModel findUserByName(String name);
    UserModel findUserByPhn(String phn);
    List<UserModel> sortByName();
}
