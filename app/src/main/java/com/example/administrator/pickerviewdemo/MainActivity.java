package com.example.administrator.pickerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.jaaksi.pickerview.adapter.NumericWheelAdapter;
import org.jaaksi.pickerview.util.Util;
import org.jaaksi.pickerview.widget.BasePickerView;
import org.jaaksi.pickerview.widget.DefaultCenterDecoration;
import org.jaaksi.pickerview.widget.PickerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PickerView<Integer> countyPickerView;
    private PickerView<Integer> landscapePickerView;
    private ImageView landscapeImageView;

    private String[] countyString = {
            "智利", "南韓", "葡萄牙", "吉布地", "紐西蘭",
            "馬爾他", "喬治亞", "模里西斯"
    };
    private List<String> countyList = new ArrayList<String>(Arrays.asList(countyString));

    private String[] chileLandscapeString = {
            "Patio Bellavista", "C-S-C", "Sky Costanera",
            "C-S-L", "D-de-A", "Rano Raraku",
            "P-G"
    };
    private String[] portugalLandscapeString = {
            "L-O", "J-M", "P-da-P",
            " ", " ", "Douro Valley",
            "Q-da-R"
    };
    private String[] testLandscapeString = {
            " ", " ", " ",
            " ", " ", " ",
            " "
    };
    private List<String> currentLandscapeStringList;

    private Integer[] chileLandscapeInteger = {
            R.drawable.chile_patio_bellavista2, R.drawable.chile_sky_costanera_skycostanera2, R.drawable.chile_sky_costanera_skycostanera2,
            R.drawable.chile_cerro_santa_lucia2, R.drawable.chile_desierto_de_atacama2, R.drawable.chile_rano_raraku2,
            R.drawable.chile_one_of_the_corner2
    };
    private Integer[] portugalLandscapeInteger = {
            R.drawable.portugal_lisbon_oceanarium2, R.drawable.portugal_jeronimos_monastery2, R.drawable.portugal_ponta_da_piedade2,
            R.drawable.question_mark2, R.drawable.question_mark2, R.drawable.portugal_the_douro_valley2,
            R.drawable.portugal_quinta_da_regaleira2
    };
    private Integer[] testLandscapeInteger = {
            R.drawable.question_mark2, R.drawable.question_mark2, R.drawable.question_mark2,
            R.drawable.question_mark2, R.drawable.question_mark2, R.drawable.question_mark2,
            R.drawable.question_mark2
    };
    private List<Integer> currentLandscapeIntegerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        landscapeImageView = findViewById(R.id.landscapeImageView);
        countyPickerView = findViewById(R.id.countyPickerView);
        landscapePickerView = findViewById(R.id.landscapePickerView);

        countyPickerView.setAdapter(new NumericWheelAdapter(1, 8));
        landscapePickerView.setAdapter(new NumericWheelAdapter(1, 7));

        countyPickerView.setVertical(true);
        countyPickerView.setTextSize(16, 20);                                                       // 第一個參數是指未focus的, 第二個參數是指正在focus的
        countyPickerView.setIsCirculation(true);
        landscapePickerView.setVertical(true);
        landscapePickerView.setTextSize(16, 20);                                                    // 第一個參數是指未focus的, 第二個參數是指正在focus的
        landscapePickerView.setIsCirculation(true);

        countyPickerView.setCanTap(false);
        countyPickerView.setDisallowInterceptTouch(false);
        landscapePickerView.setCanTap(false);
        landscapePickerView.setDisallowInterceptTouch(false);

        countyPickerView.setVisibleItemCount(5);
        countyPickerView.setItemSize(20);
        landscapePickerView.setVisibleItemCount(5);
        landscapePickerView.setItemSize(20);

        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(chileLandscapeString));
        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(chileLandscapeInteger));
        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));

        /** 格式化内容 */
        countyPickerView.setFormatter(new BasePickerView.Formatter() {
            @Override
            public CharSequence format(BasePickerView pickerView, int position,
                                       CharSequence charSequence) {
                return countyList.get(position);
            }
        });
        landscapePickerView.setFormatter(new BasePickerView.Formatter() {
            @Override
            public CharSequence format(BasePickerView pickerView, int position,
                                       CharSequence charSequence) {
                return currentLandscapeStringList.get(position);
            }
        });

        int margin = Util.dip2px(this, 2);
        DefaultCenterDecoration centerDecoration =
                new DefaultCenterDecoration(this).setLineColor(0xff99bfaa)
                        .setMargin(margin, -margin, margin, -margin)
                        .setLineWidth(3)
                        .setDrawable(0xff5c868d);
        countyPickerView.setCenterDecoration(centerDecoration);
        landscapePickerView.setCenterDecoration(centerDecoration);

        countyPickerView.setOnSelectedListener(new BasePickerView.OnSelectedListener() {
            @Override
            public void onSelected(BasePickerView basePickerView, int i) {
                switch (i) {
                    case 0:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(chileLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(chileLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                    case 1:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(testLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(testLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                    case 2:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(portugalLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(portugalLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                    case 3:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(testLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(testLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                    case 4:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(testLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(testLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                    case 5:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(testLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(testLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                    case 6:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(testLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(testLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                    case 7:
                        currentLandscapeStringList = new ArrayList<String>(Arrays.asList(testLandscapeString));
                        landscapePickerView.setSelectedPosition(0);
                        landscapePickerView.setCenterPosition(2);

                        currentLandscapeIntegerList = new ArrayList<Integer>(Arrays.asList(testLandscapeInteger));
                        landscapeImageView.setImageResource(currentLandscapeIntegerList.get(0));
                        break;
                }
            }
        });
        landscapePickerView.setOnSelectedListener(new BasePickerView.OnSelectedListener() {
            @Override
            public void onSelected(BasePickerView basePickerView, int i) {
                landscapeImageView.setImageResource(currentLandscapeIntegerList.get(i));
            }
        });
    }
}
