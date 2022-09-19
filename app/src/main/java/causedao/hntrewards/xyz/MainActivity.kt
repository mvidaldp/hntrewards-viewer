package causedao.hntrewards.xyz

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set which app layout to load
        setContentView(R.layout.activity_main)
        // instantiate our webview and swipe refresh layout (pull/refresh gesture detection)
        val mWebView: WebView = findViewById(R.id.webView)
        val mSwipeRefreshLayout: SwipeRefreshLayout = findViewById(R.id.swipeContainer)

        // enable javascript and load the site
        mWebView.settings.javaScriptEnabled = true
        mWebView.loadUrl("https://www.hntrewards.xyz")

        // specify swipe pull/refresh listener action
        mSwipeRefreshLayout.setOnRefreshListener {
            // reload site and hide refreshing icon afterwards
            mWebView.reload()
            mSwipeRefreshLayout.isRefreshing = false
        }
    }
}