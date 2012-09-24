package br.com.brunodea;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;
import br.com.brunodea.fragment.MyFragmentAdapter;

/**
 * Activity que tem um ViewPager em seu layout. Esse ViewPager faz a troca de conteúdo
 * utilizando Fragments através de MyFragmentAdapter.
 * 
 * @author bruno
 *
 */
public class HorizontalSwipeActivity extends FragmentActivity {
	public static final int NUM_FRAGS = 3;
	
	private ViewPager mViewPager;
	private MyFragmentAdapter mFragmentAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                
        setContentView(R.layout.horizontal_swipe);
        
        mFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        
        mViewPager = (ViewPager)findViewById(R.id.viewpager_main);
        mViewPager.setAdapter(mFragmentAdapter);
    }
}
