package teamkunle.co.uk.carouselview.carousel.presenter;

import teamkunle.co.uk.carouselview.carousel.view.CarouselView;

public interface CarouselPresenter <T extends CarouselView> {

    void detachView();
    void attachView(CarouselView carouselView);
    void drawViewList();
}
