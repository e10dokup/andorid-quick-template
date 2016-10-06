package xyz.dokup.androidquicktemplate.core;

import android.content.Context;
import android.support.annotation.NonNull;

import com.github.gfx.android.orma.AccessThreadConstraint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.dokup.androidquicktemplate.db.model.OrmaDatabase;

/**
 * Created by e10dokup on 2015/10/09
 **/
@Module
public class MyModule {
    private static final String TAG = MyModule.class.getSimpleName();
    private final MyModule self = this;

    private Context mContext;

    public MyModule(@NonNull Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    public OrmaDatabase provideOrmaDatabase() {
        return OrmaDatabase.builder(mContext)
                .name("table_name")
                .readOnMainThread(AccessThreadConstraint.NONE)
                .build();
    }
}