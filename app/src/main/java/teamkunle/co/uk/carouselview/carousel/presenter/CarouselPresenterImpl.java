package teamkunle.co.uk.carouselview.carousel.presenter;


import android.support.annotation.Nullable;

import teamkunle.co.uk.carouselview.carousel.view.CarouselView;

public class CarouselPresenterImpl implements CarouselPresenter<CarouselView> {

    private CarouselView carouselView;

    public CarouselPresenterImpl(){
    }

    @Override
    public void detachView() {
        this.carouselView = null;
    }

    @Override
    public void attachView(CarouselView carouselView) {
        this.carouselView = carouselView;
    }

    @Nullable
    private CarouselView getView()  {
        if (carouselView == null) {
            throw new IllegalStateException("view not attached");
        } else {
            return carouselView;
        }
    }
}