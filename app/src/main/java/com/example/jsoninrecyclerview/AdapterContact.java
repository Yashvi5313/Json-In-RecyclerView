package com.example.jsoninrecyclerview;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    MainActivity mainActivity;
    LayoutInflater inflater;
    List<ContactList> contactData = Collections.emptyList();
    ContactList current;
    int currentPos = 0;

    public AdapterContact(MainActivity mainActivity, List<ContactList> contactData) {
        this.mainActivity = mainActivity;
        inflater = LayoutInflater.from(mainActivity);
        this.contactData = contactData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contact_list, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        ContactList current = contactData.get(position);
        myHolder.textId.setText(current.id);
        myHolder.textName.setText(current.name);
        myHolder.textEmail.setText(current.email);
        Glide.with(mainActivity).load(current.userimage).into(myHolder.textImage);
        myHolder.textAddress.setText(current.address);
        myHolder.textGender.setText(current.gender);
        myHolder.textMobile.setText(current.mobile);
        myHolder.textHome.setText(current.home);
    }

    @Override
    public int getItemCount() {
        return contactData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView textId;
        TextView textName;
        TextView textEmail;
        TextView textAddress;
        TextView textGender;
        ImageView textImage;
        TextView textMobile;
        TextView textHome;

        public MyHolder(View itemView){
            super(itemView);
            textId = (TextView) itemView.findViewById(R.id.textId);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textEmail = (TextView) itemView.findViewById(R.id.textEmail);
            textAddress = (TextView) itemView.findViewById(R.id.textAddress);
            textGender = (TextView) itemView.findViewById(R.id.textGender);
            textImage = (ImageView) itemView.findViewById(R.id.textImage);
            textMobile = (TextView) itemView.findViewById(R.id.textMobile);
            textHome = (TextView) itemView.findViewById(R.id.textHome);
        }
    }
}
