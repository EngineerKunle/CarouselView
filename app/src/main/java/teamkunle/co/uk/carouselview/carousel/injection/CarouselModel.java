package teamkunle.co.uk.carouselview.carousel.injection;

import dagger.Module;
import dagger.Provides;
import teamkunle.co.uk.carouselview.carousel.injection.scopes.PerActivity;
import teamkunle.co.uk.carouselview.carousel.presenter.CarouselPresenterImpl;

@Module
public class CarouselModel {

    @Provides
    @PerActivity
    CarouselPresenterImpl providesCarouselPresenter(){
       return new CarouselPresenterImpl();
    }

}
