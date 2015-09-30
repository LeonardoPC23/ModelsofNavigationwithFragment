package devf.leonardo.modelsofnavigationwithfragment.io.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import devf.leonardo.modelsofnavigationwithfragment.R;
import devf.leonardo.modelsofnavigationwithfragment.domain.Udacity;

import static android.widget.Toast.LENGTH_SHORT;


/**
 * Created by LEONARDO on 22/09/2015.
 */
public class MyAdapterRecycler extends RecyclerView.Adapter<MyAdapterRecycler.ViewHolder> implements MyOnItemClickListener {

    FrameLayout frameLayout;
    private List<Udacity> udacityList;
    private LayoutInflater inflater;
    private MyOnItemClickListener myOnItemClickListener;
    private Context context;

    public MyAdapterRecycler(Context context, List<Udacity> udacityList) {
        this.udacityList = udacityList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_udacity_rows, parent, false);
        ViewHolder viewHolder = new ViewHolder(view,
                R.id.txt_project_name, R.id.txt_level,
                R.id.txt_title_instructor, R.id.txt_time_duration,
                R.id.txt_duration,
                R.id.image_instructor,
                R.id.image_course);

        return viewHolder;
    }

        @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Udacity udacity = udacityList.get(position);
        holder.setCircleImageView(udacity.getImage());
        holder.setDuration(udacity.getExpected_duration());
        holder.setTime(udacity.getExpected_duration_unit());
        holder.setLevel(udacity.getLevel());
        holder.setProject(udacity.getTitle());
        holder.setTitle(udacity.getProject_name());
        holder.setImageView(udacity.getBanner_image());


    }

    @Override
    public int getItemCount() {
        return udacityList.size();
    }

    public void setData(List<Udacity> data) {
        udacityList = data;
        notifyDataSetChanged();
    }
    public void clear(){
        udacityList.clear();
        notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(context,udacityList.get(position).getTitle().toString(),LENGTH_SHORT).show();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView idTextProjectName, idTextLevel, idTextTitulo, idTextDuration, idTextTime;
        CircleImageView circleImageView;
        ImageView imageView;

        public ViewHolder(View itemView, int idProject, int idLevel, int idTitulo,
                          int idDuration,
                          int idTime,
                          int idCircle,
                          int idImage) {
            super(itemView);
            itemView.setOnClickListener(this);

            circleImageView = (CircleImageView) itemView.findViewById(idCircle);
            imageView = (ImageView) itemView.findViewById(idImage);
            idTextProjectName = (TextView) itemView.findViewById(idProject);
            idTextLevel = (TextView) itemView.findViewById(idLevel);
            idTextTitulo = (TextView) itemView.findViewById(idTitulo);
            idTextDuration = (TextView) itemView.findViewById(idDuration);
            idTextTime = (TextView) itemView.findViewById(idTime);

        }

        @Override
        public void onClick(View v) {

        }

        public void setProject(String project) {
            idTextProjectName.setText(project);
        }

        public void setLevel(String level) {
            idTextLevel.setText(level);
        }

        public void setTitle(String title) {
            idTextTitulo.setText(title);
        }

        public void setDuration(String duration) {
            idTextDuration.setText(duration);
        }

        public void setTime(String time) {
            idTextTime.setText(time);
        }



        public void setCircleImageView(String circleImageViewUrl) {
            Picasso.with(context).load(circleImageViewUrl).fit().placeholder(R.drawable.ic_face_black_24dp).into(circleImageView);


        }

        public void setImageView(String imageViewUrl) {
            Picasso.with(context).load(imageViewUrl).fit().placeholder(R.drawable.ic_code_black_24dp).into(imageView);

        }
    }

    public void setMyOnItemClickListener(MyAdapterRecycler myAdapterRecycler) {

    }

}

