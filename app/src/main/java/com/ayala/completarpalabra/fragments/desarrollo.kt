package com.ayala.completarpalabra.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ayala.completarpalabra.R
import kotlinx.android.synthetic.main.fragment_desarrollo.view.*


class desarrollo : Fragment() {

    var listenerTool :  SearchNewMovieListener? = null

    interface SearchNewMovieListener{

        fun nextWord()



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_desarrollo, container, false).apply {

           /* findViewById<TextView>(R.id.tv_word).text = arguments?.getString("palabra")
            findViewById<TextView>(R.id.tv_cont).text = arguments?.getString("cont")*/
        }
        initSearchButton(view)

        return view

    }

    fun initSearchButton(container:View) = container.btn_verification.setOnClickListener {
        listenerTool?.nextWord()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchNewMovieListener) {
            listenerTool = context
        } else {
            throw RuntimeException("Se necesita una implementación de  la interfaz")
        }
    }
    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }



}
