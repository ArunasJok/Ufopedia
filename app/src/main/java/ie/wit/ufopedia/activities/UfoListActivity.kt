package ie.wit.ufopedia.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.wit.ufopedia.R
import ie.wit.ufopedia.databinding.ActivityUfoListBinding
import ie.wit.ufopedia.databinding.CardUfoBinding
import ie.wit.ufopedia.main.MainApp
import ie.wit.ufopedia.models.UfoModel

class UfoListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityUfoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUfoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = UfoAdapter(app.ufos)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, UfoActivity::class.java)
                startActivityForResult(launcherIntent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

class UfoAdapter constructor(private var ufos: List<UfoModel>) :
    RecyclerView.Adapter<UfoAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardUfoBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val ufo = ufos[holder.adapterPosition]
        holder.bind(ufo)
    }

    override fun getItemCount(): Int = ufos.size

    class MainHolder(private val binding : CardUfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ufo: UfoModel) {
            binding.ufoTitle.text = ufo.title
            binding.description.text = ufo.description
        }
    }

}

