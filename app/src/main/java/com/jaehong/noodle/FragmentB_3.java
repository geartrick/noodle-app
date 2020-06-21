package com.jaehong.noodle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FragmentB_3 extends Fragment {

//    ArrayList<Noodles> al = new ArrayList<Noodles>();

    EditText editText;
    public FragmentB_3(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b_3, container, false);

        List<String> list = new ArrayList<>();
        final ArrayAdapter<String> adapter =
               new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list);
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String select = (String)adapter.getItem(position);
                Intent i = new Intent(getActivity(),Test.class);
               i.putExtra("title",select);
                startActivity(i);
            }
        });


        adapter.add("꼬꼬면") ;
        adapter.add("팔도비빔면") ;
        adapter.add("짜파게티") ;
        adapter.add("스파게티") ;
        adapter.add("신라면") ;
//        al.add(new Noodles("꼬꼬면")) ;
//        adapter.add("공화춘") ;
//        al.add(new Noodles("팔도비빔면")) ;
//        adapter.add("불닭볶음면") ;
//        adapter.add("바지락칼국수") ;
//        adapter.add("나가사키짬뽕") ;
//        al.add(new Noodles("짜파게티")) ;
//        al.add(new Noodles("스파게티")) ;
//        al.add(new Noodles("신라면")) ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;
//        adapter.add("꼬꼬면") ;






        return view;

    }
//    class ArrayAdapter{
//        String title="";
//
//        public ArrayAdapter(String title){
//            super();
//            this.title=title;
//        }
//        public ArrayAdapter(){
//
//        }

//    class ArrayAdapter extends BaseAdapter{
//
//        Context context;
//        int layout;
//        ArrayList<Noodles> al;
//        LayoutInflater inf;
//
//        public ArrayAdapter(Context context, int layout, ArrayList<Noodles> al){
//            this.context = context;
//            this.layout = layout;
//            this.al=al;
//            inf=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }
//
//        @Override
//        public int getCount() {
//            return al.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return al.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if(convertView==null){
//                convertView=inf.inflate(layout,null);
//            }
//
//            TextView textView=(TextView)convertView.findViewById(R.id.title);
//
//            Noodles n=al.get(position);
//            textView.setText(n.title);
//
//            return convertView;
//        }
//    }
//
//}



}