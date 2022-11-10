package com.example.realtimefirebase

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import com.bumptech.glide.Glide
import com.example.realtimefirebase.databinding.FragmentTestMusicBinding
import com.example.realtimefirebase.databinding.FragmentVideoTestBinding

class VideoTestFragment : Fragment() {
    private lateinit var binding: FragmentVideoTestBinding
    var uri="https://firebasestorage.googleapis.com/v0/b/realtimefirebase-90481.appspot.com/o/%D0%92%D0%B0%D0%BD%20%D0%9F%D0%B8%D1%81%20%D1%84%D0%B8%D0%BB%D1%8C%D0%BC%2011%20Z%2C%20%D0%97%D0%BE%D1%80%D0%BE%20%D0%BF%D1%80%D0%BE%D1%82%D0%B8%D0%B2%20%D0%A1%D0%B0%D0%BD%D0%B4%D0%B6%D0%B8.mp4?alt=media&token=95311971-f211-493b-a626-c0531bb0fe00"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentVideoTestBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uri = Uri.parse(uri)
        binding.videoTest.setVideoURI(uri)
        binding.videoTest.requestFocus()
        binding.videoTest.start();
    }


}