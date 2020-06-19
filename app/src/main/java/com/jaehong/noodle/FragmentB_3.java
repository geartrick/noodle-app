package com.jaehong.noodle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class FragmentB_3 extends Fragment {


    ListView listView = null;
    EditText editText;
    public FragmentB_3(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b_3, container, false);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1);

        final ListView listView = (ListView)view.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);



        editText=(EditText)view.findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editext) {
                String filterText=editext.toString();
                if(filterText.length()>0){
                    listView.setFilterText(filterText);
                }else {
                    listView.clearTextFilter();
                }
            }
        });

        adapter.add("꼬꼬면") ;
        adapter.add("신라면") ;
        adapter.add("공화춘") ;
        adapter.add("팔도비빔면") ;
        adapter.add("불닭볶음면") ;
        adapter.add("바지락칼국수") ;
        adapter.add("나가사키짬뽕") ;
        adapter.add("짜파게티") ;
        adapter.add("스파게티") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;
        adapter.add("꼬꼬면") ;






        return view;

    }



}
