package com.example.hongnhung.tytimeass.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.CompoundButtonCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.hongnhung.tytimeass.R;
import com.example.hongnhung.tytimeass.models.SearchRequest;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hongnhung on 26/02/2017.
 */

public class DialogChoiceFragment extends DialogFragment {


//    Button mBtn;

    @Bind(R.id.btn_dimiss)
    Button mBtDimiss;

    @Bind(R.id.checkbox_arts)
    CheckBox mCbArts;

    @Bind(R.id.checkbox_fashion)
    CheckBox mCbFashion;

    @Bind(R.id.checkbox_sport)
    CheckBox mCbSport;

    @Bind(R.id.edt_date)
    EditText mEdtDate;

    SearchRequest searchRequest = new SearchRequest();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dialog_choice, container, false);
        getDialog().setTitle("Simple Dialog");
        return rootView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        searchRequest.setBeginDate(mEdtDate.getText().toString());
        searchRequest.setPage(0);
//        searchRequest.setOrder("Oldes");

        mBtDimiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mCbArts.setOnCheckedChangeListener(new checkBoxChange());
        mCbFashion.setOnCheckedChangeListener(new checkBoxChange());
        mCbSport.setOnCheckedChangeListener(new checkBoxChange());


    }


    public class checkBoxChange implements CheckBox.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.checkbox_arts:
                    if (isChecked) {
                        Log.e("Arts", "check" + isChecked);

                    } else {
                        Log.e("Arts", "uncheck" + isChecked);
                    }
                    searchRequest.setHasArts(isChecked);
                    break;
                case R.id.checkbox_fashion:
                    if (isChecked) {
                        Log.e("fashion", "check" + isChecked);

                    } else {
                        Log.e("fashion", "uncheck" + isChecked);

                    }
                    searchRequest.setHasFashionAndstyle(isChecked);
                    break;
                case R.id.checkbox_sport:
                    if (isChecked) {
                        Log.e("sport", "check" + isChecked);
                        searchRequest.setHasSorts(isChecked);
                    } else {
                        Log.e("sport", "uncheck" + isChecked);
                        searchRequest.setHasSorts(isChecked);
                    }
                    Log.e("Sport", searchRequest.isHasSorts() + "");

                    break;
                default:
                    break;

            }

        }
    }

    ;


}
