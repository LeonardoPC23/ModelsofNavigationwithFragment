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

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import devf.leonardo.modelsofnavigationwithfragment.R;
import devf.leonardo.modelsofnavigationwithfragment.domain.Image;
import devf.leonardo.modelsofnavigationwithfragment.domain.Udacity;
import devf.leonardo.modelsofnavigationwithfragment.io.model.ShowInstructorResponse;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by LEONARDO on 28/09/2015.
 */
public class MyAdapterRecyclerInstructor extends RecyclerView.Adapter<MyAdapterRecyclerInstructor.ViewHolder> implements MyOnItemClickListener {
    FrameLayout frameLayout;
    private List<Udacity> udacityList;
    private LayoutInflater inflater;
    private MyOnItemClickListener myOnItemClickListener;
    private Context context;
    public List<ShowInstructorResponse.InstructorMain> listInstructor;

    public MyAdapterRecyclerInstructor(Context context, List<Udacity> udacityList) {
        this.udacityList = udacityList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_instructor_rows, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, R.id.txt_instructor_name,
                R.id.txt_title_instructor, R.id.image_instructor, R.id.image_course);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Udacity udacity = udacityList.get(position);

        holder.setCircleImageView(udacity.getImage());
        holder.setImageView(udacity.getBanner_image());
        holder.setHomePage(udacity.getHomepage());
        ;
        holder.setTitle(udacity.getTitle());

    }

    @Override
    public int getItemCount() {

        return udacityList.size();
    }

    public void setData(List<Udacity> data) {
        udacityList = data;
        notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(context, udacityList.get(position).getTitle().toString(), LENGTH_SHORT).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        CircleImageView circleImageView;
        TextView txtNombreInstructro;
        TextView txtTitle;

        public ViewHolder(View itemView, int idTextName, int idTitle, int idCircleView, int idImageView) {
            super(itemView);
            itemView.setOnClickListener(this);

            txtNombreInstructro = (TextView) itemView.findViewById(idTextName);
            txtTitle = (TextView) itemView.findViewById((idTitle));
            imageView = (ImageView) itemView.findViewById(idImageView);
            circleImageView = (CircleImageView) itemView.findViewById(idCircleView);
        }


        @Override
        public void onClick(View v) {

        }

        public void setTitle(String title) {
            txtTitle.setText(title);
        }

        public void setHomePage(String homePage) {
            txtNombreInstructro.setText(homePage);
        }

        public void setImageView(String imageViewUrl) {
            Picasso.with(context).load(imageViewUrl).fit().placeholder(R.drawable.ic_code_black_24dp).into(imageView);
        }

        public void setCircleImageView(String circleImageViewUrl) {
            Picasso.with(context).load(circleImageViewUrl).fit().placeholder(R.drawable.ic_face_black_24dp).into(circleImageView);


        }
    }


}
