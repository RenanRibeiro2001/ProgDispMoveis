package com.example.tarefan1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarefan1.R;
import com.example.tarefan1.models.user;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private List<user> usersList;

    public UsersAdapter(List<user> usersList) {
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.view_holder_user, parent, false);
        view.findViewById(R.id.btnPegar).setOnClickListener((v) -> {
            Toast.makeText(view.getContext(), ((user)view.getTag()).getName(), Toast.LENGTH_SHORT).show();
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {
        user User = usersList.get(position);
        holder.view.setTag(User);
        ((TextView) holder.view.findViewById(R.id.vhName)).setText(User.getName());
        ((TextView) holder.view.findViewById(R.id.vhUserName)).setText(User.getUserName());
        ((TextView) holder.view.findViewById(R.id.vhEmail)).setText(User.getEmail());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
