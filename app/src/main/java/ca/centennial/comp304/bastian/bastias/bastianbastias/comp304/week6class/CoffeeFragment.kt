package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.FragmentCoffeeBinding

class CoffeeFragment:Fragment() {

    companion object{
        private const val TAG = "CoffeeFragment"
    }


    private lateinit var binding: FragmentCoffeeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoffeeBinding.inflate(layoutInflater,container,false)
        Toast.makeText(requireActivity(),TAG.plus(" onCreateView executed"), Toast.LENGTH_SHORT).show()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        binding.submit.setOnClickListener {
            Toast.makeText(requireActivity(),TAG.plus(" Submit!!!"), Toast.LENGTH_SHORT).show()
            (requireActivity() as SecondActivity).inflateSecondFragment()
        }
    }
}