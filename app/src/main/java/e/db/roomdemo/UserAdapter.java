package e.db.roomdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<User> arrayList;
    Context context;
    Bitmap bitmap;

    public UserAdapter(List<User> users, MainActivity activity) {
        this.arrayList = users;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User food = arrayList.get(position);
        holder.firstname_user.setText(arrayList.get(position).getFirstName());
        holder.lastname_user.setText(arrayList.get(position).getLastName());
        holder.email_user.setText(arrayList.get(position).getEmail());

        byte[] foodImage = food.getImage();

        bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView_user.setImageBitmap(bitmap);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.firstname_user)
        TextView firstname_user;
        @BindView(R.id.lastname_user)
        TextView lastname_user;
        @BindView(R.id.email_user)
        TextView email_user;
        @BindView(R.id.imageView_user)
        ImageView imageView_user;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
