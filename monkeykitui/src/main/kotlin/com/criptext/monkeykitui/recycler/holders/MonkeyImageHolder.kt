package com.criptext.monkeykitui.recycler.holders

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.criptext.monkeykitui.R
import com.criptext.monkeykitui.recycler.ChatActivity
import com.criptext.monkeykitui.recycler.MonkeyItem
import com.squareup.picasso.Picasso
import java.io.File

/**
 * Created by daniel on 4/12/16.
 */

open class MonkeyImageHolder : MonkeyHolder {


    var photoImageView : ImageView? = null

    constructor(view : View) : super(view) {
        photoImageView = view.findViewById(R.id.image_view) as ImageView
        sendingProgressBar?.indeterminateDrawable?.setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    open fun setDownloadedImage(file : File, context : Context){
        Picasso.with(context)
                .load(file)
                .resize(200, 200)
                .centerCrop()
                .into(photoImageView)
    }

    open fun setNotDownloadedImage(item : MonkeyItem, context: Context){
        /*
        val filePlaceholder = File(item.getPlaceholderFilePath())
        if(filePlaceholder.exists())
            Picasso.with(context)
                    .load(filePlaceholder)
                    .resize(200, 200)
                    .centerCrop()
                    .into(placeholderImageView)
        photoImageView!!.setImageBitmap(null)
        photoLoadingView!!.visibility = View.VISIBLE
        retryDownloadLayout!!.visibility = View.GONE
        */
    }

    open fun setRetryDownloadButton(position : Int, item: MonkeyItem, chatActivity: ChatActivity){
        /*
        retryDownloadLayout!!.visibility = View.VISIBLE
        retryDownloadLayout!!.setOnClickListener { chatActivity.onFileDownloadRequested(position, item) }
        */
    }

    open fun setOnClickListener(listener : View.OnClickListener){
        photoImageView!!.setOnClickListener(listener)
    }

}
