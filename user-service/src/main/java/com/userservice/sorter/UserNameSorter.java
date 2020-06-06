package com.userservice.sorter;

import com.userservice.models.UserModel;

import java.util.Comparator;

public class UserNameSorter implements Comparator<UserModel> {
    @Override
    public int compare(UserModel o1, UserModel o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
