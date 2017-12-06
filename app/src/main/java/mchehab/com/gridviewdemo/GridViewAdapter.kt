package mchehab.com.gridviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation


/**
 * Created by muhammadchehab on 12/6/17.
 */

class GridViewAdapter(private val context: Context, private val listImageURLs: List<String>, private var imageDimension: Int) : BaseAdapter() {

    override fun getCount(): Int {
        return listImageURLs.size
    }

    override fun getItem(position: Int): Any {
        return listImageURLs[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null)
            viewHolder = ViewHolder()
            viewHolder.imageView = convertView!!.findViewById(R.id.imageView)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        val scale = context.resources.displayMetrics.density
        val pixels = (imageDimension * scale + 0.5f).toInt()

        viewHolder.imageView!!.layoutParams = LinearLayout.LayoutParams(pixels, pixels)

        Picasso.with(context)
                .load(listImageURLs[position])
                .transform(CropCircleTransformation())
                .into(viewHolder.imageView)

        return convertView
    }

    fun setImageDimen(imageDimension: Int) {
        this.imageDimension = imageDimension
    }

    internal inner class ViewHolder {
        var imageView: ImageView? = null
    }
}