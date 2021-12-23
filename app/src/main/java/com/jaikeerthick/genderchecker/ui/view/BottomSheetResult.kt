package com.jaikeerthick.genderchecker.ui.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jaikeerthick.genderchecker.R
import com.jaikeerthick.genderchecker.ui.model.GenderResponse
import com.jaikeerthick.genderchecker.databinding.BottomsheetResultBinding
import kotlin.random.Random

class BottomSheetResult(
    val user_name: String,
    val response: GenderResponse
): BottomSheetDialogFragment() {

    lateinit var binding: BottomsheetResultBinding

    //
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener { dialog1 ->
            val d = dialog1 as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            BottomSheetBehavior.from(bottomSheet as FrameLayout).state = BottomSheetBehavior.STATE_EXPANDED
            BottomSheetBehavior.from(bottomSheet).skipCollapsed = true
        }
        return dialog
    }
    //
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = BottomsheetResultBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun initUI(){

        val maleImagesList: List<Int> = listOf(R.drawable.male_1, R.drawable.male_2, R.drawable.male_3, R.drawable.male_4)
        val femaleImagesList: List<Int> = listOf(R.drawable.female_1, R.drawable.female_2, R.drawable.female_3, R.drawable.female_4, R.drawable.female_5)

        binding.nameText.text = "Hello, $user_name 👋"
        response.gender.let {
            when(it){
                "male" -> {
                    Glide.with(this)
                        .load(maleImagesList.random())
                        .into(binding.identifyImage)
                    binding.resultText.text = "Male ♂️"
                }
                "female" -> {
                    Glide.with(this)
                        .load(femaleImagesList.random())
                        .into(binding.identifyImage)
                    binding.resultText.text = "Female ♀️"
                }
            }
        }

    }
}