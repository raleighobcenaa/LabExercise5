package com.obcena.labexercise5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] names, version, apiLvl, rDate, message;
    ListView list;
    int[] cLogo = {R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread, R.drawable.honeycomb,
            R.drawable.icecreamsandwich, R.drawable.jellybean, R.drawable.kitkat, R.drawable.lollipop, R.drawable.marshmallow, R.drawable.nougat, R.drawable.oreo, R.drawable.pie, R.drawable.android10};

    ArrayList<Android> androidVersion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.names);
        version = getResources().getStringArray(R.array.version);
        apiLvl = getResources().getStringArray(R.array.apiLvl);
        rDate = getResources().getStringArray(R.array.rDate);
        message = getResources().getStringArray(R.array.message);
        list = findViewById(R.id.lvAndroidVersions);
        for (int i = 0; i < names.length; i++) {
            androidVersion.add(new Android(cLogo[i], names[i], version[i], apiLvl[i], rDate[i], message[i]));

        }
        list = findViewById(R.id.lvAndroidVersions);
        CollegeAdapter adapter = new CollegeAdapter(this, R.layout.item, androidVersion);
        list.setAdapter(adapter);
        // list.position
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        // Toast.makeText(this, names[i], Toast.LENGTH_LONG).show();
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "AndroidVersion.txt");
        File read = new File(folder, "show.txt");
        try {
            final FileOutputStream fos = new FileOutputStream(file);
            final FileOutputStream show = new FileOutputStream(read);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            String choice = androidVersion.get(i).getNames() + "\n"
                    + androidVersion.get(i).getVersion() + "\n"
                    + androidVersion.get(i).getApiLvl() + "\n"
                    + androidVersion.get(i).getRDate() + "\n";
            String sChoice = androidVersion.get(i).getNames() + "\n" + androidVersion.get(i).getRDate();
            show.write(sChoice.getBytes());
            fos.write(choice.getBytes());
            dialog.setTitle(androidVersion.get(i).getNames());
            dialog.setIcon(androidVersion.get(i).getLogo());
            //dialog.setMessage(androidVersion.get(i).getMessage());
            dialog.setMessage(message[i]);

            dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    try {
                        FileInputStream fin;
                        fin = new FileInputStream(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/show.txt"));
                        int i;
                        String str = "";
                        while ((i = fin.read()) != -1) {
                            str += Character.toString((char) i);
                        }
                        fin.close();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            dialog.create().show();
        } catch (FileNotFoundException e) {
            makeText(this, "File not found.", Toast.LENGTH_LONG ).show();
        } catch (IOException e) {
            makeText(this, "Cannot Write...", Toast.LENGTH_LONG ).show();
        }


    }
}
