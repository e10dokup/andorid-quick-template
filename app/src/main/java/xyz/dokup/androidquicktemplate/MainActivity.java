package xyz.dokup.androidquicktemplate;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.dokup.androidquicktemplate.core.BaseActivity;
import xyz.dokup.androidquicktemplate.core.BaseFragment;
import xyz.dokup.androidquicktemplate.core.MyApplication;
import xyz.dokup.androidquicktemplate.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        { // Inject values
            MyApplication app = (MyApplication) getApplication();
            app.getComponent().inject(this);
        }

        ButterKnife.bind(this);

        setToolbarStatus();

        replaceFragment(new MainFragment(), false);
    }

    private void setToolbarStatus() {
        mToolbar.setTitle(R.string.app_name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void replaceFragment(BaseFragment fragment, boolean recordBackstack) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        if(recordBackstack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public void replaceFragment(BaseFragment fragment, boolean recordBackstack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        if(recordBackstack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
    @Override
    public void popFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack();
    }
}
