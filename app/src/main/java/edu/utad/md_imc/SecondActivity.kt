package edu.utad.md_imc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.utad.md_imc.databinding.ActivitySecondBinding
import kotlin.math.pow

class SecondActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weight = intent.getStringExtra("weight")!!.toDouble()
        val height = intent.getStringExtra("height")!!.toDouble()
        val gender = intent.getStringExtra("gender")!!

        val imc = (weight) / ((height / 100.0).pow(2.0))

        binding.imc.text = String.format("%.2f", imc)

        var image = binding.image


        if (gender == "Male"){
            when {
                imc < 18.5 -> {
                    binding.state.text = "Bajo peso"
                    image.setImageResource(R.drawable.s1)
                }
                imc in 18.5..24.9 -> {
                    binding.state.text = "Peso normal"
                    image.setImageResource(R.drawable.s2)
                }
                imc in 25.0..29.9 -> {
                    binding.state.text = "Pre-obesidad o Sobrepeso"
                    image.setImageResource(R.drawable.s3)
                }
                imc in 30.0..34.9 -> {
                    binding.state.text = "Obesidad clase I"
                    image.setImageResource(R.drawable.s4)
                }
                imc in 35.0..39.9 -> {
                    binding.state.text = "Obesidad clase II"
                    image.setImageResource(R.drawable.s5)
                }
                else -> {
                    binding.state.text = "Obesidad clase III"
                    image.setImageResource(R.drawable.s6)
                }
            }
        } else {
            when {
                imc < 16.5 -> {
                    binding.state.text = "Bajo peso"
                    image.setImageResource(R.drawable.s1)
                }
                imc in 16.5..22.9 -> {
                    binding.state.text = "Peso normal"
                    image.setImageResource(R.drawable.s2)
                }
                imc in 23.0..25.9 -> {
                    binding.state.text = "Pre-obesidad o Sobrepeso"
                    image.setImageResource(R.drawable.s3)
                }
                imc in 26.0..30.9 -> {
                    binding.state.text = "Obesidad clase I"
                    image.setImageResource(R.drawable.s4)
                }
                imc in 31.0..33.9 -> {
                    binding.state.text = "Obesidad clase II"
                    image.setImageResource(R.drawable.s5)
                }
                else -> {
                    binding.state.text = "Obesidad clase III"
                    image.setImageResource(R.drawable.s6)
                }
            }
        }

        binding.back.setOnClickListener {
            val intentBack = Intent(this, MainActivity::class.java)
            startActivity(intentBack)
            finish()

        }

    }


}