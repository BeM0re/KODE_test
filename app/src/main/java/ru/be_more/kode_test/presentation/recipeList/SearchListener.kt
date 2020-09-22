package ru.be_more.kode_test.presentation.recipeList

import androidx.appcompat.widget.SearchView

class SearchListener(
private val listenerChanged: (String?) -> Unit,
private val listenerSubmit: (String?) -> Unit
): SearchView.OnQueryTextListener{
    override fun onQueryTextSubmit(query: String?): Boolean {
        listenerChanged.invoke(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        listenerSubmit.invoke(newText)
        return true
    }
}