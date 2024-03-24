package com.example.swiggyclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        if (currentFragment == null) {
            replaceFragment(MainFragment())
        }

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            var fragment = Fragment()
            when(menuItem.itemId){
                R.id.menu_swiggy->{
                    replaceFragment(MainFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_food->{
                    replaceFragment(Dineout())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_dineut->{
                    replaceFragment(Dineout())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_geniew->{
                    replaceFragment(Genie())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_instmart->{
                    replaceFragment(Instamart())
                    return@setOnItemSelectedListener true
                }

                else -> {
                    return@setOnItemSelectedListener true
                }
            }

//            if (fragment::class == currentFragment?.javaClass) {
//                return@setOnNavigationItemSelectedListener true
//            }
//
//            replaceFragment(fragment)

        }


        replaceFragment(currentFragment!!)
    }


    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
        currentFragment = fragment

        // Update BottomNavigationView selection only if the fragment is different


    }
}