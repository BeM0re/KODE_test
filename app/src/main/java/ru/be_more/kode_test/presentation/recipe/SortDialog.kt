package ru.be_more.kode_test.presentation.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_sort.*
import ru.be_more.kode_test.R

class SortDialog(val listener: (SortType) -> Unit ) : BottomSheetDialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.dialog_sort, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = true
        setListeners()
    }

    private fun setListeners(){
        dialog_sort_date.setOnClickListener {
            listener(SortType.BY_DATE)
            dismiss()
        }

        dialog_sort_name.setOnClickListener {
            listener(SortType.BY_NAME)
            dismiss()
        }

    }

    enum class SortType{
        BY_NAME, BY_DATE
    }
}