package teamkunle.co.uk.carouselview.carousel;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import teamkunle.co.uk.carouselview.R;
import teamkunle.co.uk.carouselview.carousel.adapters.CarouselAdapter;
import teamkunle.co.uk.carouselview.carousel.injection.CarouselComponent;
import teamkunle.co.uk.carouselview.carousel.injection.DaggerCarouselComponent;
import teamkunle.co.uk.carouselview.carousel.model.CarouselNewsModel;
import teamkunle.co.uk.carouselview.carousel.presenter.CarouselPresenterImpl;
import teamkunle.co.uk.carouselview.carousel.view.CarouselView;

public class CarouselFragment extends Fragment implements CarouselView {

    @Inject
    CarouselPresenterImpl carouselPresenter;

    private CarouselComponent carouselComponent;
    private Context context;
    private RecyclerView rVNews;
    private LinearLayoutManager layoutManager;
    private final List<CarouselNewsModel> newsList = new ArrayList<>();

    public CarouselFragment() {
    }

    public static CarouselFragment newInstance(){
        CarouselFragment fragment = new CarouselFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        rVNews = (RecyclerView) view.findViewById(R.id.recycler_list);

        carouselPresenter.drawViewList();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        initComponent();
    }

    @Override
    public void onDetach() {
        carouselPresenter.detachView();
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setUpRecyclerView() {
        newsList.add(new CarouselNewsModel("Liverpool Beat Arsenal", "John Smith"));
        newsList.add(new CarouselNewsModel("Transfer Rumours", "Bobby Jackson"));
        newsList.add(new CarouselNewsModel("Liverpool sign defender", "Chris Ace"));

        CarouselAdapter adapter = new CarouselAdapter(newsList);
        rVNews.setAdapter(adapter);
        layoutManager.setStackFromEnd(true);
        rVNews.setLayoutManager(layoutManager);
    }

    private void initComponent() {
        carouselComponent = DaggerCarouselComponent.builder()
                .build();
        carouselComponent.inject(this);
        carouselPresenter.attachView(this);
    }
}
