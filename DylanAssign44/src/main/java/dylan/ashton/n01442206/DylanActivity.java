package dylan.ashton.n01442206;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

//Dylan Ashton n01442206 RNA
public class DylanActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final HomeFrag home = new HomeFrag();
    private final DownloadFrag download = new DownloadFrag();
    private final AsSrv srv = new AsSrv();
    private final FileContentFrag file = new FileContentFrag();
    private final SettingsFrag settings = new SettingsFrag();
    private final ShapeFrag shape = new ShapeFrag();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dylan_main);

        //setup
        getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, home).commit();
        NavigationView navigationView = findViewById(R.id.dylan_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    //menu logic
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