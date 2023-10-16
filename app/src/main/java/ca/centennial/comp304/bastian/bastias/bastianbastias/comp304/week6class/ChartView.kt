package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.time.format.DecimalStyle


class ChartView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyle: Int=0) : View(context, attrs, defStyle) {

    private val paint = Paint()
    //private lateinit var data: Array<String>
    private var data: ArrayList<String> = ArrayList<String>()

    init {
        paint.color = Color.BLUE
        paint.strokeWidth = 4f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //arrayOf(attrs)
        //canvas.drawLine(0f,0f,300f,500f,paint)
        //canvas.drawLine(301f,501f,-300f,200f,paint)

        if(data !=null)
        data.forEach{
            //val stockValues = resources.getStringArray(resources.getIdentifier("${it}_values", "array", packageN))
            val values = context.resources.getStringArray(resources.getIdentifier("${it.replace(" ","_")}_values", "array", context.packageName))
            Log.e("Drawing: ",values.toString())
            /*values.forEach {
                canvas.drawLine(0f,0f,300f,500f,paint)
            }*/
            var auxX:Float=0f
            var auxY:Float=100f
            for (i in 1 until  values.size){
                canvas.drawLine(auxX,auxY,i*100f,values.get(i).toFloat(),paint)
                auxX=i*100f
                auxY=values.get(i).toFloat()
            }
        }
    }

    fun setData(data: ArrayList<String>) {
        this.data = data
        // Add any custom logic to handle the data
        invalidate() // Redraw the view if needed
    }
}