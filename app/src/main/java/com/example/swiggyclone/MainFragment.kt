package com.example.swiggyclone

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.hdodenhof.circleimageview.CircleImageView

class MainFragment : Fragment() {
    private lateinit var animatingTextView: TextView
    private var currentIndex = 0
    private val itemList = mutableListOf("Cake", "Pizza","Milk","Bread","Biryani")
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:CarouselAdapter
    private lateinit var llSearchBar: LinearLayout
    private lateinit var cv1:CardView
    private lateinit var cv2:CardView
    private lateinit var cv3:CardView
    private lateinit var cv4:CardView
    private lateinit var mic:ImageButton
    private lateinit var imgBntProfile: CircleImageView
    private lateinit var llLocation:LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_main,container,false)
        initViews(view)
        setOnClickListeners()
        startAnimation()
        val carouselItems = mutableListOf<String>("Event 1", "Event 2","Event 3", "Event 4")
        adapter = CarouselAdapter(carouselItems,requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter

        return view
    }

    private fun setOnClickListeners() {
        cv1.setOnClickListener {
            replaceFragment(Instamart())
        }
        cv2.setOnClickListener {
            replaceFragment(Dineout())
        }
        cv3.setOnClickListener {
            replaceFragment(Food())
        }
        cv4.setOnClickListener {
            replaceFragment(Genie())
        }
        mic.setOnClickListener{
            // Handle microphone button click

        }
        imgBntProfile.setOnClickListener {
            startActivity(Intent(requireContext(),ProfileActivity::class.java))
        }
        llSearchBar.setOnClickListener {
            startActivity(Intent(requireContext(),SearchActivity::class.java))
        }
        llLocation.setOnClickListener {
            startActivity(Intent(requireContext(),SetLocationActivity::class.java))
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Add the transaction to the back stack
            .commit()
    }

    private fun startAnimation() {

        val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.slide_up)
        animatingTextView.startAnimation(animation)

        animation.setAnimationListener(object: Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                currentIndex = (currentIndex+1)%itemList.size
                animatingTextView.text = itemList[currentIndex]
                startAnimation()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

    }

    private fun initViews(view: View) {
        animatingTextView = view.findViewById(R.id.animatingTextView)
        recyclerView = view.findViewById(R.id.recyclerView)
        llSearchBar =view.findViewById(R.id.llSearchBar)
        cv1 = view.findViewById(R.id.cv1)
        cv2 = view.findViewById(R.id.cv2)
        cv3 = view.findViewById(R.id.cv3)
        cv4 = view.findViewById(R.id.cv4)
        mic = view.findViewById(R.id.tmgBtnMic)
        imgBntProfile = view.findViewById(R.id.imgProfilePicture)
        llLocation = view.findViewById(R.id.llLocation)
    }
}