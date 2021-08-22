package com.gtvedt.youtubedl

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.gtvedt.youtubedl.databinding.FragmentFirstBinding

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider





/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var listView: ListView
    private lateinit var model: DataViewModel
    private lateinit var subs: ArrayList<Sub>

    private val textViewObserver = Observer <ArrayList<Sub>> { observedSubs ->
        subs = observedSubs
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model = ViewModelProvider(requireActivity())[DataViewModel::class.java]
        model.getSubscriptions().observe(viewLifecycleOwner, textViewObserver)

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            Log.d("Frag1", "$subs")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}