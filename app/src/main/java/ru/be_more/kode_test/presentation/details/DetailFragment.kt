package ru.be_more.kode_test.presentation.details

import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.be_more.kode_test.presentation.ViewModelContract

class DetailFragment: Fragment() {

    private val viewModel: ViewModelContract.DetailViewModel by inject()
}