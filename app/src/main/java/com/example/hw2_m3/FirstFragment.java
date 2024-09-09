package com.example.hw2_m3;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    TextView tvCounter;
    Button btnPlus;
    Button btnMinus;
    Button btnSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCounter = view.findViewById(R.id.tv_counter);
        btnPlus = view.findViewById(R.id.btn_plus);
        btnMinus = view.findViewById(R.id.btn_minus);
        btnSend = view.findViewById(R.id.btn_send);

        btnPlus.setOnClickListener(v -> {
            String newText = String.valueOf(Integer.parseInt(tvCounter.getText().toString()) + 1);
            tvCounter.setText(newText);
        });

        btnMinus.setOnClickListener(v -> {
            String newText = String.valueOf(Integer.parseInt(tvCounter.getText().toString()) - 1);
            tvCounter.setText(newText);
        });

        btnSend.setOnClickListener(v -> {
            String tvCounterText = tvCounter.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("box", tvCounterText);
            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).addToBackStack(null).commit();
        });
    }
}