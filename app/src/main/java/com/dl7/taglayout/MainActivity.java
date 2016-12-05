package com.dl7.taglayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dl7.tag.TagLayout;
import com.dl7.tag.TagView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] mTagWords = new String[] {
            "Hello", "Android", "我是TagView",
            "This is a long string, This is a long string, This is a long string",
            "这是长字符串，这是长字符串，这是长字符串，这是长字符串"
    };
    private String[] mTagWords2 = new String[] {
            "Dota", "LOL", "Somebody",
            "Noting",
            "蓝色的小鸟",
    };
    private TagLayout mTagGroup;
    private Button mBtnAdd;
    private Button mBtnClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTagGroup = (TagLayout) findViewById(R.id.tag_group);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnClean = (Button) findViewById(R.id.btn_clean);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            Random random = new Random();

            @Override
            public void onClick(View v) {
                mTagGroup.addTag(mTagWords[random.nextInt(mTagWords.length)]);
            }
        });
        mBtnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTagGroup.cleanTags();
            }
        });
//        mTagGroup.setPressFeedback(true);
//        mTagGroup.setEnableRandomColor(true);
//        mTagGroup.setFitTagNum(3);
//        mTagGroup.setTagBgColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
//        mTagGroup.setTagBorderColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
//        mTagGroup.setTagTextColor(Color.WHITE);
//        mTagGroup.setTagShape(TagView.SHAPE_ARC);
//        mTagGroup.setBgColor(ContextCompat.getColor(this, android.R.color.white));
//        mTagGroup.setBorderColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
//        mTagGroup.setBorderWidth(1);
        mTagGroup.setTags(mTagWords);
        mTagGroup.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(String text) {
                Log.w("MainActivity", text);
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                if ("换一换".equals(text)) {
                    mTagGroup.updateTags(mTagWords2);
                }
            }

            @Override
            public void onTagLongClick(String text) {
                Log.e("MainActivity", text);
                Toast.makeText(MainActivity.this, "长点击："+text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
