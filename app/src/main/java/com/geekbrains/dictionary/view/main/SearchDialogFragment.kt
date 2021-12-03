package com.geekbrains.dictionary.view.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.geekbrains.dictionary.databinding.DialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SearchDialogFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = SearchDialogFragment()
    }

    private var _binding: DialogBinding? = null
    private val binding get() = _binding!!

    private var onSearchClickListener: OnSearchClickListener? = null

    private val textWatcher = object : TextWatcher {

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (binding.searchEditText.text != null && binding.searchEditText.text.toString()
                    .isNotEmpty()
            ) {
                binding.searchButtonTextview.isEnabled = true
                binding.clearTextImageview.visibility = VISIBLE
            } else {
                binding.searchButtonTextview.isEnabled = false
                binding.clearTextImageview.visibility = GONE
            }
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun afterTextChanged(s: Editable) {}
    }

    private val onSearchButtonClickListener =
        View.OnClickListener {
            onSearchClickListener?.onClick(binding.searchEditText.text.toString())
            dismiss()
        }

    internal fun setOnSearchClickListener(listener: OnSearchClickListener) {
        onSearchClickListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchButtonTextview.setOnClickListener(onSearchButtonClickListener)
        binding.searchEditText.addTextChangedListener(textWatcher)
        addOnClearClickListener()
    }

    override fun onDestroyView() {
        onSearchClickListener = null
        super.onDestroyView()
    }

    private fun addOnClearClickListener() {
        binding.clearTextImageview.setOnClickListener {
            binding.searchEditText.setText("")
            binding.searchButtonTextview.isEnabled = false
        }
    }

    interface OnSearchClickListener {

        fun onClick(searchWord: String)
    }

}