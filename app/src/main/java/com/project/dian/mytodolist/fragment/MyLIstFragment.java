package com.project.dian.mytodolist.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.project.dian.mytodolist.R;
import com.project.dian.mytodolist.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class MyLIstFragment extends Fragment {



    public MyLIstFragment() {
        // Required empty public constructor
    }


    public static MyLIstFragment newInstance() {
        MyLIstFragment fragment = new MyLIstFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_my_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle(R.string.mytodolist);

        RecyclerView recyclerView = view.findViewById(R.id.list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);

        List<String> data = new ArrayList<String>(){
            {
                add("Bangun Tidur");
                add("Kerjain Tugas");
                add("Makan Malam");
                add("Kerjain Tugas Layweb");
                add("Kerjain Tugas SIK");
                add("Kerjain KP");
                add("Tidur Malam");
                add("Bangun Tidur");
                add("Kerjain Tugas");
                add("Makan Malam");
                add("Kerjain Tugas Layweb");
                add("Kerjain Tugas SIK");
                add("Kerjain KP");
                add("Tidur Malam");
                add("Bangun Tidur");
                add("Kerjain Tugas");
                add("Makan Malam");
                add("Kerjain Tugas Layweb");
                add("Kerjain Tugas SIK");
                add("Kerjain KP");
                add("Tidur Malam");
            }
        };

        listAdapter.addAll(data);
        listAdapter.setOnAdapterClick(new OnAdapterClick() {
            @Override
            public void onClick(String list, int position) {
                Toast.makeText(getActivity(),list, Toast.LENGTH_SHORT).show();
            }
        });

        listAdapter.setOnCheckBoxClick(new OnCheckBoxClick() {
            @Override
            public void onClick(String list, int position) {
                Toast.makeText(getActivity(),list + " Dianggap selesai ", Toast.LENGTH_SHORT).show();
            }
        });



    }


//viewholder

    private class ListViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView listTXT;
        public AppCompatCheckBox mycheckbox;



        public ListViewHolder(View itemView) {
            super(itemView);
            listTXT = itemView.findViewById(R.id.title_list);
            mycheckbox = itemView.findViewById(R.id.status);

        }
    }

//    adapter

    private class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

        private List<String> todolists;

        private OnAdapterClick onAdapterClick;
        private OnCheckBoxClick onCheckBoxClick;

        public void setOnAdapterClick(OnAdapterClick onAdapterClick) {
            this.onAdapterClick = onAdapterClick;
        }

        public void setOnCheckBoxClick(OnCheckBoxClick onCheckBoxClick) {
            this.onCheckBoxClick = onCheckBoxClick;
        }

        public ListAdapter() {

        }

        @Override
        public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent,false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ListViewHolder holder, int position) {
            final int pos = position;
            final String list = todolists.get(pos);
            holder.listTXT.setText(todolists.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onAdapterClick != null)
                        onAdapterClick.onClick(list, pos);

                }
            });
            holder.mycheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (onCheckBoxClick != null)
                        onCheckBoxClick.onClick(list, pos);
                }
            });



        }

        @Override
        public int getItemCount() {
            return todolists.size();
        }

        public void add(String list){
            todolists.add(list);
            notifyItemInserted(getItemCount() - 1);
        }

        public void addAll(List<String> todolists){
            if(this.todolists == null){
                this.todolists = todolists;
            }else {
                this.todolists.clear();
                this.todolists.addAll(todolists);
            }

            notifyDataSetChanged();
        }
    }

    private interface OnAdapterClick{
        void onClick(String list, int position);
    }

    private interface OnCheckBoxClick{
        void onClick(String list, int position);
    }
}
