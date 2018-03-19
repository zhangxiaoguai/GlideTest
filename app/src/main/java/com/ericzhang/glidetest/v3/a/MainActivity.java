package com.ericzhang.glidetest.v3.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ericzhang.glidetest.R;

/**
 * 1
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private static final String jpegUrl = "https://images.pexels.com/photos/713148/pexels-photo-713148.jpeg?h=350&dpr=2&auto=compress&cs=tinysrgb";
    private static final String gifUrl = "http://p1.pstatp.com/large/166200019850062839d3";

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                loadImage();
                break;
            default:
                break;
        }
    }

    private void loadImage() {
        // 加载网络图片基本用法
//        Glide.with(this)
//                .load(jpegUrl)
//                .into(imageView);

        // 加载本地图片
//        File file = new File(getExternalCacheDir() + "/image.jpg");
//        Glide.with(this).load(file).into(imageView);

        // 加载应用资源
//        int resource = R.drawable.image;
//        Glide.with(this).load(resource).into(imageView);

        // 加载二进制流
//        byte[] image = getImageBytes();
//        Glide.with(this).load(image).into(imageView);

        // 加载Uri对象
//        Uri imageUri = getImageUri();
//        Glide.with(this).load(imageUri).into(imageView);

        // 使用占位符
        // 3.0方法
        // Glide 需要Fragment support库
        Glide.with(this)
//                .load(jpegUrl)
                .load(gifUrl)
                // 指定图片格式，必须紧跟在load之后指定
                // gif，加载时指定为bitmap则会显示第一帧
                // 静态图片，加载时指定为gif则会加载失败
                // 如果不指定则会自动判断图片源是gif还是静态图片
//                .asBitmap()
//                .asGif()
                // 指定占位图
                .placeholder(R.mipmap.placeholder)
                // 指定异常占位图
                .error(R.mipmap.error)
                // 禁用掉Glide的缓存功能，这里指定为NONE是为了看出占位图的效果
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                // 指定加载图片的尺寸，默认情况下Glide会自动根据ImageView的大小来决定图片的大小并缓存这个尺寸的大小
//                .override(200, 200)
                .into(imageView);
    }


}
