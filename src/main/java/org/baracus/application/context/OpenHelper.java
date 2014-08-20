package org.baracus.application.context;

import android.content.Context;
import net.mantucon.baracus.dao.BaracusOpenHelper;
import org.baracus.application.migr8.ModelVersion100;

/**
 * Created by marcus on 16.07.14.
 */
public class OpenHelper extends BaracusOpenHelper {

    private static final String DATABASE_NAME="client-database.db";
    private static final int TARGET_VERSION=100;

    static {
        addMigrationStep(new ModelVersion100());
    }

    /**
     * Open Helper for the android database
     *
     * @param mContext              - the android context
     */
    public OpenHelper(Context mContext) {
        super(mContext, DATABASE_NAME, TARGET_VERSION);
    }

}
