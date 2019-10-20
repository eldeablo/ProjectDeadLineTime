package com.example.projectdeadlinetime.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectdeadlinetime.Data.ProjectData;
import com.example.projectdeadlinetime.R;

import java.util.List;

public class PCardAdapter extends RecyclerView.Adapter<PCardAdapter.ViewHolders> {

    private LayoutInflater context;
    private List<ProjectData> projectDataList;
    private ItemClickList itemClickList;

    public PCardAdapter(Context context, List<ProjectData> projectDataList) {
        this.context = LayoutInflater.from(context);
        this.projectDataList = projectDataList;
    }

    @NonNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = context.inflate(R.layout.project_card, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolders holder, int position) {
        holder.projectName.setText(projectDataList.get(position).getNameProject());
    }

    @Override
    public int getItemCount() {
        return projectDataList.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView projectName;
        CardView view;

        ViewHolders(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.cardView);
            view.setOnClickListener(this);

            projectName = itemView.findViewById(R.id.projectName);
        }

        @Override
        public void onClick(View view) {
            if (itemClickList != null) itemClickList.ItemClickList(view, getAdapterPosition());
        }
    }

    public void setItemClickList(ItemClickList itemClickList) {
        this.itemClickList = itemClickList;
    }

    public interface ItemClickList {
        void ItemClickList(View view, int position);
    }
}




