package dylan.ashton.n01442206;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


//Dylan Ashton n01442206 RNA
public class DylanActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final HomeFrag home = new HomeFrag();
    private final DownloadFrag download = new DownloadFrag();
    private final AsSrv srv = new AsSrv();
    private final FileContentFrag file = new FileContentFrag();
    private final SettingsFrag settings = new SettingsFrag();
    private final ShapeFrag shape = new ShapeFrag();
    ListView listView;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dylan_main);
        //setup
        getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, home).commit();
        NavigationView navigationView = findViewById(R.id.dylan_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //list
        listView= findViewById(R.id.dylan_list);
        ArrayList<String> arrayList =new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add("Third");

        //clock not working app crashes with .setText
        Calendar calendar;
        String dateTime;
        SimpleDateFormat simpleDateFormat;
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime());
       // ((TextView) navigationView.findViewById(R.id.dylan_time)).setText(dateTime);
    }



    //menu logic
    //must slide screen to access cant get 3 lines showing!
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawer = findViewById(R.id.dylan_drawer_layout);
        if (id == R.id.drawer_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, home).commit();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.drawer_download) {
            getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, download).commit();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.drawer_srv) {
            getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, srv).commit();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.drawer_file) {
            getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, file).commit();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.drawer_settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, settings).commit();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.drawer_shape) {
            getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, shape).commit();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Get menu inflater object.
        MenuInflater menuInflater = getMenuInflater();
        // Inflate the custom overflow menu
        menuInflater.inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Get clicked menu item id.
        int itemId = item.getItemId();
        if(itemId == R.id.dylan_help)
        {
            GoToWebPage("https://www.youtube.com/");
        }else if(itemId == R.id.dylan_settings)
        {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
        }
        return true;
    }

    public void GoToWebPage(String yourUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(yourUrl));
        startActivity(intent);
    }

//handle app close
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.DA2206);
        builder.setMessage(R.string.soa);
        builder.setPositiveButton(R.string.yes, (dialog, id) -> {

        });
        builder.setNegativeButton(R.string.no, (dialog, id) -> DylanActivity.super.finish());
        builder.show();
    }

}