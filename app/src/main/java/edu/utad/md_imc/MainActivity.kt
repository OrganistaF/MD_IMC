package edu.utad.md_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar
import edu.utad.md_imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editHeight.inputType = InputType.TYPE_CLASS_NUMBER;
        binding.editWeight.inputType = InputType.TYPE_CLASS_NUMBER;

        binding.calculateImc.setOnClickListener {
            val height = binding.editHeight.text.toString()
            val weight = binding.editWeight.text.toString()
            val selectedRadio: RadioButton =
                findViewById(binding.radioGroupGender.checkedRadioButtonId)
            val gender = selectedRadio.text.toString()
            if (height.isNotEmpty()
                && weight.isNotEmpty()
                && binding.radioGroupGender.checkedRadioButtonId != -1
            ) {

                val intentSecondActivity = Intent(this, SecondActivity::class.java)
                intentSecondActivity.putExtra("weight", weight)
                intentSecondActivity.putExtra("height", height)
                intentSecondActivity.putExtra("gender", gender)
                startActivity(intentSecondActivity)
                finish()


            } else {
                Snackbar.make(binding.root, "Enter Data Correctly", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

    }
}