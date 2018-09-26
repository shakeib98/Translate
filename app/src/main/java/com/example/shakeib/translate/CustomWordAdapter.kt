package com.example.shakeib.translate

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.view.LayoutInflater
import android.widget.TextView


class CustomWordAdapter(context:Activity,word:ArrayList<WordClass>):ArrayAdapter<WordClass>(context,0,word) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.list_view_text, parent, false)
        }

        val currentWord= getItem(position)

        val textDefault = listItemView!!.findViewById<TextView>(R.id.default_transaltion)
        textDefault.setText(currentWord?.defaultTranslation)
        textDefault.setTextSize(25f)

        val textTranslation = listItemView.findViewById<TextView>(R.id.miwork_translation)
        textTranslation.setText(currentWord?.miworkTranslation)
        textTranslation.setTextSize(20f)

        return listItemView!!
    }
}