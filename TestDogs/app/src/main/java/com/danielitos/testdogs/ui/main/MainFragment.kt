package com.danielitos.testdogs.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielitos.testdogs.adapters.DogsAdapter
import com.danielitos.testdogs.databinding.FragmentMainBinding
import com.danielitos.testdogs.viewmodel.MainViewModel
import com.danielitos.testdogs.viewmodel.MainViewModelFactory

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private  val viewModel: MainViewModel by viewModels{ MainViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            rvList.layoutManager = LinearLayoutManager(activity)
            val adapter = DogsAdapter(emptyList())
            rvList.adapter = adapter

            viewModel.dogList.observe(requireActivity(), Observer {
                if(it.isNotEmpty()){
                    pbLoading.visibility = View.GONE
                    adapter.updateItems(it)
                }
            })
            viewModel.getDogsForList()
        }
    }
}