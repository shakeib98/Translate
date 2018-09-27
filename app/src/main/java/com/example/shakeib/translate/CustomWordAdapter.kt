package com.example.shakeib.translate

import android.app.Activity
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class CustomWordAdapter(context:Activity,word:ArrayList<WordClass>,var colorID:Int):ArrayAdapter<WordClass>(context,0,word) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.list_view_text, parent, false)
        }

        val textContainer = listItemView!!.findViewById<View>(R.id.linear_layout_horizontal)
        var color = ContextCompat.getColor(context,colorID)
        textContainer.setBackgroundColor(color)


        val currentWord= getItem(position)

        val textDefault = listItemView!!.findViewById<TextView>(R.id.default_transaltion).apply {
            setText(currentWord?.defaultTranslation)
            setTextSize(16f)
            setPadding(10,30,10,5)

        }

        val textTranslation = listItemView.findViewById<TextView>(R.id.miwork_translation).apply {
            setText(currentWord?.miworkTranslation)
            setTextSize(18f)
            setPadding(10,15,10,5)
            setTypeface(null,Typeface.BOLD)
        }


        val imageView = listItemView.findViewById<ImageView>(R.id.image_view)
        if(currentWord.getImageID()){
            imageView.setImageResource(currentWord.imageID)
        }else{
            imageView.setVisibility(View.GONE)
        }

        return listItemView!!
    }
}