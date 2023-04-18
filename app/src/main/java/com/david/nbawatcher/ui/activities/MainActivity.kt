package com.david.nbawatcher.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.david.nbawatcher.R
import com.david.nbawatcher.databinding.ActivityMainBinding
import com.david.nbawatcher.ui.fragments.PlayersFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_main_container,
                PlayersFragment.newInstance(),
                PlayersFragment.TAG
            )
            .commit()
    }
}