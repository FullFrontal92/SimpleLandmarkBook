package com.example.adambenyahia.ktllandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Big Ben")
        landmarkNames.add("Empire State Building")
        landmarkNames.add("Sainte Sophie")
        landmarkNames.add("Tour de Pise")
        landmarkNames.add("Tour Eiffel")

        val bigben = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.bigben)
        val empire = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.empirestatebuilding)
        val saintsophie = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.saintesophie)
        val pise = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.tourdepise)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.toureiffel)

        val landmarkImages = ArrayList<Bitmap>()

        landmarkImages.add(bigben)
        landmarkImages.add(empire)
        landmarkImages.add(saintsophie)
        landmarkImages.add(pise)
        landmarkImages.add(eiffel)

        val arrayAdapter =  ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)

        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i,l ->

            val intent = Intent(applicationContext,DetailActivity::class.java)
            intent.putExtra("name",landmarkNames[i])

            startActivity(intent)

        }

    }


}
