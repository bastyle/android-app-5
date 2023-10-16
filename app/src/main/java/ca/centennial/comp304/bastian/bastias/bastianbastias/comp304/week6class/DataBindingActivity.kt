package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.ActivityDataBindingBinding

class DataBindingActivity: AppCompatActivity() {

    private lateinit var binding : ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        binding.countryInfo = CountryInfo("USA", "Washington D.C.")
        registerForContextMenu(binding.textView1)

        binding.checkbox.setOnClickListener {
            if(binding.checkbox.isChecked) {
                Toast.makeText(this, "Checkbox selected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Checkbox unselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_button_1 -> {
                    Toast.makeText(this, "Radio Button 1 selected", Toast.LENGTH_SHORT).show()
                }

                R.id.radio_button_2 -> {
                    Toast.makeText(this, "Radio Button 2 selected", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Toggle Button selected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Toggle Button unselected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.switchView.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Switch Button selected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Switch Button unselected", Toast.LENGTH_SHORT).show()
            }
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.provinces)
        )
        binding.autoCompleteTextView.threshold = 1
        binding.autoCompleteTextView.setAdapter(adapter)

        binding.datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            Toast.makeText(this, "$dayOfMonth/${monthOfYear + 1}/$year", Toast.LENGTH_SHORT).show()
        }

        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            Toast.makeText(this, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.setting_menu_item -> {
                Toast.makeText(this, "Settings Menu Item Selected", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.account_info_menu_item -> {
                Toast.makeText(this, "Account Info Menu Item Selected", Toast.LENGTH_SHORT).show()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.copy_item -> {
                Toast.makeText(this, "Copy Context Menu Item Selected", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.edit_item -> {
                Toast.makeText(this, "Edit Context Menu Item Selected", Toast.LENGTH_SHORT).show()
                true
            }

            else -> {
                super.onContextItemSelected(item)
            }
        }
    }

}