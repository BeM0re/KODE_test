package ru.be_more.kode_test.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.be_more.kode_test.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}