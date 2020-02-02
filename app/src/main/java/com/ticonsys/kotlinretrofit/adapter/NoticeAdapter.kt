package com.ticonsys.kotlinretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ticonsys.kotlinretrofit.R
import com.ticonsys.kotlinretrofit.model.NoticeModels
import com.ticonsys.kotlinretrofit.model.NoticeboardDataX


class NoticeAdapter(
    var noticeModelList: MutableList<List<NoticeboardDataX>>,
    var mContext: Context
) : RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewLayout= LayoutInflater.from(mContext).inflate(R.layout.notice_item_layout,parent,false)
        return ViewHolder(viewLayout);
    }

    override fun getItemCount(): Int {
        return noticeModelList.size
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.titleTV.text=noticeModelList.get(position)[position].title
        holder.titleTV.text=noticeModelList.get(position)[position].short_description
        //  holder.descriptionTV.text=noticeModelList.get(position).noticeboardData[position].short_description

    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var detailsImageView: ImageView
        var editImageView: ImageView
        var suspendImageView: ImageView
        var deleteImageView: ImageView
        var titleTV: TextView
        var descriptionTV: TextView
        var dateTV: TextView

        init {
            titleTV = itemView.findViewById<View>(R.id.notice_title) as TextView
            descriptionTV =
                itemView.findViewById<View>(R.id.notice_description) as TextView
            dateTV = itemView.findViewById<View>(R.id.notice_date) as TextView
            detailsImageView =
                itemView.findViewById<View>(R.id.notice_view_details) as ImageView
            editImageView =
                itemView.findViewById<View>(R.id.notice_edit_details) as ImageView
            suspendImageView =
                itemView.findViewById<View>(R.id.notice_suspend_details) as ImageView
            deleteImageView =
                itemView.findViewById<View>(R.id.notice_delete_details) as ImageView
        }


    }

}