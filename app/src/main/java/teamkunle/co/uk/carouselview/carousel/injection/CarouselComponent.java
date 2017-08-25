package teamkunle.co.uk.carouselview.carousel.injection;


import dagger.Component;
import teamkunle.co.uk.carouselview.carousel.CarouselFragment;
import teamkunle.co.uk.carouselview.carousel.injection.scopes.PerActivity;

@PerActivity
@Component(modules = CarouselModel.class)
public interface CarouselComponent {
    void inject(CarouselFragment fragment);
}
