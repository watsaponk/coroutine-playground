package me.watsaponk.coroutineplayground.explorelist.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import me.watsaponk.coroutineplayground.R
import me.watsaponk.coroutineplayground.databinding.FragmentExploreListBinding

class ExploreListFragment : Fragment(R.layout.fragment_explore_list) {

    private val viewModel by viewModels<ExploreListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(FragmentExploreListBinding.bind(view)) {
            viewModel.state().observe(viewLifecycleOwner, {
                progressBar.visibility = View.GONE
                Log.d("ExploreListFragment", it.toString())
            })
        }
        viewModel.dispatch(ExploreListAction.InitialAction)
    }
}