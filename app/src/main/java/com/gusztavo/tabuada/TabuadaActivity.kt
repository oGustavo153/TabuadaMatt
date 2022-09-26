package com.gusztavo.tabuada

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide

class TabuadaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuada)


        Glide.with(this)
            .load(R.drawable.matt_handup)
            .into(findViewById(R.id.matt_handup))
    }

    fun muda (view : View)
    {
        val intent = Intent (this, QuizActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun ready(view: View){
        AlertDialog.Builder(this)
            .setMessage(getString(R.string.builder_message))
            .setTitle(getString(R.string.builder_title))
            .setPositiveButton("Sim!", DialogInterface.OnClickListener { _, _ -> muda(view)})
            .setNegativeButton("Não.", DialogInterface.OnClickListener { _, _ -> finish()})
            .setIcon(R.mipmap.matt_head)
            .show()
    }
}