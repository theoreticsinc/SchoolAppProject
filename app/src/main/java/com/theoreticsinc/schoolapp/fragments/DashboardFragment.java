package com.theoreticsinc.schoolapp.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.theoreticsinc.schoolapp.R;
import com.theoreticsinc.schoolapp.activities.DrawerActivity;
import com.theoreticsinc.schoolapp.activities.ListActivity;
import com.theoreticsinc.schoolapp.utils.BadgeView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

@TargetApi(11)
public class DashboardFragment extends Fragment {
    private static final int REQUEST_CODE = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static Context context;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        System.out.println("Parameters:" + param1 + " " + param2);
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ImageButton newsletterTarget = (ImageButton) view.findViewById(R.id.newsletterTarget);
        final BadgeView newsletterBadge = new BadgeView(context, newsletterTarget);
        //newsletterBadge.setBackgroundResource(R.drawable.badge_ifaux);
        newsletterBadge.setText("1");
        newsletterBadge.show();

        ImageButton newsletterButton = (ImageButton) view.findViewById(R.id.newsletterTarget);
        newsletterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ListActivity.class);
                startActivityForResult(i, REQUEST_CODE);
                //startActivity(i);
            }
        });

        ImageButton eventsTarget = (ImageButton) view.findViewById(R.id.eventsTarget);
        final BadgeView eventsBadge = new BadgeView(context, eventsTarget);
        eventsBadge.setText("5");
        eventsBadge.show();

        eventsTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment newpost = new ItemFragment();
                Bundle args = new Bundle();
                newpost.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, newpost).commit();
            }
        });

        ImageButton calendarTarget = (ImageButton) view.findViewById(R.id.calendarTarget);
        final BadgeView calendarBadge = new BadgeView(context, calendarTarget);
        calendarBadge.setText("18");
        calendarBadge.show();

        calendarTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageButton alertTarget = (ImageButton) view.findViewById(R.id.alertTarget);
        final BadgeView alertBadge = new BadgeView(context, alertTarget);
        alertBadge.setText("8");
        //alertBadge.setText("New");
        alertBadge.setTextColor(Color.BLUE);
        alertBadge.setBadgeBackgroundColor(Color.YELLOW);
        alertBadge.setTextSize(12);
        alertBadge.show();

        //ImageButton alertButton = (ImageButton) findViewById(R.id.alertTarget);
        alertTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment newpost = new AlertsListFragment();
                Bundle args = new Bundle();
                newpost.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, newpost).commit();

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
       /* if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }*/
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
