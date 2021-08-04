package com.example.implicitintent;

import static android.widget.Toast.*;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.implicitintent.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    Button buttonthird;
    EditText editurl;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                Toast.makeText(getActivity().getApplicationContext(), "hello", LENGTH_SHORT).show();
            }
        });
        buttonthird = view.findViewById(R.id.buttonthird);
        editurl = view.findViewById(R.id.editurl);
        buttonthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlstring = editurl.getText().toString();
                Toast.makeText(getActivity().getApplicationContext(), urlstring, LENGTH_SHORT).show();
//                Uri webpage = Uri.parse(urlstring);
//                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
//                    startActivity(intent);
//                intent to sending mail
                String [] addresses = {"vivek.kajal.0@gmail.com" , "vivekkajla540@gmail.com"};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "hellosubject");
                intent.putExtra(Intent.EXTRA_TEXT, urlstring);
//                intent.putExtra(Intent.EXTRA_STREAM, attachment);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}