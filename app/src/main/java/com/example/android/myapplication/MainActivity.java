package com.example.android.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekbar = (SeekBar) findViewById(R.id.seek_bar);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            View redRectangle = (View) findViewById(R.id.red_rectangle);
            View blueRectangle = (View) findViewById(R.id.blue_rectangle);

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int redRectangleColor = Color.TRANSPARENT;
                int blueRectangleColor = Color.TRANSPARENT;
                Drawable redBackground = redRectangle.getBackground();
                Drawable blueBackground = blueRectangle.getBackground();
                //Get the red value of the red rectangle color
                if (redBackground instanceof ColorDrawable) {
                    redRectangleColor = ((ColorDrawable) redBackground).getColor();
                }
                //Get the blue value of the blue rectangle color
                if (blueBackground instanceof ColorDrawable) {
                    blueRectangleColor = ((ColorDrawable) blueBackground).getColor();
                }
//                Change the color of the red rectangle with progress
                redRectangleColor = Color.rgb(
                        Color.red(redRectangleColor),
                        i,
                        i);
//                Change the color of the blue rectangle with progress
                blueRectangleColor = Color.rgb(
                        i,
                        i,
                        (Color.BLUE) + i);
                redRectangle.setBackgroundColor(redRectangleColor);
                blueRectangle.setBackgroundColor(blueRectangleColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more_info_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.info) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("For more info about this Training Task.\nPlease visit 1MAC disscussion formus!");

            alert.setPositiveButton("Visit Forums", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://macdiscussions.udacity.com/t/topic/99751"));
                    startActivity(intent);
                }
            });

            alert.setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog dialog = alert.create();
            dialog.show();

        }

        return super.onOptionsItemSelected(item);

    }
}
