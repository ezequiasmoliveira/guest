package com.example.guest.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guest.R
import com.example.guest.constants.GuestConstants
import com.example.guest.databinding.FragmentAllGuestsBinding
import com.example.guest.view.adapter.GuestAdapter
import com.example.guest.view.listener.GuestListener
import com.example.guest.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var mViewModel: AllGuestsViewModel
    private var _binding: FragmentAllGuestsBinding? = null
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_all_guests)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter

        mListener = object : GuestListener{
            override fun onClick(id: Int) {
                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUEST_ID, id)

                val intent = Intent(context, GuestFromActivity::class.java)
                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.load()
            }
        }
        mAdapter.attachListener(mListener)

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }

    private fun observer(){
        mViewModel.guests.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}