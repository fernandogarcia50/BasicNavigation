package com.example.basicnavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.basicnavigation.MyApplication
import com.example.basicnavigation.R
import com.example.basicnavigation.database.DatabaseManager
import com.example.basicnavigation.database.User
import com.example.basicnavigation.databinding.FragmentLeftBinding
import com.example.basicnavigation.leftViewMode

class LeftFragment : Fragment() {
    private lateinit var binding: FragmentLeftBinding
    private val leftViewModel: leftViewMode by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLeftBinding.inflate(inflater,container,false)
        binding.btnSendName.setOnClickListener {
            val destination = LeftFragmentDirections.actionLeftFragmentToDestinationFragment(binding.etName.text.toString())
            NavHostFragment.findNavController(this).navigate(destination)
            leftViewModel.save(User(binding.id.text.toString().toInt(),binding.etName.text.toString()))
        }
      //  leftViewModel.save(User(6,"user6"))

        return binding.root
    }
}

