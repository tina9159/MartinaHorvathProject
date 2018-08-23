package hu.horvath.martina.project.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;
import hu.horvath.martina.project.R;
import hu.horvath.martina.project.presenter.MainActivityPresenter;
import hu.horvath.martina.project.view.fragment.MainFragment;
import hu.horvath.martina.project.view.interfaces.MainActivityView;

public class MainActivity extends DaggerAppCompatActivity implements MainActivityView {

    @BindView(R.id.text)
    TextView text;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, MainFragment.newInstance())
                    .commitAllowingStateLoss();
    }

}
