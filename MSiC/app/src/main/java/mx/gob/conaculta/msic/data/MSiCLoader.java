package mx.gob.conaculta.msic.data;


import android.content.Context;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

import mx.gob.conaculta.msic.utils.MSiCConst;

/**
 * Created by alfonso on 19/02/15.
 */
public class MSiCLoader extends CursorLoader {

    private MSiCDBOper msicdbo;

    private String stema;

    private SharedPreferences mpref;

    /**
     * @param context
     * @param msicdbo
     */
    public MSiCLoader(Context context, MSiCDBOper msicdbo) {
        super(context);

        this.msicdbo = msicdbo;

        mpref=context.getSharedPreferences(MSiCConst.SSPREF,Context.MODE_MULTI_PROCESS);
        this.stema=mpref.getString(MSiCConst.STEMA,"");
    }


    @Override
    public Cursor loadInBackground() {
        if(stema.isEmpty()) {
            return msicdbo.obtenCursorAll();
        }else{
            return msicdbo.obtenCursor(stema);
        }
    }

}
