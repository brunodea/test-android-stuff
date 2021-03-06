package br.com.brunodea.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.brunodea.HorizontalSwipeActivity;
import br.com.brunodea.R;

/**
 * Classe que determina o fragmento que vai ser visualizado no momento.
 * 
 * @author bruno
 *
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {

	public MyFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return HorizontalSwipeActivity.NUM_FRAGS;
	}
	
	@Override
    public CharSequence getPageTitle(int position) {
        return "Item #" + position;
    }
	
	@Override
	public Fragment getItem(int position) {
		Fragment fragment = new MyObjectFragment();
		Bundle args = new Bundle();
		args.putInt(MyObjectFragment.POS, position);
		fragment.setArguments(args);
		
		return fragment;
	}
	
	/**
	 * Classe que dá um inflate no ViewPager com o layout correto.
	 * 
	 * @author bruno
	 *
	 */
	public static class MyObjectFragment extends Fragment {
		public static final String POS = "position";
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, 
				Bundle savedInstanceState) {
			int position = getArguments().getInt(POS, 0);
			
			return inflater.inflate(getResourceLayout(position), container, false);
		}
		
		private int getResourceLayout(int position) {
			int layout = R.layout.content1;
			switch(position) {
			case 0:
				layout = R.layout.content1;
				break;
			case 1:
				layout = R.layout.content2;
				break;
			case 2:
				layout = R.layout.content3;
				break;
			default:
				layout = getResourceLayout(position % 3); //3 pq tem só content1,content2 e content3.
				break;
			}
			return layout;
		}
	}
}
















