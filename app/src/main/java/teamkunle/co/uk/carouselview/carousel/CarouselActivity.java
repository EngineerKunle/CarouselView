package teamkunle.co.uk.carouselview.carousel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import teamkunle.co.uk.carouselview.R;
import teamkunle.co.uk.carouselview.carousel.injection.CarouselComponent;
import teamkunle.co.uk.carouselview.carousel.injection.CarouselModel;
import teamkunle.co.uk.carouselview.carousel.injection.DaggerCarouselComponent;
import teamkunle.co.uk.carouselview.carousel.presenter.CarouselPresenterImpl;
import teamkunle.co.uk.carouselview.carousel.view.CarouselView;

public class CarouselActivity extends AppCompatActivity implements CarouselView{

    @Inject
    CarouselPresenterImpl carouselPresenter;

    private CarouselComponent carouselComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        initComponent();
    }

    private void initComponent() {
        carouselComponent = DaggerCarouselComponent.builder()
                .carouselModel(new CarouselModel())
                .build();
        carouselComponent.inject(this);
        carouselPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        carouselPresenter.detachView();
        super.onDestroy();
    }
}
