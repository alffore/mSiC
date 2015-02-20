package mx.gob.conaculta.msic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by alfonso on 01/02/15.
 */
public class MenuTemasAdapter extends ArrayAdapter {

    Context context;

    private static final String[] MT_ARRAY = {"Museo", "Teatro", "Casas y Centros Culturales", "Librerías", "Galerías", "Bibliotecas"};


    public MenuTemasAdapter(Context context) {
        super(context, 0);
        this.context = context;
    }

    public int getCount() {
        return MT_ARRAY.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.grid_celda, parent, false);

            TextView tv = (TextView) row.findViewById(R.id.textViewGM);

            tv.setText(MT_ARRAY[position]);

        }

        return row;
    }

}
