package teamkunle.co.uk.carouselview.carousel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import teamkunle.co.uk.carouselview.R;

public class CarouselActivity extends AppCompatActivity {

    private static final String CAROUSEL_FRAGMENT = "CAROUSEL_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        attachFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void attachFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.carousel_frame_layout, CarouselFragment.newInstance(), CAROUSEL_FRAGMENT).commit();
    }
}
