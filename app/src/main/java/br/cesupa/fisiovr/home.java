package br.cesupa.fisiovr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import br.cesupa.fisiovr.adapter.SimpleItemRecyclerViewAdapter;
import br.cesupa.fisiovr.list.FisioterapeutaListActivity;
import br.cesupa.fisiovr.list.PacienteListActivity;
import br.cesupa.fisiovr.list.SessaoListActivity;
import br.cesupa.fisiovr.list.VideoListActivity;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sessao_iniciar) {
            Toast.makeText(this, "nav_sessao_iniciar", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_sessao_Lista) {
            startActivity(new Intent(this, SessaoListActivity.class));
        } else if (id == R.id.nav_videos_novos) {
            Intent videoListIntent = new Intent(this, VideoListActivity.class);
            videoListIntent.putExtra(VideoListActivity.TAG_VIDEOS_TYPE, VideoListActivity.NEW_VIDEOS_TYPE);

            startActivity(videoListIntent);
        } else if (id == R.id.nav_videos_salvos) {
            Intent videoListIntent = new Intent(this, VideoListActivity.class);
            videoListIntent.putExtra(VideoListActivity.TAG_VIDEOS_TYPE, VideoListActivity.SAVED_VIDEOS_TYPE);

            startActivity(videoListIntent);
        } else if (id == R.id.nav_pessoas_fisioterapeutas) {
            startActivity(new Intent(this, FisioterapeutaListActivity.class));
        } else if (id == R.id.nav_pessoas_pacientes) {
            startActivity(new Intent(this, PacienteListActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
