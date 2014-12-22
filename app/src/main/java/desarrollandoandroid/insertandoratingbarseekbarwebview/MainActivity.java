package desarrollandoandroid.insertandoratingbarseekbarwebview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private RatingBar mRatingBar;
    private TextView mRatingText;
    private SeekBar mSeekBar;
    private TextView mSeekText;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        mRatingText = (TextView) findViewById(R.id.textViewResultado);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSeekText = (TextView) findViewById(R.id.textViewSeekBar);
        mWebView = (WebView) findViewById(R.id.webView);
// Evitar redirección para que el enlace no se abra en el navegador y si en la propia app
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
// Cargamos la página en el webView
        mWebView.loadUrl("http://desarrollandoandroid.wordpress.com");

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String mtext = getResources().getString(R.string.resultadoVotacion);
                mRatingText.setText(String.valueOf(mtext + " " + rating));
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 42){
                    mSeekText.setBackgroundColor(0xff10ff76 + progress);
                }
                else if(progress < 84){
                    mSeekText.setBackgroundColor(0xff10ff76 + progress);
                }
                else{
                    mSeekText.setBackgroundColor(0xff10ff76 + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
