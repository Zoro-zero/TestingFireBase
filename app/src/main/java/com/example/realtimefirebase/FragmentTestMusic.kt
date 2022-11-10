package com.example.realtimefirebase

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.realtimefirebase.databinding.FragmentTestMusicBinding

class FragmentTestMusic : Fragment() {
    private lateinit var binding: FragmentTestMusicBinding
    private var number=1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentTestMusicBinding.inflate(inflater,container,false)
        return binding.root
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.musicOne.setOnClickListener {
            val music = MediaPlayer.create(
                context,
                Uri.parse("https://firebasestorage.googleapis.com/v0/b/realtimefirebase-90481.appspot.com/o/Kwabs%20-%20Walk.mp3?alt=media&token=ad9058e9-113c-48c6-af9f-3170fcf52392")
            )
            music.start()
        }
        binding.musicTwo.setOnClickListener {
            val music = MediaPlayer.create(
                context,
                Uri.parse("https://firebasestorage.googleapis.com/v0/b/realtimefirebase-90481.appspot.com/o/Kwabs%20-%20Walk.mp3?alt=media&token=ad9058e9-113c-48c6-af9f-3170fcf52392")
            )
            if (1==number){
                music.start()
                binding.musicTwo.text="pause"
                number++
            }else if (number==2){
                music.stop()
            }
        }
    }
}