package teamkunle.co.uk.carouselview.carousel.presenter;


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

    private CarouselView getView() throws Exception {
        if (carouselView == null) {
            throw new Exception("View Cannot be null");
        } else {
            return carouselView;
        }
    }
}
