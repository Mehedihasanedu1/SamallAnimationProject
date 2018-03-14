package com.example.user.samallanimationproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
     private RecyclerView recyclerView;
     private  InformationAdaptar informationAdaptar;
     TextView textView;
     private RecyclerViewResponse recyclerViewResponse;
     private  RecyclerViewResponse recy;
     private  List<RecyclerViewResponse> userlist;

    ArrayList<RecyclerViewResponse> recyclerViewResponses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerViewResponses = new ArrayList<>();

      ///  recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  informationAdaptar = new InformationAdaptar(this,recyclerViewResponses);
      //  recyclerView.setAdapter(informationAdaptar);

        loadRecyclerViewData();
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                 String titlestring = userlist.get(position).getTitle();
                 String bodysting  = userlist.get(position).getBody();

                 Intent intent = new Intent(MainActivity.this, ShowDataActivity.class);

                 Bundle b = new Bundle();
                 b.putString("mes",titlestring);
                 b.putString("mes1",bodysting);



               // intent = new Intent(MainActivity.this, ShowDataActivity.class);

                intent.putExtras(b);
                startActivity(intent);

              //   startActivity(new Intent(MainActivity.this,ShowDataActivity.class));


                /*AlertDialog.Builder  dailog  = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.alartdailog_single_row,null,false);

                 TextView title= ll.findViewById(R.id.titlealart);
                 TextView body= ll.findViewById(R.id.bodyalart);

                   title.setText(titlestring);
                   body.setText(bodysting);

                dailog.setView(ll);
                AlertDialog  alertDialog = dailog.create();
                alertDialog.show();
                alertDialog.getWindow().setLayout(900, 1200);

                // Toast.makeText(MainActivity.this, "position"+position, Toast.LENGTH_SHORT).show();

               dailog.setView(ll);
               dailog.show();*/


            }
        }));

    }

    private void loadRecyclerViewData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data......");
        progressDialog.show();

        ApiSerVice apiSerVice = ApiClient.getRetrofit().create(ApiSerVice.class);

        Call<List<RecyclerViewResponse>> cal = apiSerVice.getInfomation();

        cal.enqueue(new Callback<List<RecyclerViewResponse>>() {
            @Override
            public void onResponse(Call<List<RecyclerViewResponse>> call, Response<List<RecyclerViewResponse>> response) {
                progressDialog.dismiss();

                userlist = response.body();
                recy = new RecyclerViewResponse(userlist);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                informationAdaptar = new InformationAdaptar(MainActivity.this,userlist);
                recyclerView.setAdapter(informationAdaptar);
            }

            @Override
            public void onFailure(Call<List<RecyclerViewResponse>> call, Throwable t) {

            }
        });
    }
}
