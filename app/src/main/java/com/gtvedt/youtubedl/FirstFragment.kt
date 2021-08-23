package com.gtvedt.youtubedl

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.findNavController
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DefaultItemAnimator

import androidx.recyclerview.widget.LinearLayoutManager

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var listRView: RecyclerView
    private lateinit var thisContext: Context
    private lateinit var model: DataViewModel

    private var subs: ArrayList<Sub> = arrayListOf(Sub("empty", "empty"))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var thisView = inflater.inflate(R.layout.fragment_first, container, false)

        listRView = thisView.findViewById(R.id.SubsView)
        listRView.layoutManager = LinearLayoutManager(thisContext)
        listRView.itemAnimator = DefaultItemAnimator()
        var adapter = SubsAdapter(subs, R.layout.subs_layout, thisContext)
        listRView.setAdapter(adapter)


        model = ViewModelProvider(requireActivity())[DataViewModel::class.java]
        model.getSubscriptions().observe(viewLifecycleOwner, { observedSubs ->
            subs = observedSubs
            subs.forEach{
                Log.d("fragment subs are: ", "$it")
            }
            adapter.submitSubs(subs)
        })

        Log.d("view", "$thisView")

        return thisView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        thisContext = context
    }
}