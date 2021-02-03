package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //apply our custom toolbar
        setSupportActionBar(toolbar)

        //This method will locate the NavController associated with this view.
        //This is automatically populated for the id of a NavHost and its children
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        //By calling this method, the title in the Toolbar will automatically be updated when the destination changes
        bottom_nav.setupWithNavController(navController)

        //By calling this method, the title in the action bar will automatically be updated when the destination changes
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    //to navigate Up within your application's activity hierarchy from the action bar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}