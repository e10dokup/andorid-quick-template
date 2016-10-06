package xyz.dokup.androidquicktemplate.db.model;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Setter;
import com.github.gfx.android.orma.annotation.Table;

/**
 * Created by e10dokup on 2016/10/06
 **/
@Table
public class Sample {
    private static final String TAG = Sample.class.getSimpleName();
    private final Sample self = this;

    @PrimaryKey(autoincrement = true)
    @Column(indexed = true)
    public int id;

    @Column
    public String name;

    @Setter
    public Sample(int id, String name) {
        this.id = id;
        this.name = name;
    }
}