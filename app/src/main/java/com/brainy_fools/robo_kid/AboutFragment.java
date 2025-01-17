package com.brainy_fools.robo_kid;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {
    View root;
    private EditText editableWebLink;
    private String videoLink;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        root = inflater.inflate(R.layout.fragment_about, container, false);
        Button butt = root.findViewById(R.id.buttonWebLink);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editableWebLink = root.findViewById(R.id.inputVideoLink);
                Bundle bundle = new Bundle();
                bundle.putString("localWebLink", editableWebLink.getText().toString());
                EmbeddedFragment emb = new EmbeddedFragment();
                emb.setArguments(bundle);
                FragmentManager manager = getParentFragmentManager();
                manager.beginTransaction().replace(R.id.fragmentAbout, emb).commit();
//                assert getFragmentManager() != null;
//                getFragmentManager().beginTransaction().replace(R.id.embeddIDFragment, emb).commit();

//                getParentFragmentManager().setFragmentResult("fragmentSettings", bundle);
                editableWebLink.setText("");
            }
        });

//        videoLink = editableWebLink.getText().toString().trim();
//        Intent intent = new Intent(requireActivity().getApplicationContext(),EmbeddedFragment.class);
//        intent.putExtra("localWebLink",videoLink);
//        startActivity(intent);
        return root;
    }
}