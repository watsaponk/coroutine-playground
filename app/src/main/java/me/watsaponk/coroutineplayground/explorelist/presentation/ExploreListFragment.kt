package me.watsaponk.coroutineplayground.explorelist.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.watsaponk.coroutineplayground.R
import me.watsaponk.coroutineplayground.databinding.FragmentExploreListBinding
import me.watsaponk.coroutineplayground.explorelist.presentation.adapter.ExploreSubjectAdapter
import me.watsaponk.coroutineplayground.explorelist.presentation.extension.setVisibility
import me.watsaponk.coroutineplayground.explorelist.presentation.viewmodel.ExploreListViewModel
import me.watsaponk.coroutineplayground.explorelist.presentation.viewmodel.ExploreListViewState

@AndroidEntryPoint
class ExploreListFragment : Fragment(R.layout.fragment_explore_list) {

    private val viewModel by viewModels<ExploreListViewModel>()

    private var binding: FragmentExploreListBinding? = null

    private val exploreSubjectAdapter = ExploreSubjectAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExploreListBinding.bind(view)
        setupRecyclerView()
        with(viewModel) {
            state().observe(viewLifecycleOwner, ::render)
            dispatch(me.watsaponk.coroutineplayground.explorelist.presentation.viewmodel.ExploreListAction.LoadExploreSubjectAction)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun setupRecyclerView() {
        binding?.recyclerviewExploreSubject?.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = exploreSubjectAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun render(state: ExploreListViewState) {
        binding?.run {
            progressBar.setVisibility(state.isLoading)
            exploreSubjectAdapter.submitList(state.subjects)
        }
    }

}