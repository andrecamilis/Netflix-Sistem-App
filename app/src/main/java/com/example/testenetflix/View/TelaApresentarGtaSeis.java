package com.example.testenetflix.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;

public class TelaApresentarGtaSeis extends AppCompatActivity {
    VideoView videoView,videoView2;
    ImageView iv;

    Button proximo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_gta_seis);



        iv = (ImageView) findViewById(R.id.voltar3);
        videoView = (VideoView) findViewById(R.id.videoView4);

        // Streaming via online
       /* Uri uri = Uri.parse("https://rr2---sn-bg07dnre.googlevideo.com/videoplayback?expire=1703837305&ei=GSqOZc3cCdOKsfIPuP-78AU&ip=2600%3A3c01%3A%3Af03c%3A94ff%3Afebc%3Ada0f&id=o-AH11bW3s1tQ-8Wg-30wtB3cWcCGUbl30CBMDt8syQ3mQ&itag=18&source=youtube&requiressl=yes&xpc=EgVo2aDSNQ%3D%3D&siu=1&vprv=1&mime=video%2Fmp4&gir=yes&clen=1869650&ratebypass=yes&dur=18.026&lmt=1703815656443442&fexp=24007246&c=ANDROID_TESTSUITE&txp=6300224&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cxpc%2Csiu%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AJfQdSswRQIhAJS5pbO-rMX4AZkvZueSZxu6pjkAxfFv1w0kHVIfXdDmAiAKX1n8Saur9SJiP-a0AfEMivT_-_zHM_RBMd6_I5aNgQ%3D%3D&title=y2mate.bz+-+Composi%C3%A7%C3%A3o+1&redirect_counter=1&cm2rm=sn-n4vly7s&req_id=1122185b1661a3ee&cms_redirect=yes&mh=7o&mip=187.37.17.119&mm=34&mn=sn-bg07dnre&ms=ltu&mt=1703815472&mv=m&mvi=2&pl=19&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AAO5W4owRQIhAL7hULwDglMeOoTOLHYw1FT01ELTGuHYcYNXicSErefmAiBdbi0QWB_TM3xHxVU-V_h9Oa7MbsklSagHQDGc21SuXw%3D%3D");
        videoView.setVideoURI(uri);
        videoView.start();*/

        videoView.setVideoURI(Uri.parse("android.resource://" +getPackageName() + "/"+ R.raw.gtaseixvideoprincipal));
        videoView.start();




        // VÍDEO 2

        videoView2 = findViewById(R.id.videoView5);
        videoView2.setVideoURI(Uri.parse("android.resource://" +getPackageName() + "/"+ R.raw.gta_seis_trailer));
        videoView2.start();

       videoView2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent in = new Intent(getApplicationContext(), TelaCheiaGtaSeis.class);
               startActivity(in);


           }
       });

}


}
