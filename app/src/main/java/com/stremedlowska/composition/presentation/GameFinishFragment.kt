package com.stremedlowska.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.stremedlowska.composition.databinding.FragmentGameFinishBinding

class GameFinishFragment : Fragment() {
    
    private val args by navArgs<GameFinishFragmentArgs>()
    
    private var _binding: FragmentGameFinishBinding? = null
    private val binding: FragmentGameFinishBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishBinding == null")
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
        binding.gameResult = args.gameResult
    }
    
    private fun setupClickListener() {
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    private fun retryGame() {
        findNavController().popBackStack()
    }
}