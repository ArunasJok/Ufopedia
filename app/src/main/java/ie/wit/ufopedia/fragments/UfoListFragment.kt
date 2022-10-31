package ie.wit.ufopedia.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import ie.wit.ufopedia.R
import ie.wit.ufopedia.activities.UfoActivity
import ie.wit.ufopedia.adapters.UfoAdapter
import ie.wit.ufopedia.databinding.FragmentUfoListBinding
import ie.wit.ufopedia.main.MainApp
import ie.wit.ufopedia.models.UfoModel


class UfoListFragment : Fragment() {

    lateinit var app: MainApp
    private var _fragBinding: FragmentUfoListBinding? = null
    private val fragBinding get() = _fragBinding!!
    private lateinit var refreshIntentLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as MainApp
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragBinding = FragmentUfoListBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        activity?.title = getString(R.string.action_ufoList)

        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UfoListFragment().apply {
                arguments = Bundle().apply {}
            }
    }

}

