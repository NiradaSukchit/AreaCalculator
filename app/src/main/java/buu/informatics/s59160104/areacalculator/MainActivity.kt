package buu.informatics.s59160104.areacalculator

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160104.areacalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        val button = findViewById<Button>(R.id.button_rectangle)
//        button.setOnClickListener { show() }

    }

//    private fun show() {
//        Toast.makeText(
//            this, "button clicked",
//            Toast.LENGTH_SHORT
//        ).show()
//    }
}
