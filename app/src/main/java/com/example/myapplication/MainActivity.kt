package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var changeImageButton: Button
    private val images = arrayOf(R.drawable.a2, R.drawable.a3, R.drawable.a4)
    private val KEY_IMAGE_INDEX = "image_index"
    private var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        changeImageButton = findViewById(R.id.changeImageButton)

        changeImageButton.setOnClickListener {
            // Генерация случайного индекса
            val randomIndex = Random.nextInt(images.size)
            // Установка нового изображения
            currentImageIndex = randomIndex // Сохраняем индекс текущего изображения
            imageView.setImageResource(images[randomIndex])
        }

        savedInstanceState?.let {
            currentImageIndex = it.getInt(KEY_IMAGE_INDEX, 0)
            imageView.setImageResource(images[currentImageIndex])
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Сохранение текущего индекса изображения
        outState.putInt(KEY_IMAGE_INDEX, currentImageIndex)
    }
}
