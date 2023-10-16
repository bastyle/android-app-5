package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.ActivityChartBinding
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.ActivityCheckboxesBinding

//class ChartActivity(selectedItems:ArrayList<String>):AppCompatActivity() {
class ChartActivity():AppCompatActivity() {
    private lateinit var binding: ActivityChartBinding
    //private var selectedItems = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lineChartView = binding.lineChartView
        //selectedItems.add("Alberta")
        val selectedItems = intent.extras?.getStringArrayList("extra_data")
        if (selectedItems != null) {
            lineChartView.setData(selectedItems)
        }
    }

}