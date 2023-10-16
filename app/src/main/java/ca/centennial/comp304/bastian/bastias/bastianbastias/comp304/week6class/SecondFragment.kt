package ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.FragmentSecondBinding

//import ca.centennial.comp304.bastian.bastias.bastianbastias.comp304.week6class.databinding.FragmentSecondBinding

class SecondFragment:Fragment() {

    companion object{
        private const val TAG = "SecondFragment"
    }



    private lateinit var binding: FragmentSecondBinding
    private lateinit var life_circle_array: ArrayList<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)
        Toast.makeText(requireActivity(),TAG.plus(" Second Fragment!"), Toast.LENGTH_SHORT).show()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //life_circle_array.add(TAG.plus(" onViewCreated executed"))
    }

    override fun onStart() {
        super.onStart()
    }
}