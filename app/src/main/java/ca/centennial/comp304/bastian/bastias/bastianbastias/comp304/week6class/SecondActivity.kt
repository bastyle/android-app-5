package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.ActivitySecondBinding

class SecondActivity:AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var coffeeFragment: CoffeeFragment
    private lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this,"Second",Toast.LENGTH_SHORT).show()

        coffeeFragment = CoffeeFragment()
        secondFragment = SecondFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val bundle = Bundle()

        fragmentTransaction.add(R.id.fragment_container_1, coffeeFragment, "CoffeeFragment")
        //fragmentTransaction.add(R.id.fragment_container_2, secondFragment, "SecondFragment")
        fragmentTransaction.commit()



    }
    //spinner type cofee
    //radio button size

    fun inflateSecondFragment(){
        //
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_1,secondFragment).commit()
        //supportFragmentManager.beginTransaction().add(R.id.fragment_container_1,secondFragment).commit()
    }
}