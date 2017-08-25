package teamkunle.co.uk.carouselview.carousel;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import teamkunle.co.uk.carouselview.R;
import teamkunle.co.uk.carouselview.carousel.injection.CarouselComponent;
import teamkunle.co.uk.carouselview.carousel.injection.CarouselModel;
import teamkunle.co.uk.carouselview.carousel.injection.DaggerCarouselComponent;
import teamkunle.co.uk.carouselview.carousel.presenter.CarouselPresenterImpl;
import teamkunle.co.uk.carouselview.carousel.view.CarouselView;

public class CarouselFragment extends Fragment implements CarouselView {

    @Inject
    CarouselPresenterImpl carouselPresenter;

    private CarouselComponent carouselComponent;

    public CarouselFragment() {
    }

    public static CarouselFragment newInstance(){
        CarouselFragment fragment = new CarouselFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_carousel, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initComponent();
    }

    @Override
    public void helloUI() {

    }

    private void initComponent() {
        carouselComponent = DaggerCarouselComponent.builder()
                .carouselModel(new CarouselModel())
                .build();
        carouselComponent.inject(this);
        carouselPresenter.attachView(this);
    }
}
