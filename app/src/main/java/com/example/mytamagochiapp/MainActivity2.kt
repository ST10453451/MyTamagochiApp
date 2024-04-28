package com.example.mytamagochiapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    private lateinit var btnFeed: Button
    private lateinit var btnPlay: Button
    private lateinit var btnBath: Button
    private lateinit var imageViewPet: ImageView
    private lateinit var progressBarHunger: ProgressBar
    private lateinit var progressBarHygiene: ProgressBar
    private lateinit var progressBarHappiness: ProgressBar
    private lateinit var textViewDisplay: TextView

    private var isFull = false
    private var isClean = false
    private var isHappy = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnFeed = findViewById(R.id.btnFeed)
        btnPlay = findViewById(R.id.btnPlay)
        btnBath = findViewById(R.id.btnHygiene)
        imageViewPet = findViewById(R.id.imageViewPet)
        progressBarHunger = findViewById(R.id.progressBarHunger)
        progressBarHygiene = findViewById(R.id.progressBarHygiene)
        progressBarHappiness = findViewById(R.id.progressBarHappiness)
        textViewDisplay = findViewById(R.id.textViewDisplay)

        initializeStatusBars()

        btnFeed.setOnClickListener {
            if (!isFull) {
                imageViewPet.setImageResource(R.drawable.dog_eating)
                updateStatusBar(progressBarHunger, 100, "Thanks for feeding me, I am full!")
                btnFeed.text = "Starve"
                isFull = true
            } else {
                imageViewPet.setImageResource(R.drawable.dog_starving)
                updateStatusBar(progressBarHunger, 20, "Your pet is starving!")
                btnFeed.text = "Feed"
                isFull = false
            }
        }

        btnPlay.setOnClickListener {
            if (!isHappy) {
                imageViewPet.setImageResource(R.drawable.dog_playing)
                updateStatusBar(progressBarHappiness, 100, "Thanks for playing with me, I am happy!")
                btnPlay.text = "Upset"
                isHappy = true
            } else {
                imageViewPet.setImageResource(R.drawable.dog_upset)
                updateStatusBar(progressBarHappiness, 20, "Your pet is upset!")
                btnPlay.text = "Play"
                isHappy = false
            }
        }

        btnBath.setOnClickListener {
            if (!isClean) {
                imageViewPet.setImageResource(R.drawable.dog_bathing)
                updateStatusBar(progressBarHygiene, 100, "Thanks for bathing me, I am clean!")
                btnBath.text = "Dirty"
                isClean = true
            } else {
                imageViewPet.setImageResource(R.drawable.dog_muddy)
                updateStatusBar(progressBarHygiene, 20, "Your pet is muddy!")
                btnBath.text = "Bath"
                isClean = false
            }
        }
    }

    private fun initializeStatusBars() {
        updateStatusBar(progressBarHunger, 20, "")
        updateStatusBar(progressBarHygiene, 20, "")
        updateStatusBar(progressBarHappiness, 20, "")
    }

    private fun updateStatusBar(progressBar: ProgressBar, progress: Int, message: String) {
        progressBar.progress = progress
        if (progress >= 100) {
            progressBar.progressDrawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN)
        } else {
            progressBar.progressDrawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
        }
        textViewDisplay.text = message
    }
}
