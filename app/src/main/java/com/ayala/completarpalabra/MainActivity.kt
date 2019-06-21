package com.ayala.completarpalabra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayala.completarpalabra.fragments.desarrollo
import kotlinx.android.synthetic.main.fragment_desarrollo.*

class MainActivity : AppCompatActivity(), desarrollo.SearchNewMovieListener {
    override fun nextWord() {

        val numero1 = tv_cont.getText().toString()
        val aux=numero1.toInt()
        tv_cont.text=((aux+1)).toString()
        /*var mIntent = Intent(this,  MainActivity:: class.java)
        mIntent.putExtra("contador", aux+1)
        mIntent.putExtra("palabra", listaaux[aux+1])

        this.startActivity(mIntent)*/
        tv_word.text=listaaux[aux]

    }


    val lista = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado")
    val listaaux= arrayOf("L n s", "M r s", "M e col s", "J e e", "V e n s", "S b d")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fDetalles= desarrollo()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().replace(R.id.container,fDetalles).commit()
    }
}
