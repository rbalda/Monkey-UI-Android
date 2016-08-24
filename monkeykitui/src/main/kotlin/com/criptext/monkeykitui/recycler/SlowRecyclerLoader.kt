package com.criptext.monkeykitui.recycler

import android.content.Context
import android.os.Handler
import android.util.Log
import com.criptext.monkeykitui.conversation.ConversationsActivity
import java.lang.ref.WeakReference

/**
 * Created by gesuwall on 8/24/16.
 */

class SlowRecyclerLoader(val loadConversations: Boolean, recyclerActivity: Context): Handler() {

    var requestmessagesTimestamp = 0L
    val DEFAULT_DELAY_TIME = 300L
    var delayTime = DEFAULT_DELAY_TIME

    val activityRef: WeakReference<Context>

    init {
        activityRef = WeakReference(recyclerActivity)
    }

    fun delayNewBatch(loadedItems: Int){
        postDelayed( Runnable {
            if(loadConversations){
                val conversationsActivity = activityRef.get() as? ConversationsActivity
                conversationsActivity?.onLoadMoreConversations(loadedItems)
            } else {
                val chatActivity = activityRef.get() as? ChatActivity
                chatActivity?.onLoadMoreData(loadedItems)
            }
        }, delayTime)
    }

}
