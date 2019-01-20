package uddin.tawsin.myexpress;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uddin.tawsin.myexpress.R;
import uddin.tawsin.myexpress.custom;

import static java.security.AccessController.getContext;

public class adapter extends ArrayAdapter<custom> {
    public adapter(Context context, ArrayList<custom> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        custom user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.text);
       // TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(user.name);
       // tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}