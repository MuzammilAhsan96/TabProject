package com.example.tabproject.fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tabproject.dataclasses.DataStatus
import com.example.tabproject.R
import com.example.tabproject.adapters.StatusAdapter
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class StatusFragment : Fragment() {
    private lateinit var radapter: StatusAdapter
    private lateinit var radapter1: StatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)
        var items = fetchData(100)
        radapter = StatusAdapter(items)
        val rcv = view.findViewById<RecyclerView>(R.id.st_rv1)
        rcv.setHasFixedSize(true)
        rcv.adapter = radapter
        rcv.layoutManager = LinearLayoutManager(context)
    }

    private fun fetchData(size: Int): ArrayList<DataStatus> {
        val list = ArrayList<DataStatus>()
        val ilist = ArrayList<Int>()
        ilist.add(R.drawable.muzzu_image_m)
        ilist.add(R.drawable.adi)
        ilist.add(R.drawable.subhan)
        ilist.add(R.drawable.farru)
        ilist.add(R.drawable.mukku)
        list.add(
            DataStatus(
                R.drawable.muzzu_image_m,
                R.drawable.add,
                "My Status",
                "Tap to add status update"
            )
        )
        for (i in 0..size) {
            if (i % 5 == 0)
                list.add(
                    DataStatus(
                        ilist[0],
                        0,
                        "Muzammil",
                        getMyPrettyDate(1628769852000, 12, 7, 2021).toString()
                    )
                )
            else if (i % 5 == 1)
                list.add(
                    DataStatus(
                        ilist[1],
                        0,
                        "Adnan",
                        getMyPrettyDate(1628765852000, 12, 7, 2021).toString()
                    )
                )
            else if (i % 5 == 2)
                list.add(
                    DataStatus(
                        ilist[2],
                        0,
                        "Subhan",
                        getMyPrettyDate(1628706600000, 12, 7, 2021).toString()
                    )
                )
            else if (i % 5 == 3)
                list.add(
                    DataStatus(
                        ilist[3],
                        0,
                        "Farhan",
                        getMyPrettyDate(1628706599000, 11, 7, 2021).toString()
                    )
                )
            else
                list.add(
                    DataStatus(
                        ilist[4],
                        0,
                        "Muzakkir",
                        getMyPrettyDate(1628772658000, 12, 7, 2021).toString()
                    )
                )
        }
        return list
    }

    //Function for printing date and time
    fun getMyPrettyDate(
        neededTimeMilis: Long,
        neededDate: Int,
        neededMonth: Int,
        neededYear: Int
    ): String? {
        val nowTime = Calendar.getInstance()
        val ctime = System.currentTimeMillis()
        println("Current time= " + ctime)
        val neededTime = Calendar.getInstance()
        neededTime.timeInMillis = neededTimeMilis
        println("time=" + nowTime.time + " " + nowTime.timeInMillis)
        neededTime[Calendar.YEAR] = neededYear
        neededTime[Calendar.MONTH] = neededMonth
        neededTime[Calendar.DATE] = neededDate
        if((nowTime.timeInMillis - neededTimeMilis)<60000)
        {
            return "Just Now"
        }
        else if ((nowTime.timeInMillis - neededTimeMilis)  < 3600000)
        {
            val date = SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Date(nowTime.timeInMillis))
            return (TimeUnit.MILLISECONDS.toMinutes(nowTime.timeInMillis - neededTimeMilis)).toString() + " minutes ago"
        }
        else
        {
            if(neededDate==nowTime[Calendar.DATE])
            return "Today, " + DateFormat.format("HH:mm", neededTime as Calendar).toString()
            else
            return "Yesterday, " + DateFormat.format("HH:mm", neededTime as Calendar).toString()
        }
    }


}