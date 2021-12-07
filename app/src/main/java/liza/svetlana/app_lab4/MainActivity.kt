package liza.svetlana.app_lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null

            when (item.itemId) {
                R.id.icon_1 -> {
                    fragment = HomeFragment()
                }

                R.id.icon_2 -> {
                    fragment = InfoFragment()
                }

            }

            replaceFragment(fragment!!)
            true
        }

        bottomNavigationMenu.selectedItemId = R.id.icon_1

    }


        fun replaceFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragment.tag)
                .commit()
        }

    }



