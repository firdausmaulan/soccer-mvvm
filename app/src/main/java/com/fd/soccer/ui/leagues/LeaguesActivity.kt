package com.fd.soccer.ui.leagues

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.widget.TextView
import com.fd.soccer.R
import com.fd.soccer.databinding.CountriesBottomSheetBinding
import com.fd.soccer.databinding.LeaguesActivityBinding
import com.fd.soccer.ui.base.BaseActivity
import com.fd.soccer.util.Constant
import com.google.android.material.bottomsheet.BottomSheetDialog


class LeaguesActivity : BaseActivity<LeaguesActivityBinding>() {

    override val bindingInflater: (LayoutInflater) -> LeaguesActivityBinding
        get() = LeaguesActivityBinding::inflate

    companion object {
        fun startIntent(activity: Activity): Intent {
            return Intent(activity, LeaguesActivity::class.java)
        }
    }

    override fun setupView(binding: LeaguesActivityBinding) {
        loadFragment(Constant.COUNTRY)
        binding.cvSetting.setOnClickListener { openCountriesDialog() }
    }

    private fun openCountriesDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val dialogBinding = CountriesBottomSheetBinding.inflate(bottomSheetDialog.layoutInflater)
        bottomSheetDialog.setContentView(dialogBinding.root)
        dialogBinding.tvEngland.setOnClickListener {
            onDialogItemClick(dialogBinding.tvEngland, bottomSheetDialog)
        }
        dialogBinding.tvItaly.setOnClickListener {
            onDialogItemClick(dialogBinding.tvItaly, bottomSheetDialog)
        }
        dialogBinding.tvSpain.setOnClickListener {
            onDialogItemClick(dialogBinding.tvSpain, bottomSheetDialog)
        }
        dialogBinding.tvGermany.setOnClickListener {
            onDialogItemClick(dialogBinding.tvGermany, bottomSheetDialog)
        }
        bottomSheetDialog.show()
    }

    private fun onDialogItemClick(textView: TextView, bottomSheetDialog: BottomSheetDialog) {
        val country = textView.text.toString()
        binding.tvSetting.text = country
        loadFragment(country)
        bottomSheetDialog.dismiss()
    }

    private fun loadFragment(country: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LeaguesFragment.newInstance(country))
            .commitNow()
    }
}