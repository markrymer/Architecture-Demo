package com.sky.architecturedemo.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.sky.architecturedemo.R
import com.sky.architecturedemo.presentation.uiModels.RatingPromptUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shouldPromptLiveData.observe(viewLifecycleOwner) {
            handleRatingPromptEvent(it)
        }
    }

    private fun handleRatingPromptEvent(uiModel: RatingPromptUiModel?) {
        uiModel?.let {
            if (it.shouldPrompt) {
                Toast
                    .makeText(requireContext(), getText(it.messageResourceId), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.onAppLaunched()
    }
}
