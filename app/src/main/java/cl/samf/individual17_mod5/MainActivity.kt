package cl.samf.individual17_mod5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.samf.individual17_mod5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}