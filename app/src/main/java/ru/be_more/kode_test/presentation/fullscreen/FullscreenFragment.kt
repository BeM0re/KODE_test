package ru.be_more.kode_test.presentation.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.fragment_fullscreen.*
import org.koin.android.ext.android.inject
import ru.be_more.kode_test.R
import ru.be_more.kode_test.presentation.ViewModelContract

class FullscreenFragment: Fragment() {

    private val viewModel: ViewModelContract.FullscreenViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_fullscreen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = requireArguments().getString("url")
        val name = requireArguments().getString("title")

        subscribe()
        initView(view, url)
        setListener(url, name)
    }

    private fun subscribe() {
        with(viewModel){
            downloadSuccess.observe(viewLifecycleOwner, { showSuccess(it) })
        }
    }

    private fun showSuccess(result: Boolean){
        if (result)
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Can't save", Toast.LENGTH_SHORT).show()
    }

    private fun setListener(url: String?, name: String?) {
        fab_download_photo.setOnClickListener {
            if (!url.isNullOrEmpty())
                viewModel.savePhoto(url, name?:"Recipe photo")
            else
                showSuccess(false)
        }
    }

    private fun initView(view: View, url: String?) {
        Glide.with(view)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(iv_fullscreen_photo)
    }

}