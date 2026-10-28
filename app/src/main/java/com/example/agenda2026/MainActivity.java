package com.example.agenda2026;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.fragment.NavHostFragment;

import com.example.agenda2026.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //1 criando as variáveis de botão da tela inicial
    private Button btnCadastro;
    private Button btnAtualiza;
    private Button btnVisualiza;
    private Button btnApagar;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setSupportActionBar(binding.toolbar);

//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment_content_main);
//
//        if (navHostFragment != null) {
//            NavController navController = navHostFragment.getNavController();
//
//            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        }
//
//        binding.fab.setOnClickListener(
//                view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show()
//        );

        // 2  "linkando" as váriaveis com as Views no XML
        btnCadastro=(Button)findViewById(R.id.cadastrarXML);
        btnAtualiza=(Button)findViewById(R.id.atualizarXML);
        btnVisualiza=(Button)findViewById(R.id.visualizarXML);
        btnApagar=(Button)findViewById(R.id.apagarXML);

// 3.1 criando um listener para disparar a tela de cadastro
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(it);
            }
        });
// 3.2 criando um listener para disparar a tela de visualização dos contatos
        btnVisualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ExibeContatos.class);
                startActivity(it);
            }
        });
// 3.3 criando um listener para disparar a tela de apagar cadastro
        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Apagar.class);
                startActivity(it);
            }
        });
// 3.4 criando um listener para disparar a tela de atualização de cadastro
        btnAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Atualizar.class);
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment_content_main);
//        boolean handled = false;
//        if (navHostFragment != null) {
//            NavController navController = navHostFragment.getNavController();
//            handled = NavigationUI.navigateUp(navController, appBarConfiguration);
//        }
//        return handled || super.onSupportNavigateUp();
//    }
}