package com.example.tabproject.fragments

import android.os.Bundle
import java.util.Calendar
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tabproject.*
import com.example.tabproject.adapters.CallAdapter
import com.example.tabproject.dataclasses.DataCall

class CallsFragment : Fragment() {

    private lateinit var radapter: CallAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        var items = fetchData()
        radapter = CallAdapter(items)
        val rcv = view.findViewById<RecyclerView>(R.id.ch_rv1)
        rcv.setHasFixedSize(true)
        rcv.adapter = radapter
        rcv.layoutManager = LinearLayoutManager(context)
    }

    private fun fetchData(): ArrayList<DataCall> {
        val list = ArrayList<DataCall>()
        val ilist = ArrayList<Int>()
        ilist.add(R.drawable.muzzu_image_m)
        ilist.add(R.drawable.adi)
        ilist.add(R.drawable.subhan)
        ilist.add(R.drawable.farru)
        ilist.add(R.drawable.mukku)
        try {


        for (i in 0..100) {
            if (i % 5 == 0)
                list.add(DataCall(ilist[0], "Muzammil", getMyPrettyDate(29880000,12,8,2021).toString(), R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_call_made_24))
            else if (i % 5 == 1)
                list.add(DataCall(ilist[1], "Adnan", getMyPrettyDate(29880000,12,7,2021).toString(), R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_call_missed_24))
            else if (i % 5 == 2)
                list.add(DataCall(ilist[2], "Subhan", getMyPrettyDate(29880000,12,9,2020).toString(), R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_call_received_24))
            else if (i % 5 == 3)
                list.add(DataCall(ilist[3], "Farhan", getMyPrettyDate(29880000,11,7,2021).toString(), R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_call_made_24))
            else
                list.add(DataCall(ilist[4], "Muzakkir", getMyPrettyDate(29880000,14,6,2021).toString(),  R.drawable.ic_baseline_videocam_24,  R.drawable.ic_baseline_call_missed_24))
        }
        }catch (ex:Exception)
        {
            print(ex.message)
        }
        return list
    }

    //Function for printing date and time
    fun getMyPrettyDate(neededTimeMilis: Long,neededDate:Int, neededMonth:Int, neededYear:Int): String? {
        val nowTime = Calendar.getInstance()
        val neededTime = Calendar.getInstance()
        neededTime.timeInMillis = neededTimeMilis
        neededTime[Calendar.YEAR]=neededYear
        neededTime[Calendar.MONTH]=neededMonth
        neededTime[Calendar.DATE]=neededDate
        return if (neededYear == nowTime[Calendar.YEAR]) {
            if (neededMonth == nowTime[Calendar.MONTH]) {
                if (nowTime[Calendar.DATE] == neededDate) {
                    //here return like "Today at 12:00"
                    "Today at " + DateFormat.format("HH:mm", neededTime).toString()
                } else if (nowTime[Calendar.DATE] - neededDate == 1) {
                    //here return like "Yesterday at 12:00"
                    "Yesterday at " + DateFormat.format("HH:mm", neededTime).toString()
                } else {
                    //here return like "May 31, 12:00"
                    DateFormat.format("MMMM d, HH:mm", neededTime).toString().toString()
                }
            } else {
                //here return like "May 31, 12:00"
                DateFormat.format("MMMM d, HH:mm", neededTime).toString()
            }
        } else {
            //here return like "May 31 2010, 12:00" +- it's a different year we need to show it
            DateFormat.format("MMMM dd yyyy, HH:mm", neededTime).toString()
        }
    }

}


