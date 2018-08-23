package hu.horvath.martina.project.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;
import hu.horvath.martina.project.R;
import hu.horvath.martina.project.presenter.MainActivityPresenter;
import hu.horvath.martina.project.view.fragment.MainFragment;
import hu.horvath.martina.project.view.interfaces.MainActivityView;

public class MainActivity extends DaggerAppCompatActivity implements MainActivityView {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, MainFragment.newInstance())
                    .commitAllowingStateLoss();
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
