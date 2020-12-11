package com.rnr.assignment.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rnr.assignment.R
import com.rnr.assignment.activties.MainActivity
import com.rnr.assignment.adapters.SliderAdapter
import com.rnr.assignment.models.TutorialModel
import kotlinx.android.synthetic.main.fragment_why_invest.*

/**
 * A simple [Fragment] subclass.
 */
class WhyInvest : Fragment() {

    internal lateinit var sliderAdapter: SliderAdapter
    internal var tutorialModelList: ArrayList<TutorialModel> = ArrayList()
    private var mContext: Context? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_why_invest, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = context as MainActivity
        activity.hideNavigation()

        tutorialModelList.apply {
            add(TutorialModel("Chapter 1/6", "Why buy Stocks?","We are a part of Equentis Wealth Advisory Services Pvt. Ltd. and are based in Mumbai (India). We are an independent Research & Equity Advisory firm working with select clients who subscribe to our unique approach of stock identification and investments.", R.drawable.s3))
            add(TutorialModel("Chapter 2/6", "Compound Magic","We are a part of Equentis Wealth Advisory Services Pvt. Ltd. and are based in Mumbai (India). We are an independent Research & Equity Advisory firm working with select clients who subscribe to our unique approach of stock identification and investments.", R.drawable.s2))
            add(TutorialModel("Chapter 3/6", "Get your growth","We are a part of Equentis Wealth Advisory Services Pvt. Ltd. and are based in Mumbai (India). We are an independent Research & Equity Advisory firm working with select clients who subscribe to our unique approach of stock identification and investments.", R.drawable.s1))
            add(TutorialModel("Chapter 4/6", "Invest with Us","We are a part of Equentis Wealth Advisory Services Pvt. Ltd. and are based in Mumbai (India). We are an independent Research & Equity Advisory firm working with select clients who subscribe to our unique approach of stock identification and investments.", R.drawable.s4))
            add(TutorialModel("Chapter 5/6", "Reach Milestone","We are a part of Equentis Wealth Advisory Services Pvt. Ltd. and are based in Mumbai (India). We are an independent Research & Equity Advisory firm working with select clients who subscribe to our unique approach of stock identification and investments.", R.drawable.s5))
            add(TutorialModel("Chapter 6/6", "Track your record","We are a part of Equentis Wealth Advisory Services Pvt. Ltd. and are based in Mumbai (India). We are an independent Research & Equity Advisory firm working with select clients who subscribe to our unique approach of stock identification and investments.", R.drawable.s6))


        }


        sliderAdapter = SliderAdapter(context!!, tutorialModelList)
        viewPager.setAdapter(sliderAdapter)
        viewPager.setClipToPadding(false);
        viewPager.setPadding(100,0,100,0);
        indicator.setupWithViewPager(viewPager, true)

        idBack.setOnClickListener {
            fragmentManager!!.popBackStack();
        }
    }




}
