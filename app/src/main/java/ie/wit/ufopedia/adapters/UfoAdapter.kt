package ie.wit.ufopedia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.ufopedia.databinding.CardUfoBinding
import ie.wit.ufopedia.models.UfoModel

interface UfoListener {
    fun onUfoClick(ufo: UfoModel)
}

class UfoAdapter constructor(private var ufos: List<UfoModel>,
                        private val listener: UfoListener):
    RecyclerView.Adapter<UfoAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardUfoBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val ufo = ufos[holder.adapterPosition]
        holder.bind(ufo, listener)
    }

    override fun getItemCount(): Int = ufos.size

    class MainHolder(private val binding : CardUfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ufo: UfoModel, listener: UfoListener) {
            binding.ufoTitle.text = ufo.title
            binding.description.text = ufo.description
            binding.root.setOnClickListener { listener.onUfoClick(ufo) }
        }
    }
}