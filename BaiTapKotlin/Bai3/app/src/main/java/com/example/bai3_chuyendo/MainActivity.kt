package com.example.bai3_chuyendo

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var edtF: EditText
    private lateinit var edtC: EditText
    private lateinit var btnFC: Button
    private lateinit var btnCF: Button
    private lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //anh xa
        edtF = findViewById(R.id.edtF)
        edtC = findViewById(R.id.edtC)
        btnFC = findViewById(R.id.btnFC)
        btnCF = findViewById(R.id.btnCF)
        btnClear = findViewById(R.id.btnClear)
        //xu ly

        btnFC.setOnClickListener {
            if (edtF.text.toString().isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập độ F", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val f = edtF.text.toString().toDouble()
            val c = (f - 32) * 5 / 9
            edtC.setText(c.toString())
        }
        btnCF.setOnClickListener {
            if (edtC.text.toString().isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập độ C", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val c = edtC.text.toString().toDouble()
            val f = c * 9 / 5 + 32
            edtF.setText(f.toString())
        }
        btnClear.setOnClickListener {
            edtF.setText("")
            edtC.setText("")
        }

    }
}