package com.rnr.assignment.adapters

import android.content.Context
import android.graphics.Outline
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.rnr.assignment.R
import com.rnr.assignment.models.TutorialModel


/**
 * Created by Prateek on 14-Jan-20.
 */
class SliderAdapter(
    private val context: Context,
    private var list: List<TutorialModel>?) :
    PagerAdapter() {

    override fun getCount(): Int {
        return list!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_slider, null)

        val imageView = view.findViewById<ImageView>(R.id.ivImage)
        val tvChapter = view.findViewById<TextView>(R.id.tvChapter)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)


        Glide.with(context)
            .load(list!![position].image)
            .into(imageView)

        tvChapter.text= list!![position].chapter;
        tvTitle.text= list!![position].title;
        tvDescription.text= list!![position].description;

        Log.d("images",""+list!![position].image)


        val viewPager = container as ViewPager
        viewPager.addView(view, 0)

        /*top corner rounded*/
        val curveRadius = 20F

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            imageView.outlineProvider = object : ViewOutlineProvider() {

                @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                override fun getOutline(view: View?, outline: Outline?) {
                    outline?.setRoundRect(0, 0, view!!.width, (view.height+curveRadius).toInt(), curveRadius)
                }
            }

            imageView.clipToOutline = true

        }

        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }
}