package mchehab.com.gridviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val listImageURLs = ArrayList<String>()

    private var gridView: GridView? = null
    private var gridViewAdapter: GridViewAdapter? = null

    private var width: Float = 0.toFloat()

    private var imageDimen = 100
    internal var count = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addImageURLs()

        val displayMetrics = resources.displayMetrics
        width = displayMetrics.widthPixels / displayMetrics.density
        count = width.toInt() / imageDimen
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
        }

        imageDimen = (width / count).toInt()

        gridView = findViewById(R.id.gridView)
        gridView!!.numColumns = count
        gridViewAdapter = GridViewAdapter(this, listImageURLs, imageDimen)
        gridView!!.adapter = gridViewAdapter
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putInt("count", count)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.one -> count = 1
            R.id.two -> count = 2
            R.id.three -> count = 3
            R.id.four -> count = 4
            R.id.five -> count = 5
            R.id.six -> count = 6
            R.id.seven -> count = 7
            R.id.eight -> count = 8
        }

        imageDimen = (width / count).toInt()
        gridViewAdapter!!.setImageDimen(imageDimen)
        gridView!!.numColumns = count

        return true
    }

    private fun addImageURLs() {
        listImageURLs.add("http://i.dailymail.co.uk/i/pix/2016/04/12/23/3319F89C00000578-3536787-image-m-19_1460498410943.jpg")
        listImageURLs.add("https://www.w3schools.com/css/img_forest.jpg")
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg")
        listImageURLs.add("https://www.w3schools.com/css/pineapple.jpg")
        listImageURLs.add("https://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg")
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg")
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg")
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg")
        listImageURLs.add("https://www.w3schools.com/css/lights600x400.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-11.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-15.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-19.jpg")
        listImageURLs.add("https://cdn.spacetelescope.org/archives/images/thumb700x/heic1509a.jpg")
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-12.jpg")
        listImageURLs.addAll(listImageURLs)
    }
}
