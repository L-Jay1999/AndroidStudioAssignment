package chapter.android.aweme.ss.com.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import chapter.android.aweme.ss.com.homework.model.*;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Message> msg_list;
    private final ListItemClickListener mOnClickListener;
    private final String tag = "adapter";

    public MyAdapter(List<Message> msg, ListItemClickListener listener) {
        msg_list = msg;
        mOnClickListener = listener;
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.im_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message msg = msg_list.get(position);
        holder.bind(msg);
    }

    @Override
    public int getItemCount() {
        return msg_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title;
        private TextView description;
        private TextView time;
        private CircleImageView avatar;
        private ImageView robotNotice;

        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.tv_title);
            description = view.findViewById(R.id.tv_description);
            time = view.findViewById(R.id.tv_time);
            avatar = view.findViewById(R.id.iv_avatar);
            robotNotice = view.findViewById(R.id.robot_notice);
            view.setOnClickListener(this);
        }

        public void bind(Message message) {
            String icon = message.getIcon();
            int iconimage;
            switch (icon) {
                case "TYPE_ROBOT":
                    iconimage = R.drawable.session_robot;
                    break;
                case "TYPE_GAME":
                    iconimage = R.drawable.icon_micro_game_comment;
                    break;
                case "TYPE_SYSTEM":
                    iconimage = R.drawable.session_system_notice;
                    break;
                case "TYPE_STRANGER":
                    iconimage = R.drawable.session_stranger;
                    break;
                case "TYPE_USER":
                    iconimage = R.drawable.icon_girl;
                    break;
                default:
                    iconimage = R.drawable.icon_blacksend_untouch;
                    break;
            }
            title.setText(message.getTitle());
            description.setText(message.getDescription());
            time.setText(message.getTime());
            avatar.setImageResource(iconimage);
            if(message.isOfficial()){
                robotNotice.setVisibility(View.VISIBLE);
            }
            else{
                robotNotice.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onClick(View v){
            int temp = getAdapterPosition();
            if(mOnClickListener != null){
                mOnClickListener.onListItemClick(temp);
            }
        }
    }


}