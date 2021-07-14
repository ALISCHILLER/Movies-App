package com.msa.movie_msa.view.fragment

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.msa.movie_msa.R
import com.msa.movie_msa.databinding.FragmentBtnLnavMoviesBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Ali Soleimani on 08,May,2021
 * Github https://github.com/ALISCHILLER
 * Iran.
 */
@AndroidEntryPoint
class Btn_Nav_Movies_Fragment : Fragment() {
    private var _vBinding:FragmentBtnLnavMoviesBinding?=null
    private val vBinding get() = _vBinding!!
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _vBinding = FragmentBtnLnavMoviesBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController=findNavController(requireActivity(),R.id.navFragment)

        setupSmoothBottomMenu()


    }


    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(requireContext(), null)
        popupMenu.inflate(R.menu.menu_btn_nav)
        val menu = popupMenu.menu
        _vBinding?.smoothBar?.setupWithNavController(menu, navController)
    }


}