package com.example.realtimefirebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.realtimefirebase.databinding.FragmentBlankBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding
    private lateinit var dataBase: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBlankBinding.inflate(inflater,container,false)
      return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btSave.setOnClickListener{
            val name =binding.name.text.toString()
            val email =binding.email.text.toString()
            val number =binding.number.text.toString()
            dataBase= FirebaseDatabase.getInstance().getReference("Users")
            val user=User(name,email,number)
            dataBase.child(name).setValue(user).addOnSuccessListener {
                binding.name.text.clear()
                binding.email.text.clear()
                binding.number.text.clear()


                Toast.makeText(requireContext(), "Не все данные введены", Toast.LENGTH_SHORT).show()
            }
        }

    }


    }
