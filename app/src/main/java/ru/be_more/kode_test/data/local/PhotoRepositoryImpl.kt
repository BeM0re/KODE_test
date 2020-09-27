package ru.be_more.kode_test.data.local

import android.app.DownloadManager
import android.content.Context
import android.content.Context.DOWNLOAD_SERVICE
import android.net.Uri
import android.os.Environment
import android.util.Log

class PhotoRepositoryImpl(
    val context: Context
) : LocalContract.PhotoRepository{

    override fun savePhoto(url: String, name: String): Boolean {
        return try {
            val request = DownloadManager.Request(Uri.parse(url))
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED) // to notify when download is complete

            val manager = context.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            manager.enqueue(request)
            true
        } catch (ex: Exception ) {
            Log.e("M_PhotoRepositoryImpl","downloading error = $ex")
            false
        }
    }
}