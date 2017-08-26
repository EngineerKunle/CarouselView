package teamkunle.co.uk.carouselview.carousel.adapters.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import teamkunle.co.uk.carouselview.R;

public class CarouselViewHolder extends RecyclerView.ViewHolder{

    public ImageView defaultImage;
    public TextView  newsHeadline;
    public TextView authorName;


    public CarouselViewHolder(View itemView) {
        super(itemView);

        defaultImage = (ImageView) itemView.findViewById(R.id.image_view);
        authorName   = (TextView) itemView.findViewById(R.id.news_author);
        newsHeadline = (TextView) itemView.findViewById(R.id.news_headline);
    }
}
