package ie.wit.ufopedia.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import ie.wit.ufopedia.R
import ie.wit.ufopedia.databinding.ActivityUfoBinding
import ie.wit.ufopedia.main.MainApp
import ie.wit.ufopedia.models.UfoModel
import timber.log.Timber
import timber.log.Timber.i


class UfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUfoBinding
    var ufo = UfoModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("UFO Activity started...")

        binding.btnAdd.setOnClickListener() {
            ufo.title = binding.ufoTitle.text.toString()
            ufo.description = binding.description.text.toString()
            if (ufo.title.isNotEmpty()) {
                app.ufos.add(ufo.copy())
                i("Add button pressed: ${ufo}")
                for (i in app.ufos.indices)
                    { i("UFO[$i]:${this.app.ufos[i]}, ")
                }
                setResult(RESULT_OK)
                finish()
            }
            else {
                Snackbar
                    .make(it,"Please enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_ufo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}