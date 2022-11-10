package com.example.realtimefirebase

import android.os.Bundle
import android.support.annotation.NonNull
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.realtimefirebase.databinding.FragmentImageBinding
import com.google.firebase.database.*
import com.squareup.picasso.Picasso


class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
binding= FragmentImageBinding.inflate(inflater,container,false)
    return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseDatabase= FirebaseDatabase.getInstance()
        databaseReference= firebaseDatabase.getReference()
        val getImage = databaseReference.child("image")

        getImage.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(
                    @NonNull dataSnapshot: DataSnapshot
                ) {
                    val link = dataSnapshot.getValue(
                        String::class.java
                    )

                    Picasso.get().load(link).into(binding.rImage)
                }

                override fun onCancelled(
                    @NonNull databaseError: DatabaseError
                ) {
                    Toast
                        .makeText(
                            requireContext(),
                            "Error Loading Image",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            })
    }


    }
