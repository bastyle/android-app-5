package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.ActivityCheckboxesBinding


class CheckboxesActivity:AppCompatActivity() {

    private lateinit var binding: ActivityCheckboxesBinding
    private var selectedItems = ArrayList<String>()

    companion object {
        private const val TAG = "CheckboxesActivity"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckboxesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val provinces = resources.getStringArray(R.array.provinces)
        val container = binding.container

        provinces.forEach {
            val checkBox = CheckBox(this)
            checkBox.text = it
            //checkBox.id=1
            container.addView(checkBox)
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    //val stockValues = resources.getStringArray(resources.getIdentifier(it, "array", packageName))
                    selectedItems.add(it)
                } else {
                    // Handle deselection if needed
                    selectedItems.remove(it)
                }
            }
        }

        binding.button3.setOnClickListener {
            Toast.makeText(this, "Button!!", Toast.LENGTH_SHORT).show()
            selectedItems.forEach{
                Log.e(TAG, it)
            }
            val intent = Intent(this, ChartActivity::class.java)
            intent.putExtra("extra_data",selectedItems)
            startActivity(intent)
        }

        //val lineChartView = findViewById<ChartView>(R.id.lineChartView)
        //selectedItems.add("Alberta")
        //lineChartView.setData(selectedItems)


    }


}