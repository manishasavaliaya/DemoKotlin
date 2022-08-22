package com.ipath.hospitaldevice.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ipath.hospitaldevice.R
import com.ipath.hospitaldevice.utils.UserPreferenceHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: Toolbar
    lateinit var navController: NavController
    lateinit var bottomMenu: ConstraintLayout

    @Inject
    lateinit var userPreferenceHelper: UserPreferenceHelper
    lateinit var bottomNavigation: BottomNavigationView
    var isFirstTime = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        toolbar = findViewById(R.id.toolbar)
        navController = findNavController(R.id.my_nav_host_fragment)
        val graph = navController
            .navInflater.inflate(R.navigation.navigation)
        navController.graph = graph
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.people,R.id.stage,R.id.liveChat -> {
//                    bottomMenu.visibility = View.VISIBLE
//                    bottomNavigation.visibility = View.VISIBLE
//                }
//                else->{
//                    bottomMenu.visibility = View.GONE
//                    bottomNavigation.visibility = View.GONE
//                }
//            }
//        }
//        bottomNavigation.setupWithNavController(navController)
//        bottomNavigation.setOnNavigationItemReselectedListener {
//            when (it.itemId) {
//                R.id.liveChat -> {
//                    navController.navigate(JoinEventDirections.actionJointToOnlyPeople())
//                }

//            }
//        }
    }

    fun changeStatusBarColor(isLight: Boolean = false) {
        if (isLight) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//  set status text dark
            window.statusBarColor =
                ContextCompat.getColor(this, R.color.white) // set status background white
        } else {
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
            val decorView = window.decorView //set status background black
            decorView.systemUiVisibility =
                decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() //set status text  light
        }
    }


}