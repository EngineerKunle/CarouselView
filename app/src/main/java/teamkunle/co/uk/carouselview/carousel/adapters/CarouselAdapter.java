package teamkunle.co.uk.carouselview.carousel.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teamkunle.co.uk.carouselview.R;
import teamkunle.co.uk.carouselview.carousel.adapters.viewholder.CarouselViewHolder;
import teamkunle.co.uk.carouselview.carousel.model.CarouselNewsModel;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselViewHolder>{

    private List<CarouselNewsModel> newsList;

    public CarouselAdapter(List<CarouselNewsModel> newsList) {
        this.newsList = newsList;
    }

    @Override
    public CarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.carousel_item, parent, false);

        CarouselViewHolder viewHolder = new CarouselViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CarouselViewHolder holder, int position) {
        CarouselNewsModel carouselNews = newsList.get(position);
        setUpViewHolders(holder, carouselNews.newsTitle, carouselNews.newsAuthor);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    private void setUpViewHolders(CarouselViewHolder vh, String title, String author) {
        TextView authorName = vh.authorName;
        authorName.setText(title);

        TextView headline = vh.newsHeadline;
        headline.setText(author);
    }
}
