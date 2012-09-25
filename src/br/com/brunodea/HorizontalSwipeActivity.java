package br.com.brunodea;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import br.com.brunodea.fragment.MyFragmentAdapter;

/**
 * Activity que tem um ViewPager em seu layout. Esse ViewPager faz a troca de conteúdo
 * utilizando Fragments através de MyFragmentAdapter.
 * 
 * @author bruno
 *
 */
public class HorizontalSwipeActivity extends FragmentActivity {
	public static final int NUM_FRAGS = 30;
	
	private ViewPager mViewPager;
	private MyFragmentAdapter mFragmentAdapter;
	
	private TextView mTextViewFooter;
	
	private int mCurrentFragPos;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.question);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        mCurrentFragPos = 0;
        
        mFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        
        mViewPager = (ViewPager)findViewById(R.id.viewpager_question);
        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				mCurrentFragPos = position;
				adjustFooterText(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int position) {
			}
		});
        
        mTextViewFooter = (TextView)findViewById(R.id.textview_question_center_footer);
    }
    
    public void adjustFooterText(int frag_position) {
    	if(mTextViewFooter != null) {
			String txt = "Semana do Coração <b>(" + (frag_position+1) + "/" + 
					NUM_FRAGS + ")<b>";
    		mTextViewFooter.setText(Html.fromHtml(txt));
    	}
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	adjustFooterText(mCurrentFragPos);
    }
}
