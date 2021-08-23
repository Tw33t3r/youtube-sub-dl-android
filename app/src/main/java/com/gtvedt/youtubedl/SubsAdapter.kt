package com.gtvedt.youtubedl

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

/*
 * this adapter is very similar to the adapters used for listview, except a ViewHolder is required
 * see http://developer.android.com/training/improving-layouts/smooth-scrolling.html
 * except instead having to implement a ViewHolder, it is implemented within
 * the adapter.
 */
//TODO update view with info now ported to subList
class SubsAdapter(
    private var subList: ArrayList<Sub>?,
    private val rowLayout: Int,
    private val mContext: Context
) :
    RecyclerView.Adapter<SubsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(
            rowLayout, viewGroup, false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val entry = subList!![i]
        viewHolder.myName.text = entry.name
        viewHolder.myName.setOnClickListener { v ->
            val tv = v as TextView
            Toast.makeText(mContext, tv.text, Toast.LENGTH_SHORT)
                .show()
                subList!!.forEach{
                    Log.d("sub adapter","$it")
                }
        }
        Log.d("subs","$subList")
        //viewHolder.pic.setImageResource(R.drawable.phone)
    }

    override fun getItemCount(): Int {
        return subList?.size ?: 0
    }

    fun submitSubs(subs: ArrayList<Sub>) {
        subList = subs
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myName: TextView = itemView.findViewById<View>(R.id.Name) as TextView
        //var pic: ImageView = itemView.findViewById<View>(R.id.picture) as ImageView

    }
}