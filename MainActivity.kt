package thatcodeaddict.github.randomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.RollButton)
        val submitButton = findViewById<Button>(R.id.Submit)
        val limitTextView = findViewById<TextView>(R.id.Number)
        val resultsTextView = findViewById<TextView>(R.id.ResultsTextView)
        val valueTextView = findViewById<TextView>(R.id.valueTextView)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val layout_wrapper = findViewById<ConstraintLayout>(R.id.layout_wrapper)

        submitButton.setOnClickListener{
            val prog = limitTextView.text
            seekBar.max = prog.toString().toInt()
        }

        layout_wrapper.setOnClickListener{
            seekBar.progress++
        }

        seekBar?.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valueTextView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                valueTextView.setText("Pick A Value")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                println("here")
            }

        })

        rollButton.setOnClickListener{
            val rand = Random.nextInt(0,seekBar.progress+1)
            resultsTextView.text = rand.toString()
        }

    }
}