package mx.edu.potros.examenunidad2_164785

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {

    var regalos = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var menuOption: String? = intent.getStringExtra("menuType")

        cargaRegalos(menuOption)
        var regalosAdapter: RegaloAdapter = RegaloAdapter(this, regalos)
        var grid: GridView = findViewById(R.id.regalos)
        grid.adapter = regalosAdapter


    }

    fun cargaRegalos(option: String?) {
        when(option){
            "Detalles" -> {
                regalos.add(Detalles(R.drawable.cumplebotanas, "280"))
                regalos.add(Detalles(R.drawable.cumplecheve, "320"))
                regalos.add(Detalles(R.drawable.cumpleescolar, "330"))
                regalos.add(Detalles(R.drawable.cumplepaletas, "190"))
                regalos.add(Detalles(R.drawable.cumplesnack, "150"))
                regalos.add(Detalles(R.drawable.cumplevinos, "370"))
            }
            "Globos" -> {
                regalos.add(Detalles(R.drawable.globoamor, "240"))
                regalos.add(Detalles(R.drawable.globocumple, "820"))
                regalos.add(Detalles(R.drawable.globofestejo, "260"))
                regalos.add(Detalles(R.drawable.globonum, "760"))
                regalos.add(Detalles(R.drawable.globoregalo, "450"))
                regalos.add(Detalles(R.drawable.globos, "240"))
            }
            "Peluches" -> {
                regalos.add(Detalles(R.drawable.peluchemario, "320"))
                regalos.add(Detalles(R.drawable.pelucheminecraft, "320"))
                regalos.add(Detalles(R.drawable.peluchepeppa, "290"))
                regalos.add(Detalles(R.drawable.peluches, ""))
                regalos.add(Detalles(R.drawable.peluchesony, "330"))
                regalos.add(Detalles(R.drawable.peluchestich, "280"))
                regalos.add(Detalles(R.drawable.peluchevarios, "195"))
            }
            "Regalos" -> {
                regalos.add(Detalles(R.drawable.regaloazul, "80"))
                regalos.add(Detalles(R.drawable.regalobebe, "290"))
                regalos.add(Detalles(R.drawable.regalocajas, "140"))
                regalos.add(Detalles(R.drawable.regalocolores, "85"))
                regalos.add(Detalles(R.drawable.regalos, "$"))
                regalos.add(Detalles(R.drawable.regalovarios, "75"))
            }
            "Tazas" -> {
                regalos.add(Detalles(R.drawable.tazaabuela, "120"))
                regalos.add(Detalles(R.drawable.tazalove, "120"))
                regalos.add(Detalles(R.drawable.tazaquiero, "260"))
                regalos.add(Detalles(R.drawable.tazas, "280"))
            }
        }
    }

    class RegaloAdapter: BaseAdapter {
        var regalos = ArrayList<Detalles>()
        var context: Context? = null

        constructor(context: Context, regalos: ArrayList<Detalles>): super() {
            this.regalos = regalos
            this.context = context
        }

        override fun getCount(): Int {
            return regalos.size
        }

        override fun getItem(p0: Int): Any {
            return regalos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var reg = regalos[p0]
            var inflador = LayoutInflater.from(context)
            var vista = inflador.inflate(R.layout.regalos, null)

            var imagen = vista.findViewById(R.id.iv_regalo_imagen) as ImageView
            var precio = vista.findViewById(R.id.tv_regalo_precio) as TextView

            imagen.setImageResource(reg.image)
            precio.setText("$${reg.precio}")
            return vista
        }
    }
}