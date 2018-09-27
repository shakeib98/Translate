package com.example.shakeib.translate

import android.media.MediaActionSound
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PHRASE : AppCompatActivity() {

    var media:MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phrase)

        val arrayList= ArrayList<WordClass>()
        arrayList.add(WordClass("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going))
        arrayList.add(WordClass("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name))
        arrayList.add(WordClass("My name is","oyaaset...",R.raw.phrase_my_name_is))
        arrayList.add(WordClass("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling))
        arrayList.add(WordClass("I am feeling good","kuchi achit",R.raw.phrase_im_feeling_good))
        arrayList.add(WordClass("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming))
        arrayList.add(WordClass("Yes, I am coming?","hәә’ әәnәm",R.raw.phrase_yes_im_coming))
        arrayList.add(WordClass("I am coming","әәnәm",R.raw.phrase_im_coming))
        arrayList.add(WordClass("Lets go","yoowutis",R.raw.phrase_lets_go))
        arrayList.add(WordClass("Come here","әnni'nem",R.raw.phrase_come_here))

        val wordAdapter = CustomWordAdapter(this,arrayList,R.color.phraseCategoryColor)

        val listView = findViewById<ListView>(R.id.list_view_three)
        listView.setAdapter(wordAdapter)

        listView.setOnItemClickListener { parent, view, position, id ->
            val word = arrayList.get(position)
            releaseMediaPlayer()
            media = MediaPlayer.create(this,word.songID)
            media!!.start()
            media!!.setOnCompletionListener { releaseMediaPlayer() }

        }
    }
    private fun releaseMediaPlayer(){
        if(media!=null){
            media!!.release()
            media=null
        }
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }
}
