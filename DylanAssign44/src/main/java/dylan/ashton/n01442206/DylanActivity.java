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

    private HomeFrag home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dylan_main);

        home = new HomeFrag();

        getSupportFragmentManager().beginTransaction().replace(R.id.dylan_frame_layout, home).commit();


    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.drawer_home) {

        } else if (id == R.id.drawer_settings) {

        } else if (id == R.id.drawer_shape) {

        } else if (id == R.id.drawer_download) {

        } else if (id == R.id.drawer_srv) {

        } else if (id == R.id.drawer_file) {

        }
        DrawerLayout drawer = findViewById(R.id.dylan_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
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