package com.example.shashu.jsonpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class ComicsInfo extends AppCompatActivity {

    TextView txtComicInfoTitle;
    TextView txtComicInfoIsbn;
    TextView txtComicInfoModified;
    TextView txtComicInfoPagesCount;
    TextView txtComicInfoDescription;
    TextView txtComicInfoPrice;
    ImageView imgComicInfoThumbnail;
    TextView txtComicInfoTitleHeading;
    TextView txtComicInfoIsbnHeading;
    TextView txtComicInfoModifiedHeading;
    TextView txtComicInfoPagesCountHeading;
    TextView txtComicInfoDescriptionHeading;
    TextView txtComicInfoPriceHeading;
   // ImageView imgComicInfoThumbnailHeading;
//List<Price> price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_info);
//        Bundle bundle=getIntent().getExtras();
//        price=(List<Price>)bundle.getSerializable("prices");
//        txtComicInfoPrice.setText(price.get(0).getPrice());
        txtComicInfoTitle = findViewById(R.id.txtComicInfoTitle);
        txtComicInfoIsbn = findViewById(R.id.txtComicInfoIsbn);
        txtComicInfoModified = findViewById(R.id.txtComicInfoModified);
        txtComicInfoPagesCount = findViewById(R.id.txtComicInfoPagesCount);
        txtComicInfoDescription = findViewById(R.id.txtComicInfoDescription);
        txtComicInfoPrice = findViewById(R.id.txtComicInfoPrice);
        imgComicInfoThumbnail = findViewById(R.id.imgComicInfoThumbnail);
        txtComicInfoTitleHeading = findViewById(R.id.txtComicInfoTitleHeading);
        txtComicInfoIsbnHeading = findViewById(R.id.txtComicInfoIsbnHeading);
        txtComicInfoModifiedHeading = findViewById(R.id.txtComicInfoModifiedHeading);
        txtComicInfoPagesCountHeading = findViewById(R.id.txtComicInfoPagesCountHeading);
        txtComicInfoDescriptionHeading = findViewById(R.id.txtComicInfoDescriptionHeading);
        txtComicInfoPriceHeading = findViewById(R.id.txtComicInfoPriceHeading);
       // imgComicInfoThumbnailHeading = findViewById(R.id.imgComicInfoThumbnail);
        Intent intent = getIntent();

        //Info setText.....
        txtComicInfoTitle.setText(intent.getExtras().getString("title"));
        txtComicInfoIsbn.setText(intent.getExtras().getString("isbn"));
        txtComicInfoModified.setText(intent.getExtras().getString("modified"));
        txtComicInfoPagesCount.setText(intent.getExtras().getString("pages_count"));
        txtComicInfoDescription.setText(intent.getExtras().getString("description"));
        txtComicInfoPrice.setText(String.valueOf(intent.getExtras().getFloat("price")));
        //..................

        //HEADING setText.....
        txtComicInfoTitleHeading.setText("Title:");
        txtComicInfoIsbnHeading.setText("ISBN:");
        txtComicInfoModifiedHeading.setText("Modified:");
        txtComicInfoPagesCountHeading.setText("Pages Count:");
        txtComicInfoDescriptionHeading.setText("Description:");
        txtComicInfoPriceHeading.setText("Price:");
        //..................

        System.out.print(txtComicInfoPrice.getText().toString());
        Toast.makeText(this,txtComicInfoPrice.getText().toString(),Toast.LENGTH_LONG).show();
        Glide.with(imgComicInfoThumbnail.getContext()).load(intent.getExtras().getString("comic_image")).into(imgComicInfoThumbnail);
        //imgComicInfoThumbnail.setImageResource(intent.getExtras().getString("comic_image"));

    }
}
