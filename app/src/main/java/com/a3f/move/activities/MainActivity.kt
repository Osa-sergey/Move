package com.a3f.move.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.a3f.move.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val navController: NavController by lazy { Navigation.findNavController(this, R.id.mainFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NavigationUI.setupWithNavController(bottomNavView,navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}