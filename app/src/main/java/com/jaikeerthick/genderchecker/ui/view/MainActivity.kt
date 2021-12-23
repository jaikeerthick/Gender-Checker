package com.jaikeerthick.genderchecker.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.jaikeerthick.genderchecker.R
import com.jaikeerthick.genderchecker.databinding.ActivityMainBinding
import com.jaikeerthick.genderchecker.ui.model.GenderResponse
import com.jaikeerthick.genderchecker.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        initUI()
    }

    private fun initUI(){

        viewModel._response.observe(this, {
            if (it.gender == null){
                Toast.makeText(this, "Sorry.. try again later :(", Toast.LENGTH_SHORT).show()
            }else{
                openModal(binding.nameField.text.toString().trim(), it)
            }
            binding.loaderLayout.visibility = View.GONE
        })

        binding.checkBtn.setOnClickListener {
            if (binding.nameField.text.toString().trim().length>=2){
                binding.loaderLayout.visibility = View.VISIBLE
                viewModel.getGender(binding.nameField.text.toString().trim())
            }else{
                Toast.makeText(this, "Please enter a valid name!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.repositoryLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jaikeerthick")))
        }
        binding.apiLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://genderize.io/")))
        }
        binding.clearText.setOnClickListener {
            binding.nameField.text.clear()
        }

    }

    private fun openModal(username: String, response: GenderResponse){

        val modal = BottomSheetResult(user_name = username, response = response)
        modal.setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetTheme)
        modal.show(supportFragmentManager, "Modal")

    }
}