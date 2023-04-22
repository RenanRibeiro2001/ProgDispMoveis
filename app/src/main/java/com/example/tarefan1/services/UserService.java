package com.example.tarefan1.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarefan1.models.user;
import com.example.tarefan1.repositories.UserRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class UserService {

    public static user userFromJson(JSONObject json){
        user User = null;
        try {
            User = new user (
                    json.getInt("id"),
                    json.getString("name"),
                    json.getString("username"),
                    json.getString("email"));
        } catch (JSONException e) {
            System.out.println("Erro no Json !!" + e.getMessage());
        }
        return User;
    }

    //Buscar todos os user no servidor REST
    public static void getAllUsers(Context contexto, ServiceDone callback){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users", null,
                response -> {
                    for(int i = 0; i < response.length(); i++){
                        //System.out.println(response);
                        try {
                            JSONObject json = response.getJSONObject(i);
                            UserRepository.getInstance().addUser(userFromJson(json));
                        } catch (JSONException e) {
                            System.out.println("Erro no Json !!" + e.getMessage());
                        }
                        if (callback != null) {
                            callback.onServiceDone();
                        }
                    }
                    //System.out.println(users);
                }, error -> {Toast.makeText(contexto, "Ocorreu uma falha na requisicao" + error.getMessage(), Toast.LENGTH_LONG).show();});
        RequestQueue queue = Volley.newRequestQueue(contexto);
        queue.add(request);

    }
}
