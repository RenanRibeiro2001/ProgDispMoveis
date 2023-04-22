package com.example.tarefan1.repositories;

import com.example.tarefan1.models.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, user> UsersMap;
    private static UserRepository instance;

    private UserRepository(){
        this.UsersMap = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    //Inclui um obj user no repositorio / map
    public void addUser(user User){
        if(User != null) {
            this.UsersMap.put(User.getId(), User);
        }
    }

    //retorna se um obj user esta presente no mapa
    public boolean contains(user User){
        return this.UsersMap.containsValue(User);
    }

    //retorno se um obj esta presente no map por seu id
    public boolean contains(Integer id){
        return this.UsersMap.containsValue(id);
    }

    //retorna uma collection com todos os usuario
    public Collection<user> getUsers(){
        return  this.UsersMap.values();
    }


}
