package com.example.pruebadrawnav.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pruebadrawnav.Adapters.SeccionAdapters;
import com.example.pruebadrawnav.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contenedor.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contenedor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contenedor extends Fragment {

    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    View vista;

    private OnFragmentInteractionListener mListener;

    public contenedor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contenedor.
     */
    // TODO: Rename and change types and number of parameters
    public static contenedor newInstance(String param1, String param2) {
        contenedor fragment = new contenedor();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista=inflater.inflate(R.layout.fragment_contenedor, container, false);

        View parent = (View) container.getParent();

        if(appBar == null){
            appBar = (AppBarLayout) parent.findViewById(R.id.appBar);
            pestanas = new TabLayout(getActivity());
            appBar.addView(pestanas);

            viewPager = (ViewPager) vista.findViewById(R.id.idViewPager);
            llenarviewPager(viewPager);

            viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }
            });
            pestanas.setupWithViewPager(viewPager);
        }


        return vista;
    }

    private void llenarviewPager(ViewPager viewPager) {

        SeccionAdapters adapter = new SeccionAdapters(getFragmentManager());
        adapter.addFragment(new a(),"AAA");
        adapter.addFragment(new b(),"BBB");
        adapter.addFragment(new c(),"CCC");

        viewPager.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
