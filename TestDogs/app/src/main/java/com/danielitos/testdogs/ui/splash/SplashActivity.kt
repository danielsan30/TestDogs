package com.danielitos.testdogs.ui.splash

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.danielitos.testdogs.utils.AppConstants.TAG
import com.danielitos.testdogs.databinding.ActivitySplashBinding
import com.danielitos.testdogs.ui.main.MainActivity
import com.danielitos.testdogs.utils.ShowDialog
import com.danielitos.testdogs.viewmodel.SplashViewModel
import com.danielitos.testdogs.viewmodel.SplashViewModelFactory


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModels { SplashViewModelFactory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            animationView.playAnimation()
            animationView.addAnimatorListener(object: AnimatorListener{
                override fun onAnimationStart(p0: Animator) {}

                override fun onAnimationEnd(p0: Animator) {}

                override fun onAnimationCancel(p0: Animator) {}

                override fun onAnimationRepeat(p0: Animator) {
                    //Log.i(TAG,"onAnimationRepeat")
                    splashViewModel.dogList.value?.let {
                        if(it.size>0){
                            animationView.pauseAnimation()
                            val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
                            startActivity(mainIntent)
                        }
                    }
                }
            })
        }

        splashViewModel.error.observe(this, Observer {msg ->
            Log.i(TAG,"observe: ${msg}")
            if(!msg.isNullOrEmpty()) {
                ShowDialog().showErrorDialog(this,msg)
            }
        })
        splashViewModel.getnVerifyDogs()
    }

}