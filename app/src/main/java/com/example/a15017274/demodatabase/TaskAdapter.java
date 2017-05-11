package com.example.a15017274.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017274 on 11/5/2017.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvID, tvDesc, tvDate;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        tasks = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvID = (TextView) rowView.findViewById(R.id.tvID);
        tvDesc = (TextView)rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView)rowView.findViewById(R.id.tvDate);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Task currentInformation = tasks.get(position);
        // Set the TextView to show the food

        tvID.setText(""+currentInformation.getId());
        tvDesc.setText(currentInformation.getDescription());
        tvDate.setText(currentInformation.getDate());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
