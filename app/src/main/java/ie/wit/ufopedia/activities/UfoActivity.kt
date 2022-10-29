package ie.wit.ufopedia.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.wit.ufopedia.R
import ie.wit.ufopedia.databinding.ActivityUfoBinding
import ie.wit.ufopedia.models.UfoModel
import timber.log.Timber
import timber.log.Timber.i


class UfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUfoBinding
    var ufo = UfoModel()
    val ufos = ArrayList<UfoModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())
        i("Ufo Activity started...")

        binding.btnAdd.setOnClickListener() {
            ufo.title = binding.ufoTitle.text.toString()
            ufo.description = binding.description.text.toString()
            if (ufo.title.isNotEmpty()) {
                ufos.add(ufo.copy())
                i("Add button pressed: ${ufo}")
                for (i in ufos.indices)
                    { i("UFO[$i]:${this.ufos[i]}, ") }
            }
            else {
                Snackbar
                    .make(it,"Please enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}